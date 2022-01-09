package sun.al.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WildCardMatchingTwo {


    public static void main(String[] args) {

//        String s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb" ;
//        String s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb" ;
//        String p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*saaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb" ;
//      String p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a" ;
        //String s = "abcabczzzde" ;
//        String p = "*abc???de*" ;
//        String s = "ab" ;
//        String p = "*a" ;
        String s = "abcabczzzde" ;
        String p = "*abc???de*" ;
       // "abcabczzzde"
        //"*abc???de*"
        System.out.println(isMatch1(s , p ,  0 , 0)) ;

        //"abcabczzzde"
       // "*abc???de*"
//        System.out.println(isMatch2(s , p )) ;

    }



    public static boolean isMatch2(String s , String p){

        int i = 0;
        int j = 0;
        int star = -1;
        int mark = -1;
        while (i < s.length()) {
            if (j < p.length()
                    && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                ++i;
                ++j;
            } else if (j < p.length() && p.charAt(j) == '*') {
                star = j++;
                mark = i;
            } else if (star != -1) {
                j = star + 1;
                i = ++mark;
            } else {
                return false;
            }
        }
        while (j < p.length() && p.charAt(j) == '*') {
            ++j;
        }
        return j == p.length();



    }


    public static boolean isMatch1(String s , String p ,int sindex , int pindex){


        while(sindex<s.length()||pindex<p.length()){
            if ((sindex<s.length()&&pindex<p.length()&&s.charAt(sindex)==p.charAt(pindex))||sindex<s.length()&&pindex<p.length()&&p.charAt(pindex)=='?'){
                sindex=sindex+1;
                pindex=pindex+1;
                continue;
            }
            while (pindex<p.length()&&p.charAt(pindex)=='*'){
                System.out.println("pindex pre= " + pindex);
                if(p.substring(pindex).replace("*" , "").length()==0){
                    return true ;
                }
                pindex=pindex+1;
                if (pindex<p.length()&&p.charAt(pindex)!='*'){
                    while (sindex<s.length()) {
                        boolean b = true ;
                        if (p.charAt(pindex)=='?'){
                            sindex = sindex+1 ;
                        }else {
                            sindex = s.indexOf(p.charAt(pindex) , sindex);
                            if (sindex==-1){
                                return false;
                            }else {
                                sindex = sindex + 1 ;
                            }
                        }
                        int sindexBak = sindex;
                        int pindexBak = pindex + 1;
                        while(sindexBak<s.length()||pindexBak<p.length()){
                            if ((sindexBak<s.length()&&pindexBak<p.length()&&s.charAt(sindexBak)==p.charAt(pindexBak))||sindexBak<s.length()&&pindexBak<p.length()&&p.charAt(pindexBak)=='?'){
                                sindexBak=sindexBak+1;
                                pindexBak=pindexBak+1;
                                continue;
                            }
                            if (pindexBak<p.length()&&p.charAt(pindexBak)=='*'){
                                if(p.substring(pindexBak).replace("*" , "").length()==0){
                                    return true ;
                                }
                                return isMatch1( s ,  p , sindexBak ,  pindexBak);
                            }
                            b = false ;
                            break;
                        }
                        if (b){
                            return true;

                        }
//
//                        boolean b = isMatch1(s , p , sindex , pindex+1);
//                        if (b) {
//                            return true;
//                        }
                    }
                }
            }
            return false;
        }
        return true ;
    }
}
