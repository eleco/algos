package medium;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {


    /**
     * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
     **/


    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);

        n1.right = n3;
        n1.left = n2;
        n3.right = n5;
        n3.left = n4;

        System.out.println(levelOrder_bfs(n1));
        System.out.println(levelOrder_dfs(n1));
    }

    static List<List<Integer>> levelOrder_bfs(TreeNode root) {

        if (root == null) return new ArrayList();

        List<List<Integer>> ret = new ArrayList();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            ArrayList<Integer> l = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode polled = q.poll();
                l.add(polled.val);
                if (polled.left != null) q.add(polled.left);
                if (polled.right != null) q.add(polled.right);
            }
            ret.add(l);

        }

        return ret;
    }

    static List<List<Integer>> levelOrder_dfs(TreeNode root) {

        if (root == null) return new ArrayList();
        List<List<Integer>> ret = new ArrayList();
        dfs(root, 0, ret);
        return ret;
    }

    static void dfs(TreeNode n, int lvl, List<List<Integer>> ret) {

        if (lvl + 1 > ret.size()) {
            List<Integer> cur = new ArrayList<>();
            ret.add(cur);
            cur.add(n.val);
        } else {
            ret.get(lvl).add(n.val);
        }
        if (n.left != null) {
            dfs(n.left, lvl + 1, ret);
        }

        if (n.right != null) {
            dfs(n.right, lvl + 1, ret);
        }

    }
}