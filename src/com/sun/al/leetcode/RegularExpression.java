package com.sun.al.leetcode;

public class RegularExpression {


    public static void main(String[] args) {

        System.out.println(isMatchOne("aab" , "c*a*b"));

    }

    // 暴力破解  --- 暴力破解行不通，根本没法穷举，这时候一定要考虑递归与动态规划，暴力破解行不通的关键信号在什么地方呢？
    // 时间效率o(n*n)
    public static boolean isMatchOne(String s , String p ){
        int j = 0 ;
        for (int i=0 ; i<p.length() ; i++ ){
            if (j>s.length())
                return false;
            char c = p.charAt(i);
            if ('*'==c)
                continue;
            if ((i+1)<p.length()&&'*' == p.charAt(i+1)){
                if ('.'==c) //.* 这种情况最麻烦  abc.*bc.*dd.*
                    return true;
                while (true){
                    if (c != s.charAt(j))
                        break;
                    j++;
                    if (j>=s.length())
                        return true;
                }
            }else {
                if ('.' == c){
                    j++;
                    continue;
                }
                if (c == s.charAt(j)){
                    j++;
                    continue;
                } else {
                    return false;
                }
            }
        }

        if (j< s.length())
            return false;
        return true;
    }

    /*
    *
    * 递归调用
    *
    * */
    public static boolean isMatchTwo(String s , String p){

        if (p.length() == 0 )
            return s.length() == 0 ;

        if (p.length() == 1)
            return (s.length() == 1 ) && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');

        if (p.charAt(1) != '*'){
            if (s.length()==0)
                return false;
            else
                return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatchTwo(s.substring(1) , p.substring(1));
        }else {
            while (s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')){
                if (isMatchTwo(s , p.substring(2)))
                    return true;
                s = s.substring(1);
            }
            return isMatchTwo(s , p.substring(2));
        }

    }

    /*
    *
    * 动态规划
    *
    * */
    public static boolean isMatchThree(String s , String p ){




        return false ;
    }


}
