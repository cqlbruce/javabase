package com.sun.al.leetcode;

public class LongestCommonPrefix {


    public static void main(String[] args) {

        //Input: ["flower","flow","flight"]
        //Output: "fl"
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] ss = {"flower","flow","flight"} ;
        System.out.println(lcp.longestCommonPrefix(ss));


    }


    public String longestCommonPrefix(String[] strs) {

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
