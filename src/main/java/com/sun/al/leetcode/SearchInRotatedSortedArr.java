package com.sun.al.leetcode;

public class SearchInRotatedSortedArr {

    public static void main(String[] args) {


        //[4,5,6,7,0,1,2], target = 0

        SearchInRotatedSortedArr sis = new SearchInRotatedSortedArr();
        int[] ss = {4,5,6,7,0,1,2};
        System.out.println("res========" + sis.search(ss,7));

    }

    public int search(int[] nums, int target) {
        int flag = 0 ;
        int start = 0 ;
        int end = nums.length-1 ;
        int index = 0 ;
        while (true){
            index = (start + end)/2;
            if (nums[index]<=nums[index-1]&&nums[index]<=nums[index+1]){
                flag=nums[flag];
                break;
            }
            if (nums[index]<nums[start]){
                end = index;
            }else if (nums[index]>nums[start]){
                start=index;
            }
        }

        if (target==nums[0]){
            return 0;
        }else if (target>nums[0]){
            start=0;
            end = flag;
        }else {
            start = flag ;
            end = nums.length-1;
        }

        while (true){
            index = (start + end) / 2 ;
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
