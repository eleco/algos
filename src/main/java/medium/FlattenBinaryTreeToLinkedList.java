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

    static void flatten(TreeNode node) {

        if (node==null) return;

        /* for each node:
            - find the left node
            - go to the lowest level node on the right hand side of the left node
            - "cut and paste" right side of the tree to node found above
            - repeat on the right hand side
         */
        if (node.left!=null){
            TreeNode pre = node.left;
            while(pre.right!=null) pre=pre.right;
            pre.right=node.right;
            node.right = node.left;
            node.left=null;
        }
        flatten(node.right);


    }
}
