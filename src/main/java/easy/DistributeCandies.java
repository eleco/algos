package easy;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

    /*
    Alice has n candies, where the ith candy is of type candyType[i]. Alice noticed that she started to gain weight, so she visited a doctor.

    The doctor advised Alice to only eat n / 2 of the candies she has (n is always even). Alice likes her candies very much, and she wants to eat the maximum number of different types of candies while still following the doctor's advice.

    Given the integer array candyType of length n, return the maximum number of different types of candies she can eat if she only eats n / 2 of them.
     */

    public static void main(String[] args) {
        System.out.println(distributeCandies(new int[]{1,2,4,4,3,4,2,1}));
    }

    static int distributeCandies(int[] candyType) {

        Set<Integer> s = new HashSet<>();
        for (int j : candyType) {
            s.add(j);
        }

        return Math.min(s.size(), candyType.length/2);

    }
}
