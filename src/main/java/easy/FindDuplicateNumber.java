package easy;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateNumber {

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int []{1,1,2}));
    }

    public static int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            if (!seen.contains(num)) {
                seen.add(num);
            } else return num;
        }
        return -1;
    }
}
