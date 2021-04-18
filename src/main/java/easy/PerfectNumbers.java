package easy;

import java.util.Optional;

public class PerfectNumbers {

    /*
    A perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself.
    A divisor of an integer x is an integer that can divide x evenly.
    Given an integer n, return true if n is a perfect number, otherwise return false
     */

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
    }


    static boolean checkPerfectNumber(int num) {

        int sum = 0;
        // Divisors cannot exceed the half of the number!
        //Suppose we can write n=a∗b, so both a and b are factors.
        // Notice that it must be the case that one of them is less than or equal to n/2.
        // To see this, suppose both a,b>n/2. Then a∗b>n, which is absurd.
        // 14 * 2 = 24, 15 * 2 = 30!
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) sum += i;
            if (sum > num) return false;
        }
        return num == sum;
    }

}
