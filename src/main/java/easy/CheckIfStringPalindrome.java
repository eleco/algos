package easy;

import java.util.HashSet;
import java.util.Set;

public class CheckIfStringPalindrome {

    /*
    Determine whether any permutation of a string is a palindrome
     */

    public static void main(String[] args) {
        System.out.println(isPalindrome("abcdef"));
        System.out.println(isPalindrome("dacacd"));
        System.out.println(isPalindrome("acareeraac"));
    }

    static boolean isPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (Character c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size()<=1;
    }
}
