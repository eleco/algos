package medium;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {

        int start = 0;
        int end = 0;
        String res = "";
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            res = String.valueOf(c);
            start = i - 1;
            end = i + 1;

            while (start >= 0 && c == s.charAt(start)) {
                res = c + res;
                start--;
            }

            while (end < s.length() && c == s.charAt(end)) {
                res = res + c;
                end++;
            }

            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                res = s.charAt(start) + res + s.charAt(start);
                start--;
                end++;
            }
            if (res.length() > max.length()) max = res;

        }
        return max;

    }
}
