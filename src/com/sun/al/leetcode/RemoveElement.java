package sun.al.leetcode;

public class RemoveElement {


    public static void main(String[] args) {

    }

    public int removeElement(int[] nums , int val){

        if (nums==null || nums.length==0)
            return 0 ;

        int flag = 0 ;

        for (int i=0 ; i<nums.length ; i++){

            if (nums[i] != val){
                nums[flag] = nums[i];
                flag++;
            }


        }
        return flag;

    }

}
