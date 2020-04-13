package com.sun.al.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SubstringConcatenationAllWords {


    public static void main(String[] args) {

        SubstringConcatenationAllWords sca = new SubstringConcatenationAllWords();
//        s = "barfoothefoobarman",
//                words = ["foo","bar"]
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(s.indexOf("foo"));

//        List<Integer> list = sca.findSubstring(s , words);
//        System.out.println(list);

    }

    public List<Integer> findSubstring(String s, String[] words) {

        // 1 、轮询所有数组内情况,找到第一个单词在s中的位置
        int index = words[0].length();
        List<Integer> list = new ArrayList<>();
        String ss = s ;
        String[] wordss = words;
        for (int i = 0 ; i<words.length ; i++){
            int k = ss.indexOf(words[i]);

            if (k!=-1){
                words[i] = "";//匹配过后置为空
                for (int j=0 ; j<words.length; j++){
                    if (words[j].equals(""))
                        continue;
                    String str = s.substring(i+index*(j+1));
                    k = s.indexOf(str);
                    if (k!=-1){
                        words[j]="";
                        list.add(k);
                    }else {
                        return new ArrayList<>();
                    }
                }
            }

        }

        return list ;
    }


}
