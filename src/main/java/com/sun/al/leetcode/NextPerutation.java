package com.sun.al.leetcode;

public class NextPerutation {

    public static void main(String[] args) {

        //1,2,3 → 1,3,2
        //3,2,1 → 1,2,3
        //1,1,5 → 1,5,1

        int[] arr = {1 , 2 ,3};
        int[] arr1 = {3 , 2 , 1};
        int[] arr2 = {1 , 3 , 2};
        int[] arr3 = {1 , 2};
        NextPerutation np = new NextPerutation();
        np.nextPermutation(arr2);
        for (int i : arr2){
            System.out.print(i);
        }

    }

    //找出交换点，然后往后的元素做升序排列
    public void nextPermutation(int[] nums){
        if (nums==null||nums.length==0||nums.length==1){
            return;
        }
        int temp = 0 ;
        //找到交换点 从后往前找，第一不是顺序的数字p
        //交换: 从后往前找到第一个比p大的数字，然后交换
        //倒序:将p后面的数字倒序交换
        for (int k=nums.length-1 ; k>0 ; k--){
            //需要替换点为k-1
            if (nums[k]>nums[k-1]){
                int p = nums[k-1];
                for (int i=nums.length-1; i>=k;i--){
                    //交换
                    if (p<nums[i]){
                        nums[k-1] = nums[i];
                        nums[i] = p;
                        reverseSort(k,nums.length-1,nums);
                        return;
                    }
                    //反转
                }
            }
        }
        reverseSort(0,nums.length-1,nums);
    }
    //后移 132     1 232 2 0
    public void reverseSort(int begin , int end , int[] nums ){
        int temp = 0 ;
        while (begin < end){
            temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }
}
