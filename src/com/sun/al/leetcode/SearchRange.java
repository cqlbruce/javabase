package sun.al.leetcode;

public class SearchRange {


    public static void main(String[] args) {

        //nums = [5,7,7,8,8,10], target = 8
        SearchRange sr = new SearchRange();
        int[] nums = {5,7,7,8,8,10};
        int target = 8 ;
        int[] nums1 = sr.searchRange(nums , target);
        for (int i : nums1){
            System.out.print(i);
        }

    }

    public int[] searchRange(int[] nums, int target) {

        if (null == nums || nums.length==0)
            return new int[]{-1 , -1};
        if (nums.length==1&&nums[0]==target){
            return new int[]{0 , 0};
        }

        int start = 0 ;
        int end = nums.length-1 ;
        int index = 0 ;
        while (true){
            if ((start + end)/2==start){
                if (nums[start]==target&&nums[end]==target){
                    return new int[]{start,end};
                }else if (nums[start]==target){
                    return new int[]{start,start};
                }else if (nums[end]==target){
                    return new int[]{end,end};
                }else {
                    return new int[]{-1 , -1};
                }
            }
            index = (start + end)/2;
            if (nums[index] > target){
                end = index;
            }else if (nums[index]<target){
                start = index;
            }else {
                int i = index;
                int j = index ;
                while ((i-1>=0&&nums[i-1]==target)||(j+1<nums.length)&&nums[j+1]==target){
                    if (i-1>=0&&nums[i-1]==target){
                        i=i-1;
                    }
                    if (j+1<nums.length&&nums[j+1]==target){
                        j=j+1;
                    }
                }
                return new int[]{i , j};
            }
        }

    }


}
