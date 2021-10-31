package easy;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindAllTheLonelyNodes {

    /*
    In a binary tree, a lonely node is a node that is the only child of its parent node.
    The root of the tree is not lonely because it does not have a parent node.

    Given the root of a binary tree, return an array containing the values of all lonely nodes in the tree.
    Return the list in any order.
     */

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n3.right = n4;
        System.out.println(getLonelyNodes(n1));
    }


    static List<Integer> getLonelyNodes(TreeNode root) {

        List<Integer> l = new ArrayList();
        rec(l, root, null);
        return l;
    }


    static void rec(List<Integer> l, TreeNode node, TreeNode parent) {

        if (node == null) return;

        if (parent != null && (
                (parent.right == null) || (parent.left == null))
        ) {
            l.add(node.val);
        }

        rec(l, node.right, node);
        rec(l, node.left, node);

    }
}

