package com.sun.al.dp;

public class RunCell {


    public static void main(String[] args) {

        System.out.println(RecRun(2 , 2));

    }



    public static int RecRun(int i , int j){
        if (i==0)
            return j ;
        if (j==0)
            return i ;
        return RecRun(i-1 , j) + RecRun(i , j-1);
    }



}
