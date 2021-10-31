
/*
Given an array of integers nums which is sorted in ascending order
and an integer target, write a function to search target in nums. If target exists,
then return its index. Otherwise, return -1.
*/

impl Solution {
    pub fn search( nums: Vec<i32>, target: i32) -> i32 {

        return Self::sb(&nums, 0 , nums.len()-1, target);
    }


    fn sb (nums: &[i32], lo:usize, hi:usize, target: i32) -> i32 {


        let mut mid =   (lo+hi )/2;

        if (nums[mid]==target) {
            return  mid as i32;
        }

        if (lo<hi){
            if (nums[mid]<target) {

                return  Self::sb(nums, mid+1, hi , target);
            }else  {
                if (mid==0) {
                    return -1;
                }
                return  Self::sb(nums,0, mid-1 , target);
            }
        }
        return -1;
    }
}