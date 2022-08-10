package easy;

import utils.TreeNode;

public class ConvertSortedArrayToBinaryTree {

    /*
    Given an integer array nums where the elements are sorted in ascending order,
    convert it to a height-balanced binary search tree.

    A height-balanced binary tree is a binary tree in which
    the depth of the two subtrees of every node never differs by more than one.
     */

    public static void main(String[] args) {
        TreeNode t  = sortedArrayToBST(new int[]{-10,-3,0,5,9});
        System.out.println(t);
    }

    static TreeNode sortedArrayToBST(int[] nums) {
        return dfs(0, nums.length-1, nums);
    }

    static TreeNode dfs(int lo, int hi, int []nums) {

        if (lo>hi) return null;
        int mid = lo + (hi-lo)/2;
        int num = nums[mid];
        TreeNode node = new TreeNode(num);
        node.left = dfs(lo,mid-1,nums);
        node.right = dfs(mid+1,hi,nums);

        return node;
    }
}
