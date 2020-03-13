package com.sun.al.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {


    public static void main(String[] args) {

        // Given array nums = [-1, 2, 1, -4], and target = 1.
        //[-3,-2,-5,3,-4]
        //-1
        //[0,2,1,-3]
        //1
        //[-1,2,1,-4]
        //1
        //[1,2,4,8,16,32,64,128]
        //82
        //[-1,2,1,-4]
        //1
        ThreeSumClosest tsc = new ThreeSumClosest();
        int[] nums = {0,2,1,-3};
        System.out.println(tsc.threeSumClosest(nums , 1));

    }

    public int threeSumClosest(int[] nums, int target) {

        if (nums==null || nums.length<2)
            return 0 ;
        Arrays.sort(nums);
        int closest = Math.abs(nums[0] + nums[1] + nums[2] - target) ;
        int res = nums[0] + nums[1] + nums[2] ;
        for (int i=0 ; i<=nums.length-3 ; i++){
            int low = i + 1 ;
            int high = nums.length - 1 ;
            while (low < high){
                int sum = nums[i] + nums[low] + nums[high] ;
                if (Math.abs(sum-target) < closest){
                    closest = Math.abs(sum-target);
                    res = sum ;
                }
                if (sum > target) {
                    high--;
                }else if (sum < target)
                    low++;
                else{
                   return target;
                }
            }

        }
        return res ;
    }

}
