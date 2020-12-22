package medium;

import utils.TreeNode;

import java.util.*;

public class MostFrequentSubtreeSum {

    /*
    Given the root of a tree, you are asked to find the most frequent subtree sum.
    The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted
    at that node (including the node itself). So what is the most frequent subtree sum value?
    If there is a tie, return all the values with the highest frequency in any order.

     */
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(-5);
        TreeNode n3 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        System.out.println(n1);
        System.out.println(Arrays.toString(findFrequentTreeSum(n1)));

    }

    public static int[] findFrequentTreeSum(TreeNode root) {

        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        List<Integer> l = new ArrayList();

        dfs(root, m);

        int max = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            if (e.getValue() > max) max = e.getValue();
        }

        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            if (e.getValue() == max) l.add(e.getKey());
        }

        return l.stream().mapToInt(i -> i).toArray();

    }


    private static int dfs(TreeNode root, Map<Integer, Integer> m) {

        if (root == null) return 0;
        int s = dfs(root.left, m) + dfs(root.right, m) + root.val;
        m.merge(s, 1, Integer::sum);
        return s;

    }
}

