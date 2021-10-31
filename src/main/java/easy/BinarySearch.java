package easy;

public class BinarySearch {

    /*
    Given an array of integers nums which is sorted in ascending order, and an integer target,
    write a function to search target in nums.
     If target exists, then return its index. Otherwise, return -1.
     */
    public static void main(String args[]) {
        System.out.println(search(new int[]{2, 5, 6}, 6));
    }

    public static int search(int[] nums, int target) {
        return searchb(nums, 0, nums.length - 1, target);
    }


    private static int searchb(int[] nums, int lo, int hi, int target) {

        int mid = (lo + hi) / 2;

        if (nums[mid] == target) return mid;

        if (lo < hi) {

            if (nums[mid] < target) {
                return searchb(nums, mid + 1, hi, target);
            } else {
                return searchb(nums, 0, mid - 1, target);
            }

        }
        return -1;

    }
}
