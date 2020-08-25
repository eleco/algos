package easy;

import java.util.Stack;

public class MakeTheStringGreat {


    public static void main (String argsp[]) {
        System.out.println(makeGood("leEeetcode"));
    }
    public static String makeGood(String s) {

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {

            Character c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                Character p = stack.peek();
                if (
                        (Character.toUpperCase(p) == (Character.toUpperCase(c))) &&
                                (
                                        (Character.isLowerCase(p) && Character.isUpperCase(c)) || (Character.isLowerCase(c) && Character.isUpperCase(p))
                                )
                ) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

        }

        StringBuilder ret = new StringBuilder();
        while (!stack.isEmpty()) {
            ret.insert(0, stack.pop());
        }
        return ret.toString();

    }
}
