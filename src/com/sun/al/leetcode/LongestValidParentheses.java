package sun.al.leetcode;

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {

        LongestValidParentheses lvp = new LongestValidParentheses();
        //"()(())"
        //"()(()"

//        String str = "12&&&3456&78";
//        String[] ss = str.split("&");
//        System.out.println(ss.length);
        //"()(())"  ")(((((()())()()))()(()))("
        System.out.println(lvp.lvp(")(((((()())()()))()(()))("));

    }


    public static int lvp(String s){

        if (null==s||s.isEmpty())
            return 0 ;

        Stack<Integer> stack = new Stack<Integer>();
        int[] ints = new int[s.length()];
        for (int i=0 ; i<s.length();i++){
            ints[i]= -1 ;
            if (s.charAt(i)=='('){
                stack.push(i);
            }

            if (stack.size()>0&&s.charAt(i)==')'){
                int p = stack.peek();
                if (i-p==1){
                    ints[i-1]=p;
                    ints[i] = i;
                }else if(p+1==ints[p+1]){
                    ints[p]=p;
                    ints[i]=i;
                }
                stack.pop();
            }

        }

        String str ="";
        for (int i : ints){
            if (i==-1){
                str = str + "&" ;
            }else {
                str = str + "a" ;
            }
        }
        String[] ss = str.split("&");
        int sum = 0  ;
        for (int i=0 ; i<ss.length ; i++){
            if (ss[i].length()>sum){
                sum = ss[i].length();
            }
        }
        return sum;
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

