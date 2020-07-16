package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    /*
    Given two strings s and t return whether or not s is an anagram of t.
     */
    public static void main(String args[]) {
        System.out.println(validAnagram1("cat", "tac"));
        System.out.println(validAnagram1("listen", "silent"));
        System.out.println(validAnagram1("program", "function"));

        System.out.println(validAnagram2("cat", "tac"));
        System.out.println(validAnagram2("listen", "silent"));
        System.out.println(validAnagram2("program", "function"));
    }

    public static boolean validAnagram1(String s1, String s2) {

        if (s1.length() != s2.length()) return false;

        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);

        char[] c2 = s2.toCharArray();
        Arrays.sort(c2);

        return Arrays.compare(c1, c2) == 0;

    }

    public static boolean validAnagram2(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        Map<Character, Integer> m = new HashMap<>();
        int p = 2;
        for (int i = 0; i < s1.length(); i++) {
            if (m.get(s1.charAt(i)) == null) {
                while (!isPrime(p)) p++;
                m.put(s1.charAt(i), p);
            }
        }

        long l1 = calc(s1, m);
        long l2 = calc(s2, m);
        return l1 > 0 && l2 > 0 && l1 == l2;
    }


    private static long calc(String s, Map<Character, Integer> m) {
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer num = m.get(s.charAt(i));
            if (num == null) return 0;
            l += num;
        }
        return l;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}


