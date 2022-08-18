package medium;

import java.util.*;

public class ReducearraySizeToHalf {


    /*
    You are given an integer array arr. You can choose a set of integers and
     remove all the occurrences of these integers in the array.

    Return the minimum size of the set so that at least half of the integers of the array are removed.
     */

    public static void main(String[] args) {
        System.out.println(minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7}));
    }
    static int minSetSize(int[] arr) {

        Map<Integer, Integer> freq;
        freq = new HashMap<>();
        for (int j : arr) freq.put(j, freq.getOrDefault(j, 0) + 1);

        List<Integer> list = new ArrayList<>(freq.values());

        java.util.Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return (b - a);
            }
        });
        int size = arr.length;
        int idx = 0;
        int count=0;
        for (Integer i : list) {
            size-=i;
            count++;
            if (size<=arr.length/2) {
                break;
            }
        }
        return count;




    }
}

