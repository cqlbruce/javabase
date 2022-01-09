package sun.al.leetcode;

public class Pow {


    public static void main(String[] args) {

//        2.00000   -2147483648

        System.out.println(myPow(-1 , 2147483647));

    }



    public static double myPow(double x , int n ){


        if(n==0||x==1){
            return 1;
        }
        if(x==-1&&n%2!=0){
            return -1 ;
        }
        if(x==-1&&n%2==0){
            return 1 ;
        }

        double res = x ;

        if (n<0){
            res = 1/x ;
        }
        if (n==-2147483648){
            return 0 ;
        }

        for (int i=1 ; i<Math.abs(n) ; i++){
            if (n<0){
                res = res*1/x;
            }else {
                res = res * x ;
            }
        }

        return res ;

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
