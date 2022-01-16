package sun.al.leetcode;

public class MaximumSub {


    public static void main(String[] args) {
        //Input: nums = [-2,1,-3,4,-1,2,1,-5,4]

        int[] ints = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(ints));

    }



    public static int maxSubArray(int[] nums){

        if (nums.length==1){
            return nums[0] ;
        }
        int max = nums[0];
        int temp = nums[0] ;
        for (int i=0 ; i<nums.length ; i++){

            if (temp<0){
                temp = nums[i] ;
                max = Math.max(max,temp);
                continue;
            }

            if (i==nums.length-1){
                if (nums[i]>0){
                    temp = temp + nums[i];
                }
                max = Math.max(temp,max);
                break;
            }

            if (nums[i]>=0||nums[i]+nums[i+1]>=0){
                temp = temp + nums[i];
                continue;
            }
            if (nums[i]<0){
                max=Math.max(max , temp);
            }
            if (temp+nums[i]>0){
                temp=temp+nums[i];
            }else {
                temp=0 ;
            }

//            if (nums[i]<0&&(nums[i]+nums[i+1])<0){
//                max=Math.max(max , temp);
//                temp=0;
//            }

        }

        return max ;
    }


}
