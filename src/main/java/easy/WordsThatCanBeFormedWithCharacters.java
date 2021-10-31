package easy;

import java.util.Arrays;

public class WordsThatCanBeFormedWithCharacters {

    /*
    You are given an array of strings words and a string chars.
    A string is good if it can be formed by characters from chars (each character can only be used once).
    Return the sum of lengths of all good strings in words.
     */

    public static void main(String[] args) {
        System.out.println(countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
    }

    static int[] mchars = new int[26];

    static int countCharacters(String[] words, String chars) {

        for (int i = 0; i < chars.length(); i++) {
            mchars[chars.charAt(i) - 'a']++;
        }

        int len = 0;
        for (int i = 0; i < words.length; i++) {
            int[] copiedArray = Arrays.copyOf(mchars, mchars.length);
            if (canform(words[i], copiedArray)) len += words[i].length();
        }
        return len;
    }


    static boolean canform(String w, int[] c) {

        for (int i = 0; i < w.length(); i++) {
            if (c[w.charAt(i) - 'a'] > 0) c[w.charAt(i) - 'a']--;
            else return false;
        }
        return true;
    }
}

