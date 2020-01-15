package com.sun.al.leetcode;


/*
*
* Longest Palindromic Substring
*
* Given a string s, find the longest palindromic substring in s.
* You may assume that the maximum length of s is 1000.
*
* Example 1:
    Input: "babad"
    Output: "bab"
    Note: "aba" is also a valid answer
*
* Example 2:
    Input: "cbbd"
    Output: "bb"
* */
public class LongestPalindrome {

    //回文：关于中间字符对称的文法，即“aba”(单核)、“cabbac”(双核)等
    //最长回文子串：1.寻找回文子串；2.该子串是回文子串中长度最长的。

    public static void main(String[] args) {

        String str = "abacc";
        String str1 = "acaacc";
        String str2 = "bb";
        String str3 = "ccc";

        System.out.println(longestPalindromeOne(str));
        System.out.println(longestPalindromeOne(str1));
        System.out.println(longestPalindromeOne(str2));
        System.out.println(longestPalindromeOne(str3));

    }


    /*
    *
    * s1: 暴力破解
    *
    * */
    public static String longestPalindromeOne(String s ){
        if (null==s||"".equals(s))
            return "";
        if (s.length()==1)
            return s;
        String maxStr = "";
        String tempStr = "";
        boolean flag = false;
        for (int i = 1 ; i<s.length() ; i++){
            char c1 = s.charAt(i);
            char c2 = s.charAt(i-1);
            if (c1 == c2) {//双核
                tempStr = doubleCore(s,i);
                if (tempStr.length()>=maxStr.length())
                    maxStr = tempStr ;
            }
            //单核
            tempStr = singleCore(s,i);
            if (tempStr.length()>=maxStr.length())
                maxStr = tempStr ;
        }
        if(maxStr.length()==0){
            return s.substring(0,1);
        }
        return maxStr ;
    }

    public static String singleCore(String s , int i){
        String maxStr="";
        for (int j = 1 ; j <= i ; j ++) {
            if (i-j<0||i+j>=s.length())
                break;
            //单核
            if (s.charAt(i-j) == s.charAt(i+j)){
                String str = s.substring(i-j , i+j+1);
                if (str.length()>maxStr.length())
                    maxStr = str ;
            }else {
                break;
            }
        }
        return maxStr ;
    }

    public static String doubleCore(String s , int i){
        String maxStr=s.substring(i - 1, i + 1);
        for (int j = 1 ; j <= i ; j ++) {
            if (i-j<0||i+j>=s.length())
                break;
            if (i-j-1<0)
                break;
            if (s.charAt(i-j-1) == s.charAt(i+j)){
                String str = s.substring(i-j-1 , i+j+1);
                if (str.length()>maxStr.length())
                    maxStr = str ;
            }else {
                break;
            }
        }
        return maxStr;
    }

    public static String longestPalindromeTwo(String s){

        return null ;
    }




}
