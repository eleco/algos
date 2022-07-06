package easy;

public class FibonacciNumber {

    /*
    The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
    such that each number is the sum of the two preceding ones, starting from 0 and 1.
     */

    public static void main(String[] args) {

        System.out.println(fib_recursive(10));
        System.out.println(fib_iterative(10));
    }

    private static int fib_recursive(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        return fib_recursive(n-1) + fib_recursive(n-2);
    }

    private static int fib_iterative(int n) {
        int fibn0 = 0;
        int fibn1 = 1;
        int fibn = 0;
        if (n == 0) return fibn0;
        if (n == 1) return fibn1;
        for (int i = 2; i <= n; i++) {
            fibn = fibn0 + fibn1;
            fibn0 = fibn1;
            fibn1 = fibn;
        }
        return fibn;
    }
}
