package medium;

public class NumberofSubstringsWithOnly1 {
    /*
    Given a binary string s (a string consisting only of '0' and '1's).

    Return the number of substrings with all characters 1's.

    Since the answer may be too large, return it modulo 10^9 + 7.
     */

    public static void main(String[] args) {
        System.out.println(numSub("0110111"));
    }

    public static int numSub(String s) {

        if (s==null) return 0;

        int hi=0;
        int lo=0;
        int subs = 0;
        while (hi<s.length()) {
            while(hi<s.length() && s.charAt(hi++)=='1') {
                subs=(subs+hi-lo) % 1000000007;
            }
            lo=hi;
        }
        return subs;
    }
}