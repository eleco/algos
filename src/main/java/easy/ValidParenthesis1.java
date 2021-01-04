package easy;

import java.util.Stack;

public class ValidParenthesis1 {

    /**
     *
     Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

     An input string is valid if:
     Open brackets must be closed by the same type of brackets.
     Open brackets must be closed in the correct order.
     */

    public static void main(String[] args) {
        System.out.println(isValid("()({})[]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c.equals(')')) {
                if (stack.isEmpty() || !stack.peek().equals('(')) return false;
                else stack.pop();
            } else if (c.equals(']')) {
                if (stack.isEmpty() || !stack.peek().equals('[')) return false;
                else stack.pop();
            } else if (c.equals('}')) {
                if (stack.isEmpty() || !stack.peek().equals('{')) return false;
                else stack.pop();
            } else stack.push(c);
        }

        return stack.isEmpty();
    }
}
