package medium;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AddOneRowToTree {

    /*
    Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.

    Note that the root node is at depth 1.
     */

    public TreeNode addOneRow(TreeNode root, int v, int d) {

        if (d==1) {
            return new TreeNode(v,root, null);
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<TreeNode> l = new ArrayList<>();
        l.add(root);

        int level=1;
        while(!q.isEmpty()) {
            if(level==d-1) break;
            l.clear();
            int qsize = q.size();
            for (int i=0;i<qsize;i++) {
                TreeNode poll = q.poll();
                if (poll.right!=null) {
                    q.add(poll.right);
                    l.add(poll.right);
                }
                if (poll.left!=null) {
                    q.add(poll.left);
                    l.add(poll.left);
                }
            }
            level++;
        }

        for (TreeNode n: l) {
            TreeNode newn_right = new TreeNode(v);
            TreeNode tmp =n.right;
            newn_right.right = tmp;
            n.right = newn_right;

            TreeNode newn_left = new TreeNode(v);

            tmp =n.left;
            newn_left.left = tmp;
            n.left = newn_left;
        }
        return root;
    }

}
