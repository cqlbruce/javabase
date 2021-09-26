package sun.al.leetcode;

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
        int[] arr = TwoSum.twoSum5(ints , t);
        for (int i : arr){
            System.out.print(i);
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


    public static int[] twoSum5(int nums[] , int target){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i=0 ; i<nums.length ; i++){
            if (map.containsKey(target-nums[i])){
                if (i<map.get(target-nums[i])){
                    return new int[]{i , map.get(target-nums[i])} ;
                }else {
                    return new int[]{map.get(target-nums[i]),i } ;
                }
            }else {
                map.put(nums[i], i);
            }
        }
        return null ;
    }

}
