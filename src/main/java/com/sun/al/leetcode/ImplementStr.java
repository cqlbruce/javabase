package com.sun.al.leetcode;

public class ImplementStr {


    public static void main(String[] args) {

        ImplementStr is = new ImplementStr();
        System.out.println(is.strStr("a" , "a"));


    }

    public int strStr(String haystack , String  needle){

        if (needle==null || "".equals(needle))
            return 0 ;

        if (haystack == null || "".equals(haystack))
            return -1 ;
        boolean flag = true;
        for (int i=0 ; i < haystack.length() ; i++){
            if ((i+needle.length())<=haystack.length()&&haystack.charAt(i) == needle.charAt(0)){
                for (int j=1 ; j<needle.length() ; j++){
                    if (haystack.charAt(i+j)!=needle.charAt(j)){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    return i ;
                }
                flag = true;
            }
        }
        return -1 ;
    }

}
