package com.sun.al.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
        //Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
        //[-1,0,1,2,-1,-4]
        //-1

        FourSum fs = new FourSum();
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(fs.fourSum(nums , -1));
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lli = new ArrayList<List<Integer>>();
        if (nums==null || nums.length<4)
            return lli ;

        Arrays.sort(nums);
        for (int i=0 ; i<=nums.length-4 ; i++){
            if (i!=0 && nums[i-1] ==nums[i])
                continue;
            for (int j=i+1 ; j<=nums.length-3 ; j++){
                if (j!=i+1 && nums[j-1]==nums[j])//新的I值，j肯定要执行
                    continue;
                int low = j+1 ;
                int high = nums.length-1 ;
                while (low<high){
                    int sum = nums[i] + nums[j] + nums[low] + nums[high] ;
                    if (sum==target){
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[low]);
                        list.add(nums[high]);
                        lli.add(list);
                        low++;
                        high--;

                        while (low<high && nums[low-1] == nums[low]  )
                            low++ ;

                        while (low<high && nums[high+1] == nums[high])
                            high--;

                    }else if (sum<target){
                        low++;
                    }else {
                        high--;
                    }
                }
            }
        }
        return lli ;
    }
}
