package easy;

import utils.TreeNode;

public class DiameterBinaryTree {

    /*Given the root of a binary tree, return the length of the diameter of the tree.

    The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

    The length of a path between two nodes is represented by the number of edges between them.

     */

    static int diameterMax = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxD(root);
        return diameterMax;
    }


    public static int maxD(TreeNode n) {
        if (n == null) return 0;

        int maxL = 0;
        int maxR = 0;
        if (n.left != null) {
            maxL = maxD(n.left);
        }
        if (n.right != null) {
            maxR += maxD(n.right);
        }
        diameterMax = Math.max(diameterMax, maxR + maxL);
        return Math.max(maxL, maxR) + 1;


    }

}
