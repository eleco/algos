package easy;

import java.util.*;

public class KeyboardRow {

    public static void main(String args[]) {
        System.out.println(Arrays.toString(findWords(new String[]{"Alaska", "Piano"})));
    }

    public static String[] findWords(String[] words) {

        Map<Character, Integer> m = new HashMap<>();
        String[] str = new String[]{"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length(); j++) m.put(str[i].charAt(j), i);
        }

        List<String> ret = new ArrayList<String>();

        for (int i = 0; i < words.length; i++) {
            String w = words[i];

            int key = -1;
            boolean valid = true;
            for (int j = 0; j < w.length(); j++) {
                Character c = Character.toUpperCase(w.charAt(j));
                if (key == -1) {
                    key = m.get(c);

                } else {
                    if (key != m.get(c)) {
                        valid = false;
                        break;
                    }
                }

            }
            if (valid) ret.add(w);
        }
        return ret.toArray(new String[0]);

    }
}
