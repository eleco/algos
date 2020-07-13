import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstUniqueCharacter {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("abcabd"));
        System.out.println(firstUniqChar("developer"));
    }

    public static int firstUniqChar(String s) {
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


