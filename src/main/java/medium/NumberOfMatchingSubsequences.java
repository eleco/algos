package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfMatchingSubsequences {

    /*
    Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.

    A subsequence of a string is a new string generated from the original string with some characters
     (can be none) deleted without changing the relative order of the remaining characters.

    For example, "ace" is a subsequence of "abcde".

     */

    public static void main(String[] args) {
        System.out.println(numMatchingSubseq("abcde", new String[]{"a","bb","acd","ace"}));
    }

    static Map<Integer, List<Integer>> m;

    static int numMatchingSubseq(String s, String[] words) {

        m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (m.containsKey(c)) {
                m.get(c).add(i);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                m.put(c, l);
            }
        }

        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            if (isSubseq(words[i], s)) ans++;
        }
        return ans;
    }


    static boolean isSubseq(String t, String s) {

        int lastPos = -1;
        for (int i = 0; i < t.length(); i++) {
            List<Integer> l = m.get(t.charAt(i) - 'a');
            if (l == null) return false;
            boolean found = false;
            for (Integer il : l) {
                if (il > lastPos) {
                    lastPos = il;
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }
}
