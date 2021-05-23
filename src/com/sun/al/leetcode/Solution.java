package com.sun.al.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {
        Solution s = new Solution();
        s.generateParenthesis(3);

    }


    public List<String> generateParenthesis(int n){

        List<String> res = new ArrayList<String>();
        helper(n , n , "" , res);
        return res ;

    }

    public void helper(int left , int right , String out , List<String> res){

        if (left < 0 || right < 0 || left > right ) return;

        if (left == 0 && right == 0 ){
            res.add(out);
            return;
        }

        helper(left - 1 , right , out+"(" , res);
        helper(left, right - 1 , out + ")" , res);
    }

}
