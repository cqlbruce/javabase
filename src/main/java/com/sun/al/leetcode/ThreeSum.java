package com.sun.al.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {


    public static void main(String[] args) {

        ThreeSum ts = new ThreeSum();
        //Given array nums = [-1, 0, 1, 2, -1, -4],
        int[] nums = {-1 , 0 , 1 , 2 , -1 , -4};
        //Json
        System.out.println(ts.threeSum(nums));


    }

    public List<List<Integer>> threeSum(int[] nums){

        List<List<Integer>> lli = new ArrayList<List<Integer>>();

        for (int i=0 ; i<nums.length-2 ; i++){

            for (int j=i+2 ; j<nums.length ; j++){
                if ((nums[i] + nums[i+1] + nums[j]) == 0 ){
                    List<Integer> li = new ArrayList<Integer>();
                    li.add(nums[i]);
                    li.add(nums[i+1]);
                    li.add(nums[j]);
                    lli.add(li);
                }
            }
        }

        return lli ;
    }


}
