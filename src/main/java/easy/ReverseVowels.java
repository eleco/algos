package easy;

public class ReverseVowels {

    /**
     *  Given a string, reverse the vowels of it.
     * Note: In this problem y is not considered a vowel.
       */

    public static void main(String args[]) {
        System.out.println(reverseVowels("february"));
    }

    public static String reverseVowels(String s) {

        if (s == null || s.length() == 0) return s;

        StringBuilder ret = new StringBuilder();
        ret.setLength(s.length());
        int lo = 0;
        int hi = s.length() - 1;

        while (hi >= lo) {

            char c = s.charAt(lo);
            if (isVowel(c)) {
                while (!isVowel(s.charAt(hi)) && hi > lo) {
                    ret.setCharAt(hi, s.charAt(hi));
                    hi--;
                }
                if (isVowel(s.charAt(hi))) {
                    ret.setCharAt(lo, s.charAt(hi));
                    ret.setCharAt(hi, c);
                    lo++;
                    hi--;
                }

            } else {
                ret.setCharAt(lo, c);

                lo++;
            }


        }
        return ret.toString();


    }

    private static boolean isVowel(char c) {
        return "aeiouAEIOU".contains(c + "");
    }
}
