package sun.al.leetcode;

public class TrapRainWater {



    public int trap(int[] height){

        int sum = 0 ;
        for(int i=0 ; i<height.length ; i++){

            for(int j=i+2 ; j<height.length;j++){

                if (height[j]>=height[i]){

                    sum = height[i]*(j-i) - 1;

                }

            }
        }
        return 0 ;
    }


}
