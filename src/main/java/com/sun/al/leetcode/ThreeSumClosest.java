package com.sun.al.leetcode;

public class ThreeSumClosest {


    public static void main(String[] args) {

        // Given array nums = [-1, 2, 1, -4], and target = 1.
        ThreeSumClosest tsc = new ThreeSumClosest();
        int[] nums = {-1, 2, 1, -4};
        System.out.println(tsc.threeSumClosest(nums , 1));

    }

    public int threeSumClosest(int[] nums, int target) {

        if (nums==null || nums.length<2)
            return 0 ;

        int closest = 0 ;
        for (int i=0 ; i<nums.length ; i++){
            int low = i + 1 ;
            int high = nums.length - 1 ;
            while (low < high){
                int sum = nums[i] + nums[low] + nums[high] ;
                closest = Math.min(closest , Math.abs(sum-target));
                low++ ;
                high--;
            }
        }
        return closest ;

    }

}
