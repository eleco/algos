package medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAMostKDistinctCharacters {


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
    }

    static Map<Character, Integer> m = new HashMap();

    static int lengthOfLongestSubstringKDistinct(String s, int k) {

        if (k == 0) return 0;

        int hi = 0;
        Character c;
        Integer keycount;
        int maxlength = 0;
        StringBuilder sb = new StringBuilder();

        while (hi < s.length()) {

            while (containsAtMostChar(m, k) && hi <= s.length()) {
                maxlength = Math.max(sb.length(), maxlength);

                if (hi < s.length()) {
                    c = s.charAt(hi++);
                    sb.append(c);
                    keycount = m.get(c);
                    if (keycount == null) {
                        m.put(c, 1);
                    } else {
                        m.put(c, keycount + 1);
                    }

                } else {
                    break;
                }

            }

            if (sb.length() > 0) {
                keycount = m.get(sb.charAt(0));
                if (keycount - 1 == 0)
                    m.remove(sb.charAt(0));
                else
                    m.put(sb.charAt(0), keycount - 1);

                sb.deleteCharAt(0);
            }

            if (containsAtMostChar(m, k)) {
                maxlength = Math.max(sb.length(), maxlength);
            }
        }
        return maxlength;
    }


    static boolean containsAtMostChar(Map<Character, Integer> m, int k) {
        return (m.size() <= k);
    }


}
