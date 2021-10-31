package easy;

public class ValidPalindromeII {


    public static void main(String[] args) {
        System.out.println(checkPal("abcba"));
    }

    static boolean checkPal(String s) {

        int hi = s.length() - 1;
        int lo = 0;

        while (lo < hi) {

            Character chi = s.charAt(hi);
            Character clo = s.charAt(lo);
            if (chi.equals(clo)) {
                lo++;
                hi--;
            } else {
                return (
                        isPal(s.substring(lo + 1, hi + 1))
                                || (isPal(s.substring(lo, hi)))
                );
            }
        }
        return true;
    }

    static boolean isPal(String s) {
        int hi = s.length() - 1;
        int lo = 0;

        while (lo < hi) {
            if (s.charAt(hi) == s.charAt(lo)) {
                lo++;
                hi--;
            } else {
                return false;
            }
        }
        return true;
    }

}



