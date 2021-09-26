package sun.al.leetcode;

public class ContainerWithMostWater {


    public static void main(String[] args) {

        ContainerWithMostWater cww = new ContainerWithMostWater();
        //Input: [1,8,6,2,5,4,8,3,7]
        int[] arr = {1,8,6,2,5,4,8,3,7} ;
        System.out.println(cww.maxArea(arr));

    }




    public int maxArea(int[] height){
        int area = 0 ;
        // (j-i) * min(aj , ai);
        int tempArea = 0 ;
        for (int i=0 ; i<height.length ; i++){

            for (int j=i+1 ; j<height.length ; j++){

                tempArea = (j-i) * Math.min(height[i] , height[j]);
                area = Math.max(tempArea , area);

            }
        }
        return area;
    }


}
