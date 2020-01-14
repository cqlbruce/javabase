package com.sun.al.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestSubstring {

    public static void main(String[] args) {

//        System.out.println(lengOfLongestSubstringOne("bbbabc"));
//        System.out.println(lengOfLongestSubstringOne("abcabcbb"));
//        System.out.println(lengOfLongestSubstringOne("au"));
//        System.out.println(lengOfLongestSubstringOne(""));

        System.out.println(lengOfLongestSubstringTwo("bbbabc"));
        System.out.println(lengOfLongestSubstringTwo("abcabcbb"));
        System.out.println(lengOfLongestSubstringTwo("au"));
        System.out.println(lengOfLongestSubstringTwo(""));
        System.out.println(lengOfLongestSubstringTwo("abba"));
        System.out.println(lengOfLongestSubstringTwo("pwwkew"));
        System.out.println(lengOfLongestSubstringTwo("aab"));
    }
    //s1: 暴力破解法 去除重复项
    // abcabckk  --> abc
    public static int lengOfLongestSubstringOne(String s){
        if("".equals(s)||null==s){
            return 0 ;
        }
        String maxStr = s.substring(0 , 1);
        String a = "";
        String b = "";
        Boolean flag = false ;
        char c = '\0';

        for (int i = 0 ; i<s.length() ; i++){
            for (int j = 0 ; j<i ; j++){
                if ((i-j+1)==maxStr.length())
                    break;;
                a = s.substring(j , i+1) ;
                b = "";
                if ((i+a.length()-1)<s.length()-1){
                    b = s.substring(i , i+a.length()-1);
                }
                //比较字符串整体相等性
                if(a.equals(b))
                    continue;
                boolean f = false;
                //比较字符串内部重复性
                for (int k=0 ; k<a.length() ; k++){
                    c = a.charAt(k);
                    if (a.indexOf(c) != a.lastIndexOf(c)){
                        f = true;
                    }
                }
                if (f)
                    continue;
//                c = s.charAt(i);
//                if (a.indexOf(c) != a.lastIndexOf(c))
//                    continue;
                if (maxStr.length()<a.length())
                    maxStr = a ;
            }
        }
        return maxStr.length() ;
    }

    //s2:使用hashmap下标来做，瞬间可以把时间复杂度下降到o(n)
    //
    public static int lengOfLongestSubstringTwo(String s){
        //  "abba"  pwwkew
        Map<Character , Integer> map = new HashMap<Character , Integer>();
        int res = 0 , left = -1 , i=0;
        while (i<s.length()){
            if(map.containsKey(s.charAt(i))&&(map.get(s.charAt(i))>left)){
                left = map.get(s.charAt(i))  ;
                map.put(s.charAt(i) , i);
            }else {
                map.put(s.charAt(i) , i);
            }
            res = Math.max(res,i-left);
            i++ ;
        }
        return res ;
    }

    //s3: 使用数组下标来做
    public static int lengOfLongestSubstringThree(String s) {
        int[] m = new int[256];
        Arrays.fill(m, -1);
        int res = 0, left = -1;
        for (int i = 0; i < s.length(); ++i) {
            left = Math.max(left, m[s.charAt(i)]);
            m[s.charAt(i)] = i;
            res = Math.max(res, i - left);
        }
        return res;
    }

    //s4:使用HashSet来做
    public static int lengOfLongestSubstringFour(String s) {
        int res = 0, left = 0, right = 0;
        HashSet<Character> t = new HashSet<Character>();
        while (right < s.length()) {
            if (!t.contains(s.charAt(right))) {
                t.add(s.charAt(right++));
                res = Math.max(res, t.size());
            } else {
                t.remove(s.charAt(left++));
            }
        }
        return res;
    }

}
