package hard;

import utils.TreeNode;

public class BinaryTreeCamera {

    /*
    You are given the root of a binary tree.
    We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.
    Return the minimum number of cameras needed to monitor all nodes of the tree.

     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode gc1 = new TreeNode(0);
        TreeNode gc2 = new TreeNode (0);
        TreeNode c1 = new TreeNode (0);
        c1.right = gc1;
        c1.left = gc2;
        root.right = c1;

        System.out.println(minCameraCover(root));
    }

    private static int nbCams = 0;

    public static int minCameraCover(TreeNode root) {
        nbCams = 0;
        return dfs(root) == -1 ? nbCams + 1 : nbCams;
    }

    //-1 = not_covered
    //1 = covered
    //2 = covered with cam

    //if either one of the children is not monitored, then parent needs a camera setup
    //if either of the children has a camera, then parent is covered and does not need a camera
    static int dfs(TreeNode node) {

        if (node == null) return 1;

        int right = dfs(node.right);
        int left = dfs(node.left);

        if (right == -1 || left == -1) {
            //add camera at parent to cover children nodes
            nbCams++;
            return 2;
        }

        if (right == 2 || left == 2) {
            return 1;
        }

        return -1;

    }
}
