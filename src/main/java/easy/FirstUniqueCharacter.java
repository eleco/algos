package easy;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstUniqueCharacter {


    /*
    Given a string s, find the first non-repeating character in it and return its index.
     If it does not exist, return -1.

     */

    public static void main(String[] args) {
        System.out.println(firstUniqChar_map("abcabd"));
        System.out.println(firstUniqChar_map("developer"));

        System.out.println(firstUniqChar_arr("abcabd"));
        System.out.println(firstUniqChar_arr("developer"));
    }


    static int firstUniqChar_arr(String s) {
        char[] cs = new char[26];
        for (int i = 0; i < s.length(); i++) cs[s.charAt(i) - 'a']++;


        for (int i = 0; i < s.length(); i++) if (cs[s.charAt(i) - 'a'] == 1) return i;
        return -1;
    }

    public static int firstUniqChar_map(String s) {
        Map<Character, Integer> m = new LinkedHashMap<>();
        Set<Character> dups = new HashSet();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (dups.contains(c)) continue;
            Integer v = m.get(c);
            if (v == null) {
                m.put(c, i);
            } else {
                dups.add(c);
            }
        }

        for (Map.Entry<Character, Integer> e : m.entrySet()) {
            if (!dups.contains(e.getKey())) return e.getValue();
        }
        return -1;
    }
}


