package sun.al.leetcode;

public class Sqrt {

    public static void main(String[] args) {

        System.out.println(mySqrt(8));

    }


    public static int mySqrt(int x){

//        int pow1 = 0 ;
//        int pow2 = 0 ;
        for (int i=1;i<Integer.MAX_VALUE ; i++){

            if (i*i<0){
                return i-1;
            }

            if (i*i==x){
                return i;
            }

            if (i*i<x&&(i+1)*(i+1)>x){
                return i;
            }

        }

        return 0;
    }

}
