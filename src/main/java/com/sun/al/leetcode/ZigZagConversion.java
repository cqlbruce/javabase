package com.sun.al.leetcode;





/*
*
* ZigZag Conversion
*
* The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
string convert(string s, int numRows);
Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:
*
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
*
P     I    N
A   L S  I G
Y A   H R
P     I
*
* */
public class ZigZagConversion {



    public static void main(String[] args) {
        System.out.println(convertOne("PAYPALISHIRING" , 3));
    }

    /*
    * 建模思路很重要
    * 1、首先将字符串拼装转换成为找下标指数规律。
    * 2、将值构建为以行 i 列 j 为参数的等式。
    * V1 = i + (2N-2)*j
    * V2 = V1 - 2*i
    * */
    public static String convertOne(String s , int numRows){

        char[] cs = new char[s.length()];
        int index1=0 , index2=0 , k=0;
        for (int i=0 ; i<numRows ; i++){
            for (int j=0 ; j<(s.length()/numRows + 1) ; j++){
                index1 = i + (2*numRows-2)*j;
                if(index1<s.length()){
                    cs[k] = s.charAt(index1) ;
                    k++;
                }
                index2 = index1-2*i;
                if (index2!=index1&&index2<s.length()){
                    cs[k] = s.charAt(index1) ;
                    k++;
                }
            }
        }
        return new String(cs) ;
    }


}
