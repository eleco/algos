package easy;

import utils.TreeNode;

public class LowestCommonAncestorOfBST {

    /*
    Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes
    in the BST.
    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined
     between two nodes p and q as the lowest node in T that has both p and q as descendants
     (where we allow a node to be a descendant of itself).”

     */


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;

        if ((p.val <= root.val && q.val >= root.val)
                || (p.val >= root.val && q.val <= root.val)
        ) {
            return root;
        }


        if (root.right != null && root.val < Math.min(q.val, p.val)) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }

    }
}
