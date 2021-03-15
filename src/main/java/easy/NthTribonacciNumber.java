package easy;

import java.util.Arrays;

public class NthTribonacciNumber {

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

