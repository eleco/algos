package easy;

import utils.TreeNode;

public class PathSum {

    /*
    Given the root of a binary tree and an integer targetSum, return true
    if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

    A leaf is a node with no children.
     */

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return rec(root, targetSum,0)   ;
    }

    boolean rec(TreeNode root, int targetSum, int curSum) {
        if (root==null) return false;

        curSum+=root.val;

        if (curSum==targetSum && root.right==null && root.left==null) return true;

        return rec(root.right, targetSum, curSum) || rec(root.left, targetSum, curSum);

    }

}
