package sun.al.dp;


/*
*
* */
public class ClimbStairs {


    public static void main(String[] args) {

        System.out.println(recStairs(8));

        System.out.println(dpStairs(8));

    }



    //
    public static int recStairs(int n ){

        if (n==1||n==2)
            return n ;

        return recStairs(n-2) + recStairs(n-1);

    }

    //
    public static int dpStairs(int n){
        int[] ints = new int[n];
        for (int i=0 ; i<n ; i++){
            if (i==0||i==1){
                ints[i]=i+1 ;
            }else {
                ints[i] = ints[i-1]+ints[i-2];
            }
        }
        return ints[n-1] ;
    }





}
