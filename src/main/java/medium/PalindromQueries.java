package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalindromQueries {

    /*
    Given a string s, we make queries on substrings of s.
    For each query queries[i] = [left, right, k], we may rearrange the substring s[left], ..., s[right], and then choose up to k of them to replace with any lowercase English letter.
    If the substring is possible to be a palindrome string after the operations above, the result of the query is true. Otherwise, the result is false.
    Return an array answer[], where answer[i] is the result of the i-th query queries[i].
    Note that: Each letter is counted individually for replacement so if for example s[left..right] = "aaa", and k = 2, we can only replace two of the letters.  (Also, note that the initial string s is never modified by any query.)
     */

    public static void main(String[] args) {
        System.out.println(canMakePalindromeQueries("abcda", new int[][]{{3,3,0},{1,2,0}}));
    }

    static List<Boolean> canMakePalindromeQueries(String s, int[][] queries) {
        List<Boolean> bools = new ArrayList<Boolean>();
        for (int i = 0; i < queries.length; i++) {

            int[] q = queries[i];

            String sub = s.substring(q[0], q[1] + 1);
            bools.add(isPalindrome(sub, q[2]));
        }
        return bools;
    }


    static boolean isPalindrome(String s, int k) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        return (set.size() - 1 <= k * 2);

    }
}
