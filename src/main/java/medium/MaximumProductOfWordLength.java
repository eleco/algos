package medium;

import java.util.HashMap;
import java.util.Map;

public class MaximumProductOfWordLength {

    /*
    Given a string array words, return the maximum value of length(word[i]) * length(word[j])
    where the two words do not share common letters. If no such two words exist, return 0.
     */
    public static void main(String[] args) {
        System.out.println(maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
    }

    public static int maxProduct(String[] words) {
        Map<String, int[]> m = new HashMap<>();
        for (String w : words) {
            int[] a = new int[26];
            for (int i = 0; i < w.length(); i++) {
                a[w.charAt(i) - 'a']++;
            }
            m.put(w, a);
        }


        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {

                if (i == j) continue;
                if (!overlap(words[i], words[j], m)) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }

        }
        return max;
    }

    public static boolean overlap(String a, String b, Map<String, int[]> m) {

        int[] aa = m.get(a);
        int[] ab = m.get(b);
        for (int i = 0; i < aa.length; i++) {
            if (aa[i] > 0 && ab[i] > 0) {
                return true;
            }
        }
        return false;


    }
}
