package com.sun.al.dp;

/*
*
* ±³°üÎÊÌâ
*
* */
public class Knapsack {


    public static void main(String[] args) {



    }



    public static int maxVaule(int[] w , int[] v , int index , int capacity){


        if (index<0 || capacity<0)
            return 0 ;

        int res = maxVaule(w , v ,index-1 , capacity);

        if(w[index] <= capacity){
            return Math.max(res , maxVaule(w, v , index-1 , capacity-w[index])) ;
        }

        return res ;
    }







}
