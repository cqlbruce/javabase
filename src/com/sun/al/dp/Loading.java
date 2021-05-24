package com.sun.al.dp;

/*
*
*装载问题
*
* */
public class Loading {


    public static void main(String[] args) {

        int w1 = 10  , w2 = 20 ;

        int[] w = {7 , 6 , 4 , 8 , 2};

        System.out.println(loading(w , 10 , w.length -1));

    }


    public static int loading(int[] w , int w1 , int index){
        if (index<0){
            System.out.println("");
            return 0 ;
        }

        int res = loading(w ,w1 , index-1);

        if (w[index] <= w1){
//            int max = Math.max(res , w[index] + loading( w , w1 - w[index] , index-1));
            int max = w[index] + loading( w , w1 - w[index] , index-1) ;
            if (max>res){
                System.out.print(index + " ");
                return max ;
            }
        }

        return res ;

    }




}
