package com.sun.al.leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {


    public static void main(String[] args) {

        //Input: ["flower","flow","flight"]
        //Output: "fl"
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] ss = {"flower","flow","flight"} ;
        System.out.println(lcp.longestCommonPrefixOne(ss));


    }



    //暴力破解 时间 n平方
    public String longestCommonPrefixOne(String[] strs){
        if (strs==null || strs.length==0)
            return "";
        String commonPre = "";
        char c = ' ';
        for (int  i=0 ; i<strs[0].length() ; i++){
            c = strs[0].charAt(i);
            for (int j=1 ; j<strs.length ; j++){
                if (strs[j].length()<=i || c != strs[j].charAt(i)){
                    //适时return
                    return commonPre ;
                }
            }
            commonPre = commonPre + Character.toString(c);
        }
        return commonPre ;
    }


    //先找第一 二个，得到前缀再与第三个对比
    public String longestCommonPrefixTwo(String[] strs){

        if (null == strs || strs.length==0){
            return "";
        }

        String commonPre = strs[0];

        for (int i=1 ; i<strs.length ; i++){
            String s = strs[i] ;
            while (!s.startsWith(commonPre))
                commonPre = commonPre.substring(0 , commonPre.length()-1);
        }
        return commonPre;
    }


    //先排序 ， 使得 差异最大的字符在数组两端，那么找出差异最大的两个字符的公共前缀，即为整个数组的最大前缀。
    //找两个字符相等字段案例
    public String longestCommonPrefixThree(String[] strs) {
        if (null == strs || strs.length==0){
            return "";
        }
        Arrays.sort(strs);
        int len = Math.min(strs[0].length() , strs[strs.length-1].length());

        int i = 0 ;
        while (i<len && strs[0].charAt(i) == strs[strs.length-1].charAt(i))
            i++ ;

        return strs[0].substring(0 , i);
    }

        public String longestCommonPrefixFive(String[] strs) {

        int i = 0;
        String s = "";
        String rs = "";
        boolean b = false;
        char c = ' ';
        while (true) {
            for (int j = 0; j < strs.length; j++) {
                s = strs[j];
                if (s.length() <= i-1) {
                    b = true;
                    break;
                }
                if (j == 0) {
                    c = s.charAt(i);
                }

                if (s.charAt(i) != c) {
                    b = true;
                    break;
                }
                if (j==strs.length-1){
                    rs = rs+c ;
                }
            }
            if (b)
                break;
            i++;
        }
        return rs ;
    }

}
