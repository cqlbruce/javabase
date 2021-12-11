package sun.al.leetcode;

import java.util.Arrays;

public class JumpTwo {


    public static void main(String[] args) {
        int[] ints = new int[]{2,1,1,1,1};
//        int[] ints = new int[]{1,2};
//        System.out.println(jump(ints , 0));
    }



    public static int jump(int[] nums){

        int v = nums[0] ;
        for (int i=1 ; i<nums.length ; i++){

            if (nums[i]!=-1){


            }

        }

        return 0 ;

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
