package easy;

import utils.TreeNode;

public class SameTree {


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n3.right = n4;

        TreeNode p1 = new TreeNode(1);
        p1.left = n2;
        p1.right = n3;

        System.out.println(check(p1, n1));

    }

    private static boolean check(TreeNode p, TreeNode q) {

        if (q == null && p == null) return true;

        if (q == null || p == null) return false;

        if (q.val != p.val) return false;

        return check(p.right, q.right) && check(p.left, q.left);
    }
}
