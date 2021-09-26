package sun.al.leetcode;

public class Pow {


    public static void main(String[] args) {


        System.out.println(pow(2 , 10));

    }



    public static int pow(int x , int n){

        if (n==1)
            return x ;

        if (n==0){
            return 1 ;
        }

        return x*pow(x , n-1);

    }


}
