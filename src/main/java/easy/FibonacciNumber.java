package easy;

public class FibonacciNumber {

    /*
    The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
    such that each number is the sum of the two preceding ones, starting from 0 and 1.
     */

    public static void main(String[] args) {
        System.out.println(fib(10));
    }

    private static int fib(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        return fib(n-1) + fib(n-2);
    }
}
