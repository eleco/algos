package medium;

import java.util.Stack;

public class ValidParenthesis2 {

    /*
    Given a string containing only three types of characters: '(', ')' and '*',
    write a function to check whether this string is valid. We define the validity of a string by these rules:

    Any left parenthesis '(' must have a corresponding right parenthesis ')'.
    Any right parenthesis ')' must have a corresponding left parenthesis '('.
    Left parenthesis '(' must go before the corresponding right parenthesis ')'.
    '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
    An empty string is also valid.
     */

    public static void main(String[] args) {
        System.out.println(checkValidString("(*)"));
    }

    public static boolean checkValidString(String s) {
        Stack<Integer> stackLeftP = new Stack<Integer>();
        Stack<Integer> stackStar = new Stack<Integer>();

        for (int i=0;i<s.length();i++) {

            Character c = s.charAt(i);
            if (c.equals(')')) {
                if (!stackLeftP.isEmpty()) {
                    stackLeftP.pop();
                } else if (!stackStar.isEmpty()) {
                    stackStar.pop();
                }
                else return false;
            }
            else if (c.equals('*')) {
                stackStar.push(i);
            }
            else if (c.equals('(')) {
                stackLeftP.push(i);
            }

        }

        while(!stackLeftP.isEmpty()) {
            if (stackStar.isEmpty()) return false;
            if (stackLeftP.pop()>stackStar.pop()) return false;
        }
        return true;



    }
}
