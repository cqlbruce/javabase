package com.sun.al.leetcode;

public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = {1 , 3 , 6 , 8 , 9 , 10 , 12,16 ,18};
        int target = 10 ;
        BinarySearch  bs = new BinarySearch();
        System.out.println(bs.binarySearch(nums , target));

    }

    //存在返回下标，不存在则返回-1
    public int binarySearch(int[] nums , int target){

        int start = 0 ;
        int end = nums.length-1;
        int index = 0;
        int bound = 0 ;
        while (true){
            index = (start+end)/2;
            if (nums[index]>target){
                end = index;
            }else if (nums[index]<target){
                start = index;
            }else {
                return index;
            }
        }
    }

}
