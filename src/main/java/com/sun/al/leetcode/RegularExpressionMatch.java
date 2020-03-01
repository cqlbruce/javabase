package com.sun.al.leetcode;

public class RegularExpressionMatch {


    public static void main(String[] args) {

        RegularExpressionMatch pem = new RegularExpressionMatch();
        //System.out.println(pem.isMatchTwo("aab" , "c*a*b"));
        //System.out.println(pem.isMatchTwo("aab" , ".*b"));
        System.out.println(pem.isMatchTwo("aaaa" , "a*a"));


    }

    public boolean isMatchOne(String s , String p , int index){

        if (s.isEmpty()&&index==(p.length()))
            return true;

        if('.'==p.charAt(index)){
            return isMatchOne(s.substring(1),p , ++index);
        }
        if ("*".equals(p.charAt(0))){
            while (true){
                if (s.charAt(0)==p.indexOf(index))
                    s=s.substring(1);
                else
                    return isMatchOne(s , p , ++index);
            }
        }
        if (p.charAt(index)!=s.charAt(0)){
            return false;
        }else {
            return isMatchOne(s.substring(1) , p , ++index);
        }

    }

    public boolean isMatchTwo(String s , String p ){

        if (p.length() == 0) {
            return s.length() == 0;
        }

        // 表示第一个字符是否匹配上
        boolean first_match = (s.length() != 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));

        // 如果pattern是"x*"类型的话,那么pattern每次要两个两个的减少。否则,就是一个一个的减少
        if (p.length() == 1 || p.charAt(1) != '*') {
            return first_match && isMatchTwo(s.substring(1), p.substring(1));
        } else {
            return (isMatchTwo(s, p.substring(2)) ||
                    (first_match && isMatchTwo(s.substring(1), p)));
        }

    }


}
