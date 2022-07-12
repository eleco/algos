package medium;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    /*
    Given the root of a binary tree, imagine yourself standing on the right side of it,
    return the values of the nodes you can see ordered from top to bottom.
     */

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.right=n3; n1.left=n2;
        n2.right=n5;
        n3.right=n4;

        System.out.println(rightSideView_dfs(n1));
        System.out.println(rightSideView_bfs(n1));
    }


    static List<Integer> rightSideView_dfs(TreeNode root) {
        if (root==null) return new ArrayList<Integer>();
        List<Integer> l = new ArrayList<>();
        dfs(root, 0, l);
        return l;
    }


    static void dfs(TreeNode n, int lvl, List<Integer> l) {

        if (n==null) return;

        if (l.size()==lvl) {
            l.add(n.val);
        }
        dfs(n.right, lvl+1, l);
        dfs(n.left, lvl+1, l);
    }


    static List<Integer> rightSideView_bfs(TreeNode root) {
        if (root==null) return new ArrayList<Integer>();

       Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> ret = new ArrayList<>();

        while(!q.isEmpty()) {

            List<TreeNode> nodes = new ArrayList<>();
            while(!q.isEmpty()) nodes.add(q.poll());

            TreeNode rightMost = nodes.get(0);
            ret.add(rightMost.val);

            for (TreeNode n : nodes) {

                if (n.right!=null) q.add(n.right);
                if (n.left!=null) q.add(n.left);
            }
        }
        return ret;
    }
}
