package sun.al.leetcode;

public class FirstMissingPositive {


    public static void main(String[] args) {

        int[] i = new int[]{1,2,0};
//        int[] ints = new int[500000];
//        System.out.println(ints.length);
        System.out.println(firstMissingPositive(i));

    }

    public static int firstMissingPositive(int[] nums){

        int max = 500000 ;
        int[] ints = new int[500000];
        for (int i = 0 ; i<nums.length ; i++){
            if (nums[i]>0&&nums[i]<500000){
                ints[nums[i]] = nums[i];
            }
        }
        for (int i=1 ; i<ints.length ; i++){
            if (ints[i]==0){
                return i;
            }
        }

        return ints.length+1 ;

    }


}
