package sun.al.leetcode;

public class TrapRainWater {


    public static void main(String[] args) {

//        int[] ints = {0,1,0,2,1,0,1,3,2,1,2,1};
        //[4,2,0,3,2,5]
        int[] ints = {4,2,0,3,2,5};

        System.out.println(trap01(ints)) ;

    }


    public static int trap01(int[] height){

        int max = height[0];
        int maxIndex = 0;
        for (int i=0 ; i<height.length ; i++){
            if (height[i]>max){
                max=height[i];
                maxIndex=i;
            }
        }
        int sum = 0 ;
        int leftStart = height[0] ;
        int leftStartIndex = 0 ;
//        int leftBottom = height[0] ;
        int letTemp = 0 ;
        for (int i=1 ; i<=maxIndex;i++){
            if (height[i]>=leftStart){
                int vol = Math.min(leftStart,height[i])*(i-leftStartIndex-1) ;
                if (vol>0){
                    sum = sum + vol - letTemp;
                }
                letTemp = 0 ;
                leftStart = height[i];
                leftStartIndex=i;
//                leftBottom = height[i];
            }else {
//                leftBottom=Math.min(leftBottom,height[i]);
                letTemp=letTemp+height[i];
            }

        }

        int rightStart = height[height.length-1];
        int rightStartIndex = height.length-1;
//        int rightBottom = height[height.length-1];
        int rightTemp = 0 ;
        for (int j=height.length-2 ; j>=maxIndex ; j--){
            if (height[j]>=rightStart){
                int vol =  Math.min(rightStart,height[j])*(rightStartIndex-j-1);
                if (vol>0){
                    sum = sum + vol-rightTemp;
                }
                rightTemp = 0 ;
                rightStart = height[j];
                rightStartIndex=j;
//                rightBottom = height[j];
            }else {
//                rightBottom=Math.min(rightBottom,height[j]);
                rightTemp=rightTemp+height[j];
            }
        }

        return sum ;
    }



    public static int trap(int[] height){

        int sum = 0 ;
        int leftStart = height[0] ;
        int leftStartIndex = 0 ;
        int leftBottom = height[0] ;
        int letTemp = 0 ;

        int rightStart = height[height.length-1];
        int rightStartIndex = height.length-1;
        int rightBottom = height[height.length-1];
        int rightTemp = 0 ;

        for(int i=1 , j=height.length-2 ; i<=j ; i++ , j--){

            if (i==j){

                int vol =Math.min(leftStart,rightStart)*(rightStartIndex - leftStartIndex -1) ;
                if (vol>0){
                    sum = sum + vol - letTemp - rightTemp;
                }
                return sum;
            }


            //left
            if (height[i]>leftBottom){
                int vol = Math.min(leftStart,height[i])*(i-leftStartIndex-1) ;
                if (vol>0){
                    sum = sum + vol - letTemp;
                }
                letTemp = 0 ;
                leftStart = height[i];
                leftStartIndex=i;
                leftBottom = height[i];
            }else {
                leftBottom=Math.min(leftBottom,height[i]);
                letTemp=letTemp+height[i];
            }
            //right
            if (height[j]>rightBottom){

                int vol =  Math.min(rightStart,height[j])*(rightStartIndex-j-1);
                if (vol>0){
                    sum = sum + vol-letTemp;
                }
                rightTemp = 0 ;
                rightStart = height[j];
                rightStartIndex=j;
                rightBottom = height[j];
            }else {
                rightBottom=Math.min(rightBottom,height[j]);
                rightTemp=rightTemp+height[j];
            }
        }
        return sum ;
    }


}
