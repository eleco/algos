package medium;

import java.util.Stack;

public class MinimumRemoveForValidParentheses {

    /**
     * Given a string s of '(' , ')' and lowercase English characters.
     * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions )
     * so that the resulting parentheses string is valid and return any valid string.
     */
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("abc(d((d)"));
    }


    public static String minRemoveToMakeValid(String s) {

        Stack<Integer> stack = new Stack<Integer>();

        String[] cs = s.split("");
        for (int i = 0; i < cs.length; i++) {

            if (cs[i].equals(")")) {

                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    cs[i] = "";
                }
            } else if (cs[i].equals("(")) {
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            cs[stack.pop()] = "";
        }
        return String.join("", cs);

    }

}
