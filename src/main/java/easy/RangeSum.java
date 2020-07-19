package easy;

public class RangeSum {


    public static void main(String args[]) {
        System.out.println(new RangeSum(new int[]{1,2,3,4,5,6}).sumRange(1,4));
    }

    private int[] nums;
    public RangeSum(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int sum=0;
        for (int x=i;x<=j;x++) {
            sum+=nums[x];
        }
        return sum;
    }
}
