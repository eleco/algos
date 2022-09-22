package easy;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    static String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();
        String[] w = s.split(" ");

        for (int i = 0; i < w.length; i++) {
            sb.append(rev(w[i]));
            if (i != w.length - 1) sb.append(" ");
        }
        return sb.toString();
    }

    static String rev(String s) {
        char[] c = s.toCharArray();

        for (int i = 0; i < c.length / 2; i++) {
            char tmp = c[i];
            c[i] = c[c.length - i - 1];
            c[c.length - i - 1] = tmp;
        }
        return new String(c);
    }
}
