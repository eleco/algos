package easy;

import java.util.Stack;

public class BackStringCompare {
    public static void main(String[] args) {
        /*
        Given two strings s and t, return true if they are equal when both are typed into empty text editors.
         '#' means a backspace character.
         */

        //Time O(N) and space O(N).
        System.out.println(comp("ab#c").equals(comp("ad#c")));
    }


    static Stack<Character> comp(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!c.equals('#')) {
                st.push(c);
            } else {
                if (!st.isEmpty()) {
                    st.pop();
                }
            }
        }
        return st;
    }
}
