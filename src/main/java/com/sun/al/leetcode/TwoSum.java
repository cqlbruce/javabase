package com.sun.al.leetcode;

import java.util.*;

public class TwoSum {


    public static void main(String[] args) {
        int[] ints = {9 , 9 , 1 , 10 , 3 , 3 , 8,2};
        int t = 12 ;
        //int[] indices = twoSumOne(ints , t);
        //int[] indices = twoSum2(ints , t);
//        int[] indices = twoSum3(ints , t);
//        for (int i : indices){
//            System.out.print(i + ",");
//        }
        List<List<Integer>> lli = TwoSum.twoSum(ints , t);
        for (List<Integer> li : lli){
            System.out.println(li);
        }
    }


    //s1
    // 暴力计算 : 时间效率  o(n*n)
    //
    public static int[] twoSumOne(int[] nums , int target){
        for(int i = 0 ; i<nums.length ; i ++){
            for (int j = 0 ; j<nums.length ; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i , j};
                }
            }
        }
        return null ;
    }

    //s2
    public static int[] twoSum2(int[] nums , int target){
        Map<Integer , Integer> map = new HashMap<Integer , Integer>();
        for (int i=0 ; i<nums.length ; i++){
            map.put(nums[i], i );
        }
        for (int i=0 ; i<nums.length ; i++){
            int temp = target - nums[i];
            Integer str = map.get(temp);
            if (null != str){
                return new int[]{i , str};
            }
        }
        return null ;
    }

    //s3 时间效率 o(n)
    public static int[] twoSum3(int nums[] , int target){
        Map<Integer , Integer> map = new HashMap<Integer , Integer>();
        for (int i=0 ; i<nums.length ; i++){
            int temp = target - nums[i] ;
            if (map.containsKey(temp)){
                return new int[]{ map.get(temp) ,i};
            }
            map.put(nums[i], i );
        }
        return null ;
    }


    public static List<List<Integer>> twoSum(int nums[] , int target){
        List<List<Integer>> lli = new ArrayList<>();
        Arrays.sort(nums);
        int low = 0 ;
        int high = nums.length-1 ;
        while(low < high){
            if (nums[low] + nums[high] < target)
                low ++ ;
            if (nums[low] + nums[high] > target)
                high -- ;
            if (nums[low] + nums[high] == target){
                List<Integer> li = new ArrayList<Integer>();
                li.add(nums[low]);
                li.add(nums[high]);
                lli.add(li);
                low++;
                high--;
            }
        }
        return  lli ;
    }



}
