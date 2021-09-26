package sun.al.leetcode;

import java.util.Arrays;

public class test {


//    给定一个非空字符串 s 和一个包含⾮空单词列列表的字典 wordDict，判定 s 是否可以被空格拆分为⼀个或多个在字典中出现的单词。
//    说明:
//            1. 拆分时可以重复使⽤用字典中的单词。 2. 你可以假设字典中没有重复的单词。
//    示例例 1:
//    输⼊入: s = "leetcode", wordDict = ["leet", "code"]
//    输出: true
//    解释:返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
//    示例例 2:
//    输⼊入: s = "applepenapple", wordDict = ["apple", "pen"]
//    输出: true
//    解释: 返回 true 因为 "applepenapple" 可以被拆分成"apple pen apple"。 注意你可以重复使⽤用字典中的单词。
//    示例例 3:
//    输⼊入:s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"] 输出: false
//

    public static void main(String[] args) {

        String s = "applepenappl";
        String[] wordDict = {"apple", "pen"};

        System.out.println(checkStr(s , wordDict));

    }

    public static boolean checkStr(String s , String[] wordDict){

        if (s.isEmpty())
            return true ;

        boolean flag = false ;
        for (int i =0 ; i<s.length() ; i++){
            String ss = s.substring(0 , i+1);
            if (Arrays.asList(wordDict).contains(ss)){
                flag = checkStr(s.substring(i+1 , s.length()), wordDict);
                if (flag)
                    return true;
            }
        }

        return false;
    }



    public int fibonacci(int n){

        if (n == 1 || n == 2)
            return 1 ;
        else
            return fibonacci(n-2) + fibonacci(n-1);
    }





}
