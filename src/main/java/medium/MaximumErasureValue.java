package medium;

public class MaximumErasureValue {


    /*
    You are given an array of positive integers nums and want to erase a subarray containing unique elements.
    The score you get by erasing the subarray is equal to the sum of its elements.
    Return the maximum score you can get by erasing exactly one subarray.
    An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is,
    if it is equal to a[l],a[l+1],...,a[r] for some (l,r).

     */

    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
    }

    static int maximumUniqueSubarray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int l = 0;
        int r = 0;
        int sum = 0;
        int[] mem = new int[10001];
        while (r < nums.length) {

            int c = nums[r];
            mem[c]++;
            sum += c;

            while (mem[c] > 1) {
                mem[nums[l]]--;
                sum -= nums[l];
                l++;
            }

            max = Math.max(max, sum);
            r++;
        }
        return max;
    }
}
