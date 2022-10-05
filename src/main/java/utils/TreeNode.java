package utils;

public class TreeNode {
    public int val;
    public TreeNode left;
    public  TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public String toString() {
       return buildTree(this);
    }

    private String buildTree(TreeNode root) {
        if (root==null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val+" ");
        sb.append(buildTree(root.left));
        sb.append(buildTree(root.right));
        return sb.toString();
    }
}