package medium;

public class MinimumInRotatedArray {

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,6,2}));
    }

    public static int findMin(int[] nums) {

        if (nums.length==1) return nums[0];

        int hi= nums.length-1;
        int lo = 0;
        while(lo<=hi) {

            int mid = (lo+hi)/2;

            if (mid<nums.length-1 && nums[mid]>nums[mid+1]) return nums[mid+1];
            if (mid>0 && nums[mid-1]>nums[mid]) return nums[mid];

            if (nums[mid]>nums[hi]) {
                lo=mid+1;

            } else {
                hi=mid-1;
            }



        }
        return nums[lo];
    }
}
