package sun.al.leetcode;

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {

        LongestValidParentheses lvp = new LongestValidParentheses();
        //"()(())"
        //"()(()"
        System.out.println(lvp.longestValidParenthesesOne("()(())"));

    }

    public int longestValidParenthesesTwo(String s){
        if (s==null||s.length()==0)
            return 0;

        int res = 0 ;
        int j = 0 ;
        Stack<Character> stack = new Stack<>();
        Boolean flag = false;
        for (int i=0 ; i<s.length() ; i++) {
            if (flag&&!stack.empty()){

            }else if ('('==s.charAt(i)){
                if (!stack.empty()){
                    stack = new Stack<>();
                    j=0;
                }
                stack.push('(');
                continue;
            }

            if (')'==s.charAt(i)&&!stack.empty()&&stack.peek()!=null){
                j = j+2;
                if (res<j)
                    res = j ;
                stack.pop();
                flag = true;
            }else {
                j= 0 ;
                stack = new Stack<>();
            }


        }

        return res;

    }



    public int longestValidParenthesesOne(String s){
        if (s==null||s.length()==0)
            return 0;
        int res = 0 ;
        int j = 0 ;
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        for (int i=0 ; i<s.length() ; i++){
            if (flag&&'('==s.charAt(i)){
                stack.push(s.charAt(i));
                continue;
            }

            if (')'==s.charAt(i)&&!stack.empty()&&stack.peek()!=null){
                j = j+2;
                stack.pop();
                if (!stack.empty()){
                    flag = false;
                }
            }else {
                j= 0 ;
                stack = new Stack<>();
                flag=true;
            }
            if (res<j)
                res = j ;
        }
        return res;
    }

}

