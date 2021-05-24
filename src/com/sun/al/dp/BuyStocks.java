package com.sun.al.dp;


/*
*
* 买股票问题
*
* */
public class BuyStocks {


    public static void main(String[] args) {


        int[] s = {7 , 3 , 2 , 8 , 9 , 6} ;

        System.out.println(buyNor(s));

    }

    /*
    * 暴力破解
    * */
    public static int buyNor(int[] s){

        int max = 0 ;
        for (int i=0 ; i<s.length ; i++){
            for (int j=0 ; j<s.length ; j++) {

                max = Math.max(max , s[j]-s[i]);

            }
        }
        return max ;
    }



}
