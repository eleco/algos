package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SentenceSimilarity {

    /**
     Given two sentences words1, words2 (each represented as an array of strings),
     and a list of similar word pairs pairs, determine if two sentences are similar.

     For example, "great acting skills" and "fine drama talent" are similar,
     if the similar word pairs are pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]].

     Note that the similarity relation is not transitive. For example, if "great" and "fine" are similar,
     and "fine" and "good" are similar, "great" and "good" are not necessarily similar.

     However, similarity is symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.

     Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar,
     even though there are no specified similar word pairs.

     Finally, sentences can only be similar if they have the same number of words.
     So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].


     */


    public static void main(String[] args) {
        String[][]pairs = new String[][]{
                {"great", "good"},{"great","excellent"},{"good", "fine"}
        };

        System.out.println(areSentencesSimilar(
                "Google is a good company",
                "Google is a great company",
                        pairs));

        System.out.println(areSentencesSimilar(
                "My performance is bad",
                "My performance is poor",
                pairs));
    }

    static boolean areSentencesSimilar(String sentence1, String sentence2, String[][] pairs) {

        Map<String, String> map = new HashMap<>();
        Map<String, Set<Integer>> colors = new HashMap<>();
        for (int i=0;i< pairs.length;i++) {
            String p1 = pairs[i][0];
            String p2 = pairs[i][1];
            Set<Integer>cs1 = colors.get(p1);
            if (cs1==null) cs1= new HashSet();
            cs1.add(i);
            colors.put(p1, cs1);

            Set<Integer>cs2 = colors.get(p2);
            if (cs2==null) cs2= new HashSet();
            cs2.add(i);
            colors.put(p2, cs2);

        }

        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        if (words1.length!= words2.length) return false;
        for (int i=0;i<words1.length;i++) {
            String w1 = words1[i];
            String w2 = words2[i];
            if (w1.equals(w2)) continue;
            if (colors.get(w1)==null || colors.get(w2)==null) return false;
            Set intersection = new HashSet(colors.get(w1));
            intersection.retainAll(colors.get(w2));
            if (intersection.isEmpty()) return false;
        }
        return true;


    }

}
