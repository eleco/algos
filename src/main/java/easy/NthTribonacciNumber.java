package easy;

import java.util.Arrays;

public class NthTribonacciNumber {

    /*
    The Tribonacci sequence Tn is defined as follows:
    T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
    Given n, return the value of Tn.
     */

    static int[] cache;

    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }

    static int tribonacci(int n) {
        cache = new int[Math.max(3, n + 1)];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 1;
        return calc(n);
    }

    static int calc(int n) {

        if (cache[n] != -1) return cache[n];

        cache[n] = calc(n - 1) + calc(n - 2) + calc(n - 3);
        return cache[n];

    }
}

