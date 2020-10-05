package medium;

import java.util.HashMap;
import java.util.Map;

public class MinimumSubstring {

    /**
     * Given a string S and a string T, find the minimum window in S which will contain all the
     * characters in T in complexity O(n).
     */
    public static void main(String args[]) {
        System.out.println(minWindow("ADOBECODEBANC",  "ABC"));
    }

    public static String minWindow(String s, String t) {

        Map<Character, Integer> m = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {

            Character c = t.charAt(i);
            Integer existing = m.get(c);
            if (existing == null) {
                m.put(c, 1);
            } else {
                m.put(c, existing + 1);
            }
        }


        int hi = 0;
        int lo = 0;
        int minSize = Integer.MAX_VALUE;
        String result = "";
        int counter = t.length();

        while (hi < s.length()) {

            Character c = s.charAt(hi++);
            Integer v = m.get(c);
            if (v != null) {
                m.put(c, --v);
                if (v >= 0) counter--;
            }
            while (counter == 0 && lo < hi) {

                String candidate = s.substring(lo, hi);
                if (candidate.length() < minSize) {
                    result = candidate;
                    minSize = candidate.length();
                }
                c = s.charAt(lo++);
                v = m.get(c);
                if (v != null) {
                    if (v >= 0) counter++;
                    m.put(c, ++v);
                }
            }
        }
        return result;

    }

}
