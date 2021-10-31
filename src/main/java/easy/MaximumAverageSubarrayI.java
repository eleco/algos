package easy;

public class MaximumAverageSubarrayI {


    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1, 2, 3, 4}, 2));
    }


    static double findMaxAverage(int[] nums, int k) {

        double windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        double max = (windowSum / k);

        for (int i = k; i < nums.length; i++) {
            windowSum -= nums[i - k];
            windowSum += nums[i];
            max = Math.max(max, (windowSum / k));
        }
        return max;

    }
}
