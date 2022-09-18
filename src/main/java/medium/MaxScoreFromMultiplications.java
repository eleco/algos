package medium;

public class MaxScoreFromMultiplications {


    /*
    You are given two integer arrays nums and multipliers of size n and m respectively, where n >= m. The arrays are 1-indexed.

    You begin with a score of 0. You want to perform exactly m operations. On the ith operation (1-indexed), you will:

    Choose one integer x from either the start or the end of the array nums.
    Add multipliers[i] * x to your score.
    Remove x from the array nums.

    Return the maximum score after performing m operations.
     */

    public static void main(String[] args) {
        System.out.println(maximumScore(new int[]{1,2,3},
                new int[]{3,2,1}));
    }

    static Integer[][]mem;
    static int maximumScore(int[] nums, int[] multipliers) {

        mem = new Integer[multipliers.length+1][multipliers.length+1];
        return rec(nums, multipliers,0, 0,0);
    }

    static int rec(int[] nums, int[] multipliers, int i, int j , int count) {

        if (count==multipliers.length) {
            return 0;
        }

        if (mem[i][j]!=null) {
            return mem[i][j];
        }

        int suma =  nums[i]*multipliers[count] + rec(nums, multipliers, i+1, j ,count+1);
        int sumb =  nums[nums.length-1-j]*multipliers[count] +rec(nums, multipliers, i, j+1,  count+1);
        mem[i][j] = Math.max(suma, sumb);
        return  Math.max(suma, sumb);
    }
}
