package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationAllWords {

    /*

    You are given a string s and an array of strings words of the same length.
    Return all starting indices of substring(s) in s that is a concatenation of each word
    in words exactly once, in any order, and without any intervening characters.

    You can return the answer in any order.
     */

    public static void main(String[] args) {
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    }

    static int wordLength = 0;
    static int nbWords = 0;

    static List<Integer> findSubstring(String s, String[] words) {
        wordLength = words[0].length();
        nbWords = words.length;

        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : words) {
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }

        List<Integer> l = new ArrayList<>();

        int totalLength = wordLength * nbWords;
        for (int i = 0; i < s.length() - totalLength + 1; i++) {

            if (check(s, i, wordCount)) {
                l.add(i);
            }
        }
        return l;

    }


    static boolean check(String s, int i, Map<String, Integer> wordCount) {

        Map<String, Integer> remaining = new HashMap(wordCount);
        for (int j = 0; j < nbWords; j++) {

            String sub = s.substring(j * wordLength + i, (j + 1) * wordLength + i);
            Integer count = remaining.get(sub);
            if (count == null || count < 0) return false;
            remaining.put(sub, count - 1);
        }

        for (Integer c : remaining.values()) {
            if (c > 0) return false;
        }

        return true;

    }

}
