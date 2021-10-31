package easy;

import utils.TreeNode;

public class InvertBinaryTree {

    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n3.right = n4;
        System.out.println(n1);
        invert(n1);
        System.out.println(n1);

    }
    static void invert(TreeNode root) {
        if (root==null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = right;
        root.right= left;

        invert(root.left);
        invert(root.right);
    }
}
