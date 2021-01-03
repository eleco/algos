package easy;


import utils.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaryPostOrderTraversal {

    public static void main(String[] args) {
        Node n3 = new Node(3, new ArrayList<>());
        Node n2 = new Node(2, new ArrayList<>());
        List<Node> children = List.of(n3, n2);
        Node n1 = new Node(1, children);
        System.out.println(postorder(n1));
    }

    public static List<Integer> postorder(Node root) {

        if (root == null) return new ArrayList();
        List<Integer> l = new ArrayList<Integer>();
        //rec(root,l);
        iter(root, l);
        return l;
    }

    private static void iter(Node root, List<Integer> l) {
        Stack<Node> ret = new Stack<Node>();

        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            for (Node c : n.children) stack.push(c);
            ret.push(n);
        }
        while (!ret.isEmpty()) {
            l.add(ret.pop().val);
        }
    }

    private static void rec(Node root, List<Integer> l) {
        for (Node n : root.children) {
            rec(n, l);
        }
        l.add(root.val);
    }

}
