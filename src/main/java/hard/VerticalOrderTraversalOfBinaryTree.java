package hard;

import utils.TreeNode;

import java.util.*;

public class VerticalOrderTraversalOfBinaryTree {


    /*
    Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

    For each node at position (row, col), its left and right children will be at positions
    (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

    The vertical order traversal of a binary tree is a list of top-to-bottom orderings for
     each column index starting from the leftmost column and ending on the rightmost column.
      There may be multiple nodes in the same row and same column. In such a case,
       sort these nodes by their values.

    Return the vertical order traversal of the binary tree.
     */

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2; n1.right= n3;
        n3.left = n4; n3.right = n5;
        System.out.println(verticalTraversal(n1));
    }

    static List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ret = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> m = new TreeMap<>();
        dfs(m, 0, 0, root);

        for (Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> e : m.entrySet()) {
            List<Integer> l = new ArrayList();
            for (Map.Entry<Integer, PriorityQueue<Integer>> e2 : e.getValue().entrySet()) {
                PriorityQueue<Integer> q = e2.getValue();
                while (q != null && !q.isEmpty()) l.add(q.poll());
            }
            ret.add(l);
        }
        return ret;


    }


    static void dfs(TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> m, int col, int lvl, TreeNode root) {

        if (root == null) return;
        TreeMap<Integer, PriorityQueue<Integer>> nm = m.get(col);
        if (nm == null) nm = new TreeMap<>();

        PriorityQueue<Integer> q = nm.get(lvl);
        if (q == null) q = new PriorityQueue();
        q.add(root.val);
        nm.put(lvl, q);
        m.put(col, nm);

        TreeNode l = root.left;
        TreeNode r = root.right;
        dfs(m, col - 1, lvl + 1, l);
        dfs(m, col + 1, lvl + 1, r);
    }
}
