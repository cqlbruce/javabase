package com.sun.al;

public class RegExp {


    public static void main(String[] args) {
        String p = ".a.*b" ;
        String s = "aab" ;
        System.out.println(check(p , s));
    }

    public static boolean check(String p , String s){

        char[] pp = p.toCharArray();
        char[] ss = s.toCharArray();

        int k = 0 ;
        for(int i = 0 ; i<pp.length ; i++){
            if('.'==pp[i]){
                k++;
                continue;
            }
            if('*'==pp[i]){
                continue;
            }
            if((i+1<pp.length)&&'*'==pp[i+1]){
                while(true){

                    if('.'==pp[i]){
                       k++;
                    }
                    if(pp[i]==ss[k]){
                        k++;
                        continue;
                    }
                    break;
                }
                continue;
            }
            if(pp[i] !=ss[k] ){
                return false ;
            }
            k++ ;
            if(k>ss.length-1){
                return false ;
            }
        }
        return true ;
    }


}
