package com.sun.desinpattern;

public class CGLibBeProxy {

    public CGLibBeProxy(){
        System.out.println("Hello I will be Proxy");
    }

    final public String finalMethod(String name){
        System.out.println("I am final Method " + name );
        return null ;
    }

    public void ordinaryMethod(){
        System.out.println("hello I am ordinaryMethod...");
    }

}
