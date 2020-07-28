package medium;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesinString_II {

    /*
    Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters
    from s and removing them causing the left and the right side of the deleted substring to concatenate together.

    We repeatedly make k duplicate removals on s until we no longer can.

    Return the final string after all such duplicate removals have been made.
     */


    public static void main(String args[]) {
        System.out.println(removeDuplicates("ddaaabbbdcccce",3));

    }

    public static String removeDuplicates(String s, int k) {


        StringBuilder sb = new StringBuilder();
        Stack<Node> stk = new Stack<Node>();

        for (int i = 0; i < s.length(); i++) {

            Character c = s.charAt(i);

            if (!stk.isEmpty()) {
                Node n = stk.peek();
                if (n.c == c) {
                    if (n.count < k) {

                        n.count++;
                        if (n.count >= k) stk.pop();
                    }
                } else {
                    n = new Node(c);
                    stk.push(n);
                }
            } else {
                Node n = new Node(c);
                stk.push(n);
            }

        }

        String ret = "";
        while (!stk.isEmpty()) {
            Node n = stk.pop();
            for (int i = 1; i <= n.count; i++) {
                ret = n.c + ret;
            }
        }
        return ret;
    }

    static class Node {
        public int count;
        public char c;

        public Node(char c) {
            this.count = 1;
            this.c = c;
        }
    }

}
