package com.sun.al.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {


    public static void main(String[] args) {

        LetterCombinationsPhoneNumber lcp = new LetterCombinationsPhoneNumber();
        //["www","wwx","wwy","wwz","wxw","wxx","wxy","wxz","wyw","wyx","wyy","wyz","wzw","wzx","wzy","wzz","xww","xwx","xwy","xwz","xxw","xxx","xxy","xxz","xyw","xyx","xyy","xyz","xzw","xzx","xzy","xzz","yww","ywx","ywy","ywz","yxw","yxx","yxy","yxz","yyw","yyx","yyy","yyz","yzw","yzx","yzy","yzz","zww","zwx","zwy","zwz","zxw","zxx","zxy","zxz","zyw","zyx","zyy","zyz","zzw","zzx","zzy","zzz"]
        //[www, wwx, wwy, wwz, wxw, wxx, wxy, wxz, wyw, wyx, wyy, wyz, wzw, wzx, wzy, wzz, xww, xwx, xwy, xwz, xxw, xxx, xxy, xxz, xyw, xyx, xyy, xyz, xzw, xzx, xzy, xzz, yww, ywx, ywy, ywz, yxw, yxx, yxy, yxz, yyw, yyx, yyy, yyz, yzw, yzx, yzy, yzz, zww, zwx, zwy, zwz, zxw, zxx, zxy, zxz, zyw, zyx, zyy, zyz, zzw, zzx, zzy, zzz]
        String input = "999";
        System.out.println(lcp.letterCombinationsOne(input));


    }







    public List<String> letterCombinationsOne(String digits){
        List<String> list = new ArrayList<String>();
        if(null==digits||digits.length()==0)
            return list ;
        String[] strs = {"","" , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tuv" , "wxyz"} ;
        list.add(Character.toString(strs[Character.getNumericValue(digits.charAt(0))].charAt(0)));
        list.add(Character.toString(strs[Character.getNumericValue(digits.charAt(0))].charAt(1)));
        list.add(Character.toString(strs[Character.getNumericValue(digits.charAt(0))].charAt(2)));
        if(digits.charAt(0)=='7' || digits.charAt(0)=='9'){
            list.add(Character.toString(strs[Character.getNumericValue(digits.charAt(0))].charAt(3)));
        }
        if(digits.length()==1){
            return list ;
        }
        for (int i=1 ; i < digits.length() ; i++){
            List<String> list1 = new ArrayList<String>();
            list1.add(Character.toString(strs[Character.getNumericValue(digits.charAt(i))].charAt(0)));
            list1.add(Character.toString(strs[Character.getNumericValue(digits.charAt(i))].charAt(1)));
            list1.add(Character.toString(strs[Character.getNumericValue(digits.charAt(i))].charAt(2)));
            if(digits.charAt(i)=='7' || digits.charAt(i)=='9'){
                list1.add(Character.toString(strs[Character.getNumericValue(digits.charAt(i))].charAt(3)));
            }
            list = letterComb(list1 , list);
        }
        return list ;
    }

    public List<String>  letterComb(List<String> list1 , List<String> list2){

        List<String> list = new ArrayList<>();
        for (int i=0 ; i<list1.size() ; i++){
            for (int j=0 ; j<list2.size() ; j++){
                list.add(list1.get(i)+list2.get(j));
            }
        }
        return list ;
    }

    public List<String> letterCombinationsTwo(String digits){



        return null ;
    }



}
