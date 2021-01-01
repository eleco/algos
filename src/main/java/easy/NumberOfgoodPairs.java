package easy;

public class NumberOfgoodPairs {

    /*
    Given an array of integers nums.
    A pair (i,j) is called good if nums[i] == nums[j] and i < j.
    Return the number of good pairs.
     */

    public static void main(String[] args) {
        System.out.println(numIdenticalPairs(new int[]{1, 2, 3, 2}));
    }

    public static int numIdenticalPairs(int[] nums) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) c++;
            }

        }
        return c;
    }
}
