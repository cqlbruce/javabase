package sun.al.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {


    public static void main(String[] args) {

        ThreeSum ts = new ThreeSum();
        //Given array nums = [-1, 0, 1, 2, -1, -4],[0,0,0]
        //int[] nums = {-1 , 0 , 1 , 2 , -1 , -4};
        int[] nums = {0 , 0 , 0} ;
        //Json
        System.out.println(ts.threeSum(nums));


    }

    public List<List<Integer>> threeSum(int[] nums){

        List<List<Integer>> lli = new ArrayList<List<Integer>>();
        if (nums==null || nums.length < 3 )
            return lli ;

        Arrays.sort(nums);
        for (int i=0 ; i<=nums.length-3 ; i++){

            if (i==0||nums[i] != nums[i-1]){
                int low = i+1 ;
                int high = nums.length-1;
                while (low<high){
                    if (nums[i] + nums[low] + nums[high] == 0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[low]);
                        list.add(nums[high]);
                        lli.add(list);
                        low++ ;
                        high--;

                        while (low<high&&nums[low] == nums[low-1])
                            low ++ ;
                        while (low<high&&nums[high] == nums[high+1])
                            high-- ;

                    }else if (nums[i] + nums[low] + nums[high] > 0){
                        high -- ;
                    }else {
                        low ++ ;
                    }
                }
            }

        }

        return lli ;
    }


}
