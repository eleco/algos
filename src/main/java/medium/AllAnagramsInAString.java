package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagramsInAString {


    /*
    Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
     */

    public static void main(String[] args) {
        System.out.println(findAnagrams("basdbbbbca", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {


        List<Integer> ret = new ArrayList<Integer>();
        Map<Character, Integer> m = new HashMap<Character, Integer>();

        for (int i = 0; i < p.length(); i++) {
            m.merge(p.charAt(i), 1, (prev, one) -> prev + one);
        }

        int hi = 0;
        int lo = 0;

        while (hi < s.length()) {
            if (m.containsKey(s.charAt(hi))) {
                m.merge(s.charAt(hi), 1, (prev, one) -> prev - one);
            }
            hi++;

            if (hasAnagram(m)) {
                ret.add(lo);
            }
            if ((hi - lo) == p.length()) {
                if (m.containsKey(s.charAt(lo))) {
                    m.merge(s.charAt(lo), 1, (prev, one) -> prev + one);
                }
                lo++;
            }
        }

        return ret;
    }


    private static boolean hasAnagram(Map<Character, Integer> m) {
        return m.values().stream().allMatch(v -> v == 0);
    }

}
