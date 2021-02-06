package easy;

import java.util.Stack;

public class ReverseOnlyLetters {

    /*
    Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place,
    and all letters reverse their positions.
     */

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters_2pass("Test1ng-Leet=code-Q!"));
        System.out.println(reverseOnlyLetters_1pass("Test1ng-Leet=code-Q!"));
        System.out.println(reverseOnlyLetters_2pass("?6C40E"));
        System.out.println(reverseOnlyLetters_1pass("?6C40E"));
    }

    public static String reverseOnlyLetters_2pass(String S) {

        Stack<Character> stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder(S);
        for (int i = 0; i < S.length(); i++) {
            Character c = S.charAt(i);
            if (Character.isLetter(c)) {
                stack.push(c);
            }
        }

        if (stack.isEmpty()) return S;

        int idx = 0;
        while (!stack.isEmpty()) {
            Character c = S.charAt(idx);
            if (Character.isLetter(c)) {
                sb.setCharAt(idx, stack.pop());
            }
            idx++;
        }
        return sb.toString();
    }


    public static String reverseOnlyLetters_1pass(String S) {

        StringBuilder sb = new StringBuilder(S);

        int hi = S.length() - 1;
        int lo = 0;
        while (hi > lo) {
            while (hi >= 0 && !Character.isLetter(sb.charAt(hi))) hi--;
            while (lo < S.length() && !Character.isLetter(sb.charAt(lo))) lo++;
            if (hi < lo) break;
            Character tmp = sb.charAt(hi);
            sb.setCharAt(hi, sb.charAt(lo));
            sb.setCharAt(lo, tmp);
            hi--;
            lo++;
        }
        return sb.toString();
    }

}
