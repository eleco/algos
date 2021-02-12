package easy;

import java.util.HashMap;
import java.util.Map;

public class AlienDictionary {


    /**
     * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
     * The order of the alphabet is some permutation of lowercase letters.
     * <p>
     * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if
     * the given words are sorted lexicographicaly in this alien language.
     */

    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }

    static boolean isAlienSorted(String[] words, String order) {

        Map<Character, Integer> map = new HashMap<>();
        int counter = 0;
        for (int i = 0; i < order.length(); i++) {
            Character c = order.charAt(i);
            map.put(c, counter++);
        }

        for (int i = 0; i < words.length; i++) {

            for (int j = 0; j < words.length; j++) {

                if (i == j) continue;

                for (int z = 0; z < words[i].length(); z++) {

                    if ((i > j) && (z >= words[j].length())) break;
                    if ((i < j) && (z >= words[j].length())) return false;

                    Integer iIdx = map.get(words[i].charAt(z));
                    Integer jIdx = map.get(words[j].charAt(z));
                    if ((i < j) && (iIdx < jIdx)) break;
                    if ((i < j) && (iIdx > jIdx)) return false;
                }
            }
        }
        return true;

    }
}
