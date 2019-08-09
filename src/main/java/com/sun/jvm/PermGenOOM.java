package com.sun.jvm;

import java.util.ArrayList;
import java.util.List;

public class PermGenOOM {




    public static void main(String[] args) {

        List<String> sList = new ArrayList<String>();
        int i = 0 ;
        while (true){
            System.out.println("yes........."+(i++));
            String str = "asdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdf" ;
            sList.add((str + String.valueOf(i++)).intern()) ;
            System.out.println("yes........."+(str + String.valueOf(i++)));

        }
    }

}
