package com.sun.al;

public class RomanToInt {


    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));

    }


    public static int romanToInt(String s){
        int res = 0 ;
        String r = "IVXLCDM" ;
        int[] v = {1 , 5 , 10 ,50, 100 , 500 , 1000};
        char[] ss = s.toCharArray();
        for(int i=0 ; i<ss.length ; i++){
             int j = r.indexOf(ss[i]);
            System.out.println("-----------" + j + "----------");
            if(i<ss.length-1){
                 int k = r.indexOf(ss[i+1]);
                 if(k>j){
                     res = res + (v[k]-v[j]) ;
                     i++;
                 }else {
                     res = res + v[j];
                 }
                 if(i==ss.length-1){
                     break;
                 }else
                     continue;
             }
             res = res + v[j];
        }

        return res ;
    }
}
