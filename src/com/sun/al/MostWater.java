package sun.al;

public class MostWater
{

    public static void main(String[] args) {
        int[] arr  = {1,8,6,2,5,4,8,3,7} ;
        System.out.println(maxArea1(arr));
    }

    //这是糟糕的解法
    public static int maxArea(int[] height){
        int maxArea = 0 ;
        for(int i=1 ; i<height.length ; i ++){
            int tempArea = 0 ;
            for(int j=0 ; j<i ; j++){
                int h = height[j]<height[i]?height[j]:height[i];
                int w = i-j;
                int area = h * w ;
                if(tempArea<area){
                    tempArea = area ;
                }
            }
            if(maxArea < tempArea){
                maxArea = tempArea ;
            }
        }
        return maxArea ;
    }


    public static int maxArea1(int[] height){
        int res = 0 ,i=0 , j=height.length-1;
        while(i<j){
            res = Math.max(res , (j-i)*Math.min(height[i],height[j]));
            if(height[i]<height[j])
                i++;
            else
                j--;
        }
        return res ;
    }

}
