package hard;

import java.util.HashMap;

public class MinimumWindowSubstring {

    /**
     * Given two strings s and t, return the minimum window in s which will contain all the characters in t.
     * If there is no such window in s that covers all characters in t, return the empty string "".
     */
    public static void main(String[] args) {
        System.out.println(minWindow("ABDEFERASCASDAAD", "ABC"));
    }

    public static String minWindow(String s, String t) {

        String ret = "";
        int hi = 0;
        int lo = 0;
        int min = Integer.MAX_VALUE;

        HashMap<Character, Integer> m = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            m.merge(t.charAt(i), 1, (prev, one) -> prev + one);
        }

        while (hi < s.length()) {

            Character c = s.charAt(hi++);
            if (m.containsKey(c)) {
                m.merge(c, 1, (prev, one) -> prev - one);
            }

            while (hasAllChars(m)) {
                int size = hi - lo + 1;
                if (min > size) {
                    min = size;
                    ret = s.substring(lo, hi);
                }

                if (m.containsKey(s.charAt(lo))) {
                    m.merge(s.charAt(lo), 1, (prev, one) -> prev + one);
                }
                lo++;

            }

        }

        return ret;
    }

    private static boolean hasAllChars(HashMap<Character, Integer> m) {
        return m.values().stream().allMatch(v -> v <= 0);

    }

}
