package medium;

import java.util.HashSet;
import java.util.Set;

public class LongestStringWithoutRepeatingCharacters {

    /*
    Given a string s, find the length of the longest substring without repeating characters.
     */

    public static void main(String[] args) {

        System.out.println(Solution1.lengthOfLongestSubstring("abcdefgabcddd"));
        System.out.println(Solution2.lengthOfLongestSubstring("abcdefgabcddd"));
    }


    static class Solution1 {
        static int lengthOfLongestSubstring(String s) {

            if (s == null || s.length() == 0) return 0;
            if (s.length() == 1) return 1;

            int hi = 0;
            int lo = 0;
            Set<Character> set = new HashSet<>();
            int count = 0;

            while (hi < s.length()) {
                Character c = s.charAt(hi);
                if (!set.contains(c)) {
                    set.add(c);
                    count = Math.max(count, set.size());
                    hi++;
                } else {
                    while (set.contains(c)) {
                        set.remove(s.charAt(lo++));
                    }
                }
            }
            return count;
        }
    }

    static class Solution2 {
        public static int lengthOfLongestSubstring(String s) {
            int[] a = new int[128];
            int start = 0;
            int max = 0;
            int i = 0;

            while (i < s.length()) {
                char c = s.charAt(i);
                a[c]++;

                if (norepeat(a)) {
                    max = Math.max(max, i - start + 1);

                } else {
                    while (!norepeat(a)) {
                        c = s.charAt(start);
                        a[c]--;
                        start++;

                    }
                }
                i++;
            }
            return max;
        }

        static boolean norepeat(int[] a) {
            for (int j : a) {
                if (j > 1) return false;
            }
            return true;
        }
    }
}
