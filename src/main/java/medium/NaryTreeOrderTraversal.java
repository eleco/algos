package medium;

import utils.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NaryTreeOrderTraversal {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node n1 = new Node(3, Collections.EMPTY_LIST);
        Node n2 = new Node(2, Collections.EMPTY_LIST);
        root.children = List.of(n1, n2);
        System.out.println(levelOrder(root));
    }


    static List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> ret = new ArrayList<>();
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {

            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node n = q.pop();
                l.add(n.val);
                for (Node c : n.children) {
                    q.offer(c);
                }
            }
            ret.add(l);
        }
        return ret;
    }
}
