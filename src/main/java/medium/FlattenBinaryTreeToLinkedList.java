package medium;

import utils.TreeNode;

public class FlattenBinaryTreeToLinkedList {

    /*
    Given the root of a binary tree, flatten the tree into a "linked list":

    The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
    The "linked list" should be in the same order as a pre-order traversal of the binary tree.
    */

    public static void main(String[] args) {
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);
        TreeNode n6=new TreeNode(6);
        n1.right=n5;
        n1.left=n2;
        n2.right=n4;
        n2.left=n3;
        n5.right=n6;
        flatten(n1);
        System.out.println(n1);
    }

    static void flatten(TreeNode root) {

        if (root==null) return;

        if (root.left!=null){
            TreeNode pre = root.left;
            while(pre.right!=null) pre=pre.right;
            pre.right=root.right;
            root.right = root.left;
            root.left=null;
        }
        flatten(root.right);


    }
}
