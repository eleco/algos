package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestStringInChain {


    /*
    You are given an array of words where each word consists of lowercase English letters.
   wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.
    For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".

    A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
    Return the length of the longest possible word chain with words chosen from the given list of words.


     */

    public static void main(String[] args) {
        System.out.println(longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca" }));
    }

    static Map<String, Integer> mem;

    static public int longestStrChain(String[] words) {

        int max = 1;
        mem = new HashMap<>();
        Map<Integer, List<String>> m = new HashMap<>(); //map word length to words

        for (String s : words) {
            List<String> l = m.get(s.length());
            if (l == null) l = new ArrayList<>();
            l.add(s);
            m.put(s.length(), l);
        }

        for (String word : words) {
            max = Math.max(max, dfs(words, m, word));
        }

        return max;
    }


    static int dfs(String[] words, Map<Integer, List<String>> m, String curWord) {

        if (!m.containsKey(curWord.length() + 1)) return 1;

        if (mem.containsKey(curWord)) return mem.get(curWord);

        List<String> nextWords = m.get(curWord.length() + 1);

        int max = 1;
        for (String next : nextWords) {
            if (differByOneChar(next, curWord)) {
                max = Math.max(max, dfs(words, m, next) + 1);
            }
        }

        mem.put(curWord, max);
        return max;
    }


    static boolean differByOneChar(String w1, String w2) {
        int ptr1 = 0;
        int ptr2 = 0;
        int diffs = 0;
        while (ptr1 < w1.length()) {
            if (ptr2 < w2.length() && w1.charAt(ptr1) == w2.charAt(ptr2)) {
                ptr1++;
                ptr2++;
            } else {
                diffs++;
                ptr1++;
            }
        }
        return (diffs <= 1);
    }
}

