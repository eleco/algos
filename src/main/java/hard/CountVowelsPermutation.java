package hard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountVowelsPermutation {


    /*
    Given an integer n, your task is to count how many strings of length n can be formed under the following rules:

    Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
    Each vowel 'a' may only be followed by an 'e'.
    Each vowel 'e' may only be followed by an 'a' or an 'i'.
    Each vowel 'i' may not be followed by another 'i'.
    Each vowel 'o' may only be followed by an 'i' or a 'u'.
    Each vowel 'u' may only be followed by an 'a'.

    Since the answer may be too large, return it modulo 10^9 + 7.
     */


    public static void main(String[] args) {
        System.out.println(countVowelPermutation(6));
    }

    static Map<Character, List<Character>> m = new HashMap<>();
    static Map<String, Integer> memo = new HashMap<>();
    static int MOD = (int) Math.pow(10, 9) + 7;

    static int countVowelPermutation(int n) {
        memo = new HashMap<>();

        m.put('a', List.of('e'));
        m.put('e', List.of('a', 'i'));
        m.put('i', List.of('a', 'e', 'o', 'u'));
        m.put('o', List.of('i', 'u'));
        m.put('u', List.of('a'));

        int count = 0;
        List<Character> voyels = List.of('a', 'e', 'i', 'o', 'u');
        for (Character c : voyels) {
            count = count % MOD + dfs(n, c, 1);
        }
        return count % MOD;
    }


    static int dfs(int n, char prev, int curl) {

        if (n == curl) {
            return 1;
        }

        String key = "" + prev + ":" + curl;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        List<Character> follows = m.get(prev);
        int count = 0;
        for (Character c : follows) {
            count = count % MOD + dfs(n, c, curl + 1);
        }
        int ret = count % MOD;
        memo.put(key, ret);
        return ret;
    }
}
