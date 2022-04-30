package sun.al.leetcode;

public class NumArray {

    int[] nums = null;


    public NumArray(int[] nums){
        this.nums = nums ;
    }

    public int sumRange(int left , int right){
        int sum = 0 ;
        for(int i=left ; i<=right ; i++){
            sum = sum + nums[i];
        }
        return sum ;
    }


    int[] preNums ;

    public NumArray(int[] nums , int i){

        preNums = nums ;
        for (int j=1 ; j<nums.length ; j++){
            preNums[j]=preNums[j-1]+nums[j];
        }
    }

    public int sumRange1(int left , int right){

        if (left==0)
            return preNums[right];
        else
            return preNums[right] - preNums[left-1] ;

    }

    public static void main(String[] args) {

    }


}
