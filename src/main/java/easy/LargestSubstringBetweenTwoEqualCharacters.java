package easy;

import java.util.HashMap;
import java.util.Map;

public class LargestSubstringBetweenTwoEqualCharacters {

    static Map<Character, Integer> m = new HashMap<>();
    static int max = -1;

    public static void main(String[] args) {
        System.out.println(maxLengthBetweenEqualCharacters("mbsderedss"));
    }


    static int maxLengthBetweenEqualCharacters(String s) {
        for (int i = 0; i < s.length(); i++) {

            Character c = s.charAt(i);
            Integer p = m.get(c);
            if (p == null) {
                m.put(c, i);
            } else {
                max = Math.max(max, i - p - 1);
            }
        }
        return max;
    }
}
