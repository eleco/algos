package hard;

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));

    }


    public static int longestValidParentheses(String s) {

        int max = 0;
        int invalidIdx = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);

            } else {
                if (stack.isEmpty()) invalidIdx = i;
                else {
                    stack.pop();
                    if (!stack.isEmpty()) {
                        max = Math.max(i - stack.peek(), max);

                    } else {
                        max = Math.max(i - invalidIdx, max);

                    }
                }

            }

        }
        return max;

    }

}
