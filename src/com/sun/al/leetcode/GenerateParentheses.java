package sun.al.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {


    public static void main(String[] args) {

        List<String> strList = new ArrayList<String>();

        generate("",strList,0,0,3);
        for(String str: strList){
            System.out.print(str + ",");
        }


    }

    public static void generate(String str , List<String> resList, int left , int right , int n){

        if (left==n&&right==n){
            if (!resList.contains(str)){
                resList.add(str);
            }
            return;
        }


        if(left<n){
            str = str + "(" ;
            left = left + 1;
            generate(str, resList , left , right,n);
        }

        for (int i=right ; i<left ; i++){
            right = i+1 ;
            str = str + ")" ;
            generate(str  , resList ,left,right , n);
        }
//        if (right<n&&left>right){
//            right = right+1 ;
//            str = str + ")" ;
//            generate(str  , resList ,left,right , n);
//        }

    }



}
