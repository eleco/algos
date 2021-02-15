package medium;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLargestValueInTreeRow {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);

        n1.left=n3;
        n1.right=n5;

        System.out.println(largestValues_bfs(n1));
        System.out.println(largestValues_bfs(n1));
    }

    static List<Integer> largestValues_bfs(TreeNode root) {

        if (root == null) {
            return new ArrayList();
        }

        List<TreeNode> q = new ArrayList<>();
        List<Integer> largestValues = new ArrayList();

        q.add(root);

        while (!q.isEmpty()) {

            List<TreeNode> children = new ArrayList<>();
            while (!q.isEmpty()) children.add(q.remove(0));

            int localMax = Integer.MIN_VALUE;
            for (TreeNode tn : children) {
                localMax = Math.max(localMax, tn.val);
                if (tn.left != null) q.add(tn.left);
                if (tn.right != null) q.add(tn.right);
            }
            largestValues.add(localMax);
        }

        return largestValues;
    }


    static List<Integer> largestValues_dfs(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, 0, map);
        return new ArrayList(map.values());
    }

    static void dfs(TreeNode root, int level, Map<Integer, Integer> m) {

        if (root == null) {
            return;
        }

        if (m.get(level) == null) {
            m.put(level, root.val);
        } else {
            m.put(level, Math.max(root.val, m.get(level)));
        }

        dfs(root.left, level + 1, m);
        dfs(root.right, level + 1, m);
    }
}
