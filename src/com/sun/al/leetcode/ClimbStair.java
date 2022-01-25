package sun.al.leetcode;

public class ClimbStair {


    public static void main(String[] args) {

        System.out.println(climbStair(3));

    }


    public static int climbStair(int n){

        int[] arr = new int[n];
        for (int i=0 ; i<n ; i++){

            if (i==0){
                arr[0] = 1 ;
            }else if (i==1){
                arr[1]=2;
            }else {
                arr[i]=arr[i-1] + arr[i-2];
            }

        }

        return arr[n-1] ;
    }

}
