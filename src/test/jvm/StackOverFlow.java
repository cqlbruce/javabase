package com.sun.jvm;

public class StackOverFlow {

    static int i = 0 ;
    public static void main(String[] args) {
            count();
    }


    public static void count(){

        System.out.println("i===============" + (i++));
        count();
    }


}
