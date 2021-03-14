package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class luckyNumber {


    /*Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.

    Return a lucky integer in the array. If there are multiple lucky integers return the largest of them. If there is no lucky integer return -1.
     */


    public static void main(String[] args) {
        System.out.println(findLucky(new int[]{2,2,2,3,3,3}));
    }

    static int findLucky(int[] arr) {

        Map<Integer, Integer> m = new HashMap<>();

        for (int j : arr) {
            m.merge(j, 1, Integer::sum);
        }

        SortedSet<Integer> sorted = new TreeSet<>();
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            if (e.getKey().equals(e.getValue())) sorted.add(e.getKey());
        }

        return (sorted.isEmpty()) ? -1 : sorted.last();
    }
}
