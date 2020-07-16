package easy;

public class ReverseString {

    /*
    Given a string, reverse all of its characters and return the resulting string.
     */

    public static void main (String args[]) {
        char [] c = "cat".toCharArray();
        reverseString(c);
        System.out.println(c);
    }

    public static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = tmp;

        }
    }
}
