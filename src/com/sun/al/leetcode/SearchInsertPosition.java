package sun.al.leetcode;

public class SearchInsertPosition {


    public static void main(String[] args) {

//        [1,3,5,6], 7
//        [1,3,5,6], 5
        SearchInsertPosition sip = new SearchInsertPosition();
        int[] arr = {1 , 3 , 5 , 6};
        int target = 5 ;
        System.out.println(sip.searchInsert1(arr , target ));

    }

    public static int searchInsert1(int[] nums , int target){


        int start=0 ;
        int end = nums.length-1;
        while (start<end){
            int mid = (start+end)/2 ;
            if (nums[mid]==target)
                return mid ;
            if (nums[mid]>target){
                end = mid-1;
            }else {
                start=mid+1;
            }
        }
        if(nums[start]<target){
            return start+1;
        }else {
            return start;
        }

    }




    public int searchInsert(int[] nums , int target){

        if (null==nums || nums.length==0)
            return -1 ;

        if (nums.length==1&&nums[0]==target){
            return 0 ;
        }else if (nums.length==1&&nums[0]!=target){
            return nums[0]>target?0:1;
        }
        int start = 0 ;
        int end = nums.length-1;
        int index = 0 ;
        while (true){
            if ((start + end)/2==start) {
                if (nums[start]==target){
                    return start;
                }else if (nums[end]==target){
                    return end;
                }else {
                    if (target<nums[start]){
                        if (start == 0 )
                            return 0 ;
                        return start - 1 ;
                    }else if (target>nums[end]){
                        return end + 1 ;
                    }else if (target<nums[end]){
                        return end  ;
                    }
                }
            }

            index = (start+end)/2;
            if (nums[index]>target){
                end = index;
            }else if(nums[index]<target){
                start = index;
            }else {
                return index;
            }
        }
    }
}
