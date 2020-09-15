package easy;

import utils.TreeNode;

public class MergeBinaryTrees {


    /*
    Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
    You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node.
    Otherwise, the NOT null node will be used as the node of new tree.
     */
    public static void main(String args[]) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n3.right = n4;

        TreeNode n21 = new TreeNode(10);
        System.out.println(mergeTrees(n1, n21));
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 != null && t2 != null) {
            t1.val = t1.val + t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
        } else if (t2 != null) {
            t1 = t2;
        }

        return t1;
    }
}

