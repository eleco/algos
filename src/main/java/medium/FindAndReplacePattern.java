package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {

/*
You have a list of words and a pattern, and you want to know which words in words matches the pattern.
A word matches the pattern if there exists a permutation of letters p so that
after replacing every letter x in the pattern with p(x), we get the desired word.
Return a list of the words in words that match the given pattern.      */

    public static void main(String args[]) {
        System.out.println(findAndReplacePattern(
                new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb"));

    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {

        if (words == null || words.length == 0) return new ArrayList();
        if (pattern == null) return new ArrayList();


        List<String> ret = new ArrayList<String>();
        for (String w : words) {

            Map<Character, Character> m = new HashMap<Character, Character>();
            if (w.length() != pattern.length()) continue;

            int i = 0;
            boolean patternFound = true;
            for (char c : w.toCharArray()) {
                if (!m.containsKey(c)) {
                    if (m.containsValue(pattern.charAt(i))) {
                        patternFound = false;
                        break;
                    }
                    m.put(c, pattern.charAt(i));
                } else {
                    if (m.get(c) != pattern.charAt(i)) {
                        patternFound = false;
                        break;
                    }
                }
                i++;
            }
            if (patternFound) ret.add(w);

        }
        return ret;

    }
}
