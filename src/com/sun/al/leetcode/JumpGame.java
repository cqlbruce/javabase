package sun.al.leetcode;

public class JumpGame {


    public static void main(String[] args) {

       // Input: nums = [2,3,1,1,4]
        //Input: nums = [3,2,1,0,4]
        //[1,1,0,1]

//        int[] ints = {1,1,0,1};
        int[] ints = {2,3,1,1,4};
//        int[] ints = {3,2,1,0,4};
        System.out.println(canJump(ints));


    }



    public static boolean canJump(int[] nums){

        int i=0 ;
        int maxJump = 0;
        int lastJump = 0;
        int index =0;
        while (i<nums.length){
            if (i+nums[i]>index){
//                lastJump = maxJump;
//                maxJump = nums[i];
                index = i+nums[i];

            }
            if (index==nums.length-1){
                return true;
            }
            if (i==index&&nums[index]==0){
                return false;
            }
            i++;
        }
        return true;
    }


}
