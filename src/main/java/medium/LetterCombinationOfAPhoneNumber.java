package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LetterCombinationOfAPhoneNumber {

    /*
    Given a string containing digits from 2-9 inclusive,
    return all possible letter combinations that the number could represent. Return the answer in any order.

     */
    public static void main(String[] args) {

        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {


        Map<Integer, List<Character>> m = new HashMap();
        m.put(1, new ArrayList());
        m.put(2, List.of('a', 'b', 'c'));
        m.put(3, List.of('d', 'e', 'f'));
        m.put(4, List.of('g', 'h', 'i'));
        m.put(5, List.of('j', 'k', 'l'));
        m.put(6, List.of('m', 'n', 'o'));
        m.put(7, List.of('p', 'q', 'r', 's'));
        m.put(8, List.of('t', 'u', 'v'));
        m.put(9, List.of('w', 'x', 'y', 'z'));

        List<String> all = new ArrayList();
        rec(m, digits, 0, all, new ArrayList());

        return all;
    }


    public static void rec(Map<Integer, List<Character>> m, String digits, int idx, List<String> all, List<Character> curr) {

        if (curr.size() == digits.length()) {
            all.add(curr.stream().map(c -> String.valueOf(c)).collect(Collectors.joining("")));
            return;
        }

        Integer k = digits.charAt(idx) - '0';
        List<Character> cs = m.get(k);
        for (int j = 0; j < cs.size(); j++) {
            List<Character> ll = new ArrayList(curr);
            ll.add(cs.get(j));
            rec(m, digits, idx + 1, all, ll);
        }

    }
}
