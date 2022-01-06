package medium;

public class FindFirstAndLastPositionSortedArray {

    public static void main(String[] args) {
        int [] result = searchRange(new int[]{5, 6, 7, 8, 8, 9, 10}, 8);
        System.out.println(result[0]+ "-" + result[1]);
    }


   /*(n) naive version
    public int[] searchRange(int[] nums, int target) {

        boolean found = false;
        int start=-1;
        int end=0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i]==target) {
                found=true;
                if (start==-1) {
                    start=i;
                    end=i;
                }  else end=i;
            }

        }
        if (!found) return new int[]{-1,-1}; else return new int [] {start,end};
    }*/


    //o log n
    static int[] searchRange(int[] nums, int target) {

        if (nums == null) return new int[]{-1, -1};
        return new int[]{findfirst(nums, target), findlast(nums, target)};

    }

    static int findfirst(int[] nums, int target) {
        int max = nums.length - 1;
        int min = 0;
        while (min <= max) {


            int mid = (min + max) / 2;
            if (nums[mid] == target) {
                if (mid == 0) return mid;
                else {
                    if (nums[mid - 1] == target) {
                        max = mid - 1;
                    } else {
                        return mid;
                    }
                }

            } else if (nums[mid] > target) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return -1;

    }

    static int findlast(int[] nums, int target) {
        int max = nums.length - 1;
        int min = 0;
        while (min <= max) {

            int mid = (min + max) / 2;
            if (nums[mid] == target) {
                if (mid != nums.length - 1 && nums[mid + 1] == target) {
                    min = mid + 1;
                } else return mid;
            } else if (nums[mid] > target) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return -1;
    }


}

