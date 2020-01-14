package com.sun.al.leetcode;

/*
*There are two sorted arrays nums1 and nums2 of size m and n respectively.
*Find the median of the two sorted arrays.
*The overall run time complexity should be O(log (m+n)).
*You may assume nums1 and nums2 cannot be both empty.
*nums1 = [1, 3]
*nums2 = [2]
*The median is 2.0
*
*nums1 = [1, 2]
*nums2 = [3, 4]
*The median is (2 + 3)/2 = 2.5
*
* */
public class MedianSorted {

    public static void main(String[] args) {

//        int[] nums1 = {2 , 5};
//        int[] nums2 = {3 , 9};[]
//[1]
        int[] nums1 = {100001};
        int[] nums2 = {100000};
        System.out.println(findMedianSortedArraysOne(nums1,nums2));
    }

    //s1 : 暴力破解 -- 垃圾 异常狼狈的解法
    //合并数组，取中值
    public static double findMedianSortedArraysOne(int[] nums1 , int[] nums2){
        int index = nums1.length + nums2.length;
        int n1=0 , n2=0 ;
        int i = 0 ;
        int[] nums = new int[index];
        int a = 0 ;
        int b = 0 ;

        while (i<index){
            a=-1890890890;
            b=-1890890890;
            if (n1<nums1.length&&nums1.length>0)
                a = nums1[n1];
            if (n2<nums2.length&&nums2.length>0)
                b = nums2[n2];


            if(nums2.length==0&&nums1.length>0){
                nums[i]=a ;
                n1++;
            }else if(a<b&&a!=-1890890890){
                nums[i]=a ;
                n1++;
            }else if (a>b&&b==-1890890890 ){
                nums[i]=a ;
                n1++;
            }else if(a == b && a != -1890890890){
                nums[i]=b;
                nums[++i]=b;
                n1++;
                n2++;
            }else if(b != -1890890890){
                nums[i]=b;
                n2++;
            }
            i++ ;
        }
        if(nums.length<2){
            return nums[0];
        }else if (index%2==0){
            double t1=nums[index/2-1];
            double t2=nums[index/2];
            return (t1+t2)/2;
        }else {
            return nums[index/2];
        }
    }

}
