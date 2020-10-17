package easy;

import utils.TreeNode;

import java.util.*;

public class AverageTree {

    /*
    Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
    Example 1:
    Input:
        3
       / \
      9  20
        /  \
       15   7
    Output: [3, 14.5, 11]
    Explanation:
    The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
    */

    public static void main(String args[]) {
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);

        n3.left = n9;
        n3.right = n20;
        n20.left = n15;
        n20.right = n7;

        System.out.println(Arrays.asList(averageTree(n3)));
    }

    public static List<Double> averageTree(TreeNode root) {
        List<Double> ret = new ArrayList<Double>();

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {

            double d = 0;
            int nodes = 0;
            List<TreeNode> l = new ArrayList<TreeNode>();

            while (!q.isEmpty()) {
                l.add(q.poll());
            }

            for (int i = 0; i < l.size(); i++) {
                TreeNode node = l.get(i);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                d += node.val;
            }
            ret.add(d / (double) l.size());


        }
        return ret;

    }
}

