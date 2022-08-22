package easy;

public class PowerOfFour {

    /*
    Given an integer n, return true if it is a power of four. Otherwise, return false.
    An integer n is a power of four, if there exists an integer x such that n == 4x.
     */

    public static void main(String[] args) {
        System.out.println(isPowerOfFour_iterative(16));
        System.out.println(isPowerOfFour_recursive(16));
    }

    static boolean isPowerOfFour_iterative(int n) {
        if (n == 1) return true;

        int cnt = 1;

        for (int i = 0; i < 15; i++) {
            cnt *= 4;
            if (cnt == n) return true;
        }
        return false;
    }

    static boolean isPowerOfFour_recursive(int n) {
        if (n == 0) return false;
        if (n == 1) return true;

        if (n % 4 == 0) {
            return isPowerOfFour_recursive(n / 4);
        }

        return false;
    }

}
