package easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MostCommonWords {

    /*
    Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
     It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
     */

    public static void main(String[] args) {
        System.out.println(mostCommonWord("a b d, d, e! b b", new String[]{"b"}));
    }


    public static String mostCommonWord(String paragraph, String[] banned) {

        paragraph = paragraph.toLowerCase();
        Map<String, Integer> map = new HashMap<String, Integer>();
        Set<String> bannedSet = Set.of(banned);
        for (String w: paragraph.split("[ !?',;.]+")) {
            if (!bannedSet.contains(w)) {
                map.merge(w, 1, (prev, one)-> prev +one);
            }
        }
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();

    }
}
