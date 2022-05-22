package medium;

public class PalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
    }

    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (PalindromicSubstring.isPal(s, i, j)) count++;
            }
        }
        return count;
    }


    static boolean isPal(String s, int i, int j) {

        if (i > j) return true;
        if (s.charAt(i) != s.charAt(j)) return false;
        return PalindromicSubstring.isPal(s, i + 1, j - 1);
    }

}
