package com.sun.al.dp;

/*
*
* ±³°üÎÊÌâ
*
* */
public class Knapsack {


    public static void main(String[] args) {
        int[] w = {2 , 3 , 6 , 8 , 9};
        int[] v = {3 , 6 , 8 , 8 , 3};
        int capacity = 10 ;
        System.out.println(maxVaule(w , v , 4 , capacity));
    }


    public static int maxVaule(int[] w , int[] v , int index , int capacity){

        if (index<0 || capacity<0)
            return 0 ;

        int res = maxVaule(w , v ,index-1 , capacity);

        if(w[index] <= capacity){
            return Math.max(res , v[index] + maxVaule(w, v , index-1 , capacity-w[index])) ;
        }

        return res ;
    }

    public static int maxValueDp(int[] w , int[] v , int index , int capacity){

//        for(){
//
//
//        }

        return 0 ;

    }







}
