package sun.al.leetcode;

public class RemoveDuplicatesFromSorteArr {


    public static void main(String[] args) {

        RemoveDuplicatesFromSorteArr rdf = new RemoveDuplicatesFromSorteArr();
        int[] nums = {1 , 1 ,2,5} ;
        System.out.println(rdf.removeDuplicates(nums));

    }

    public int removeDuplicates(int[] nums){

        if (null == nums || nums.length==0)
            return 0;

        int flag = 1 ;

        for (int i=1 ; i<nums.length ; i++){

            if (nums[i]!=nums[i-1]){
                nums[flag] = nums[i];
                flag++;
            }
        }


        return  flag ;

    }


}
