package medium;

import java.util.HashSet;
import java.util.Set;

public class LongestStringWithoutRepeatingCharacters {

    /*
    Given a string s, find the length of the longest substring without repeating characters.
     */

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdefgabcddd"));
    }

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
