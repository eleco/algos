package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CountOfSmallerNumberAftrNext {

    public static void main(String[] args) {
        System.out.println(countSmaller(new int[]{5, 2, 6, 1}));
    }

    // TLE
    /*   public List<Integer> countSmaller(int[] nums) {

        int [] counts = new int [nums.length];

        for (int i=0;i<nums.length;i++) {
            int c = 0;
            for (int j=i+1; j<nums.length;j++) {
                if (nums[j]<nums[i]) c++;
            }
            counts[i]=c;
        }
        return  Arrays.stream(counts).boxed().collect(Collectors.toList());
    }*/


    static List<Integer> countSmaller(int[] nums) {

        ArrayList<Integer> sorted = new ArrayList<Integer>();
        for (int num : nums) sorted.add(num);
        Collections.sort(sorted);

        int[] counts = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int idx = binSearch(sorted, nums[i]);
            counts[i] = idx;
            sorted.remove(idx);

        }
        return Arrays.stream(counts).boxed().collect(Collectors.toList());
    }


    static int binSearch(List<Integer> sorted, int target) {

        int lo = 0;
        int hi = sorted.size() - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = (hi + lo) / 2;
            if (sorted.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        if (sorted.get(lo) == target) return lo;
        return mid;
    }
}
