package easy;

import java.util.Arrays;

public class SievesOfErastothene {


    /*
    Count the number of prime numbers less than a non-negative number, n.


    In mathematics, the sieve of Eratosthenes is an ancient algorithm for finding all prime numbers up to any given limit.

    It does so by iteratively marking as composite (i.e., not prime) the multiples of each prime,
    starting with the first prime number, 2. The multiples of a given prime are generated as a sequence of numbers
    starting from that prime, with constant difference between them that is equal to that prime.
    */

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }

    static int countPrimes(int n) {


        boolean [] primes = new boolean[n];
        Arrays.fill(primes, true);
        for (int i=2;i*i<n;i++) {
            if (primes[i]) {
                for (int j=2; i*j<n;j++) primes[i*j]=false;
            }
        }

        int count = 0;
        for (int i=2;i<n;i++) if (primes[i]) count++;
        return count;

    }
}
