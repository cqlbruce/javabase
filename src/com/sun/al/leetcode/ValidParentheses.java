package sun.al.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {


    public static void main(String[] args) {

        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValidTwo("(])"));

    }

    public boolean isValidOne(String s){

        if(s.length()==1)
            return false;
        Stack<Character> stack = new Stack<>();

        for (int i = 0 ; i<s.length() ; i++){
            Character c = s.charAt(i);
            if (c == '('||c =='['||c == '{'){
                stack.push(c) ;
                continue;
            }

            if ((c == ')'&&stack.empty())||(c == ')'&&stack.pop() != '('))
                return false;
            if ((c == '}'&&stack.empty())||(c == '}'&&stack.pop() != '{'))
                return false;
            if ((c == ']'&&stack.empty())||(c == ']'&&stack.pop() != '['))
                return false;
        }
        if (stack.empty()){
            return true ;
        }else {
            return false ;
        }
    }

    public boolean isValidTwo(String s) {

        if (s.length()==1)
            return false;
        Map<String , String> map = new HashMap<>();
        map.put("(" , ")");
        map.put("{" , "}");
        map.put("[" , "]");
        Stack<String> stack = new Stack<String>();
        for (int i=0 ;i<s.length() ; i++){
            char c = s.charAt(i);
            if (map.containsKey(Character.toString(c))){
                stack.push(Character.toString(c));
                continue;
            }
            if (!stack.isEmpty()&&map.get(stack.peek()).equals(Character.toString(c))){
                stack.pop();
            }else {
                return false;
            }
        }
        return stack.empty();
    }
}
