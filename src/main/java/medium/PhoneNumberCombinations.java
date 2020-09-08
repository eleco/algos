package medium;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberCombinations {

    /*
    Given a string containing digits from 2-9 inclusive,
     return all possible letter combinations that the number could represent.
     */

    public static void main(String args[]) {

        String[] keys = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String digits ="23";

        List<String> l = new ArrayList<String>();
        combo_rec(0, "", keys, digits,l);
        System.out.println(l);

        System.out.println(combo_iter(keys, digits));
    }


    static void  combo_rec(int offset, String cur, String[] keys, String digits, List<String> l) {

        if (offset == digits.length()) {
            l.add(cur);
            return;
        }
        int num = digits.charAt(offset) - '0';
        String s = keys[num - 2];
        for (int i = 0; i < s.length(); i++) {
            combo_rec(offset + 1, cur + s.charAt(i), keys, digits, l);
        }

    }


    static List<String> combo_iter(String[] keys, String digits) {

        List<String> solutions = new ArrayList<String>();


        for (int i = 0; i < digits.length(); i++) {

            if (i == 0) {
                int idx = digits.charAt(i) - '0' - 2;

                for (int j = 0; j < keys[idx].length(); j++) {
                    solutions.add(String.valueOf(keys[idx].charAt(j)));
                }
            } else {
                List<String> solutions2 = new ArrayList<String>();
                int idx = digits.charAt(i) - '0' - 2;
                for (int j = 0; j < keys[idx].length(); j++) {
                    for (int x = 0; x < solutions.size(); x++) {
                        solutions2.add(solutions.get(x) + String.valueOf(keys[idx].charAt(j)));
                    }
                }
                solutions = solutions2;
            }
        }
        return solutions;
    }
}

