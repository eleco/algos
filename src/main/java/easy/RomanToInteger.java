package easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    /*
    Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
     */

    public static void main(String args[]) {
        System.out.println(romanToInt("CXXXIV"));
    }

    public static int romanToInt(String s) {

        if (s == null || s.length() == 0) return 0;

        int sum = 0;
        Map<String, Integer> bipatterns = new HashMap<String, Integer>();
        bipatterns.put("IV", 4);
        bipatterns.put("IX", 9);
        bipatterns.put("XL", 40);
        bipatterns.put("XC", 90);
        bipatterns.put("CD", 400);
        bipatterns.put("CM", 900);

        for (Map.Entry<String, Integer> e : bipatterns.entrySet()) {

            int idx = s.indexOf(e.getKey());
            if (idx >= 0) {
                sum += e.getValue();
                s = s.substring(0, idx) + s.substring(idx + 2);
            }
        }


        Map<Character, Integer> patterns = new HashMap<Character, Integer>();
        patterns.put('I', 1);
        patterns.put('V', 5);
        patterns.put('X', 10);
        patterns.put('L', 50);
        patterns.put('C', 100);
        patterns.put('D', 500);
        patterns.put('M', 1000);

        for (Character c : s.toCharArray()) {
            sum += patterns.get(c);
        }

        return sum;

    }
}
