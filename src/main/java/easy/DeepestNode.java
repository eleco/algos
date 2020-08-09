package easy;

import utils.TreeNode;

public class DeepestNode {

    public static void main(String []args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n3.right = n4;
        System.out.println(maxDepth(n1));

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return rec(root, 1, 1);
    }


    static int rec(TreeNode node, int depth, int maxDepth) {


        int maxDepthLeft = maxDepth;
        int maxDepthRight = maxDepth;
        if (node.right != null) {
            maxDepthRight = rec(node.right, depth + 1, (int) Math.max(depth + 1, maxDepth));
        }

        if (node.left != null) {
            maxDepthLeft = rec(node.left, depth + 1, (int) Math.max(depth + 1, maxDepth));
        }

        return Math.max(maxDepthLeft, maxDepthRight);
    }
}

