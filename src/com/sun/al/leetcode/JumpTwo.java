package sun.al.leetcode;

import java.util.Arrays;

public class JumpTwo {

    public static int min = 1000 ;

    public static void main(String[] args) {
        //[2,3,1,1,4]
//        int[] ints = new int[]{2,1,1,1,1};
        int[] ints = new int[]{2,3,1,1,4};
        //[8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5]
//        int[] ints = new int[]{8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
//        int[] ints = new int[]{9,7,9,1,7,3,7,0,5,0,0,5,6,7,5,6,0,5,4,7,3,9,0,2,0,5,9,2,3,6,0,4,3,1,6,3,4,3,3,1,3,3,8,1,2,3,0,3,1,4,2,6,5,4,0,6,9,0,8,4,6,0,9,2,1,7,5};
//        int[] ints = new int[]{5,8,1,8,9,8,7,1,7,5,8,6,5,4,7,3,9,9,0,6,6,3,4,8,0,5,8,9,5,3,7,2,1,8,2,3,8,9,4,7,6,2,5,2,8,2,7,9,3,7,6,9,2,0,8,2,7,8,4,4,1,1,6,4,1,0,7,2,0,3,9,8,7,7,0,6,9,9,7,3,6,3,4,8,6,4,3,3,2,7,8,5,8,6,0};

//        jump(ints , 0 , 0);
        System.out.println(min);
//        int[] ints = new int[]{1,2};
//        System.out.println(jump(ints , 0));
        System.out.println(jump5(ints));

    }


    public static int jump5(int[] nums ){

        int res = 0 ;
        int last = 0 ;
        int cur = 0 ;
        for (int i=0 ; i< nums.length -1 ; i++){
            cur = Math.max(cur , i+nums[i]);
            if (i==last){
                last = cur ;
                ++res;
                if (cur >= nums.length-1)break;
            }

        }
        return res ;

    }


    public static void jump3(int[] nums, int high , int value){

        if (high>=nums.length-1){
            if (min>value){
                min = value ;
            }
            return ;
        }

        for (int i=high+nums[high]+1 ; i>high ; i--){
            if (min<value){
                return;
            }
            jump3(nums ,i-1 , value+1);
        }


    }


    public static void jump(int[] nums, int high , int value){

        if (high>=nums.length-1){
            if (min>value){
                min = value ;
            }
            return ;
        }

        for (int i=high ; i<nums[high]+high ; i++){
            if (min<value){
                return;
            }
            jump(nums ,i+1 , value+1);
        }

    }





    public static  int jump2(int[] nums , int jump ){
       if (nums.length==1){
            return 0 ;
        }
//        int jump = 0 ;
        int jumpsEnd = 0 ;
        for (int i=0 ; i<nums.length ; i++){
            jumpsEnd += nums[i] ;
            if (jumpsEnd>=nums.length-1){
//                return i+1 ;
//                jump = jump(Arrays.copyOf(nums , i+1) , jump) + 1;
                break;
            }
        }
        return jump  ;
    }

}
