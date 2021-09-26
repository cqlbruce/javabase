package sun.al.leetcode;

public class SearchInRotatedSortedArr {

    public static void main(String[] args) {


        //[4,5,6,7,0,1,2], target = 0
        //[1,3,5]
        //0
        //[5,1,3]
        //0

        SearchInRotatedSortedArr sis = new SearchInRotatedSortedArr();
        int[] ss = {5,1,3};
        System.out.println("res========" + sis.search(ss,0));

    }

    public int search(int[] nums, int target) {
        if (null==nums||nums.length==0)
            return -1;
        if(nums.length==1){
            if(nums[0]==target)
                return 0;
            else
                return -1 ;
        }
        int flag = 0 ;
        int start = 0 ;
        int end = nums.length-1 ;
        int index = 0 ;
        while (true){
            index = (start + end)/2;
            if(index-1<0){
                flag = 0 ;
                break;
            }

            if (nums[index]<=nums[index-1]&&nums[index]<=nums[index+1]){
                flag=index;
                break;
            }else if (end == start+1){
                flag = 0 ;
                break;
            }else if (end == start){
                flag = 0 ;
                break;
            }

            if (nums[index]<nums[start]){
                end = index;
            }else if (nums[index]>nums[start]){
                start=index;
            }
        }
        if(nums[nums.length-1] == target){
            return nums.length-1;
        }

        if(flag==0){
            if(nums[0]==target)
                return 0;
            start = 1;
            end = nums.length-1;
        }else if (target==nums[0]){
            return 0;
        }else if (target>nums[0]){
            start=0;
            end = flag;
        }else {
            start = flag ;
            end = nums.length-1;
        }

        while (true){
            index = (start + end) / 2 ;

            if (nums[index]>target){
                end = index;
            }else if (nums[index]<target){
                start = index;
            }else{
                return index;
            }
            if(start==end){
                if(nums[start] == target)
                    return start;
                else
                    return -1;
            }
            if(end==(start+1)){
                if (nums[start]==target){
                    return start;
                }else if (nums[end] == target){
                    return end;
                }else {
                    return -1;
                }
            }
        }
    }
}
