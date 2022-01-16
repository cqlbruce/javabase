package sun.al.leetcode;

public class LengthLastWord {


    public static void main(String[] args) {
        String s = " a";

        System.out.println(lengthOfLastWord1(s)) ;

    }

    public static int lengthOfLastWord(String s) {

        String[] ss = s.trim().split(" ");
//
//        for (String s1 : ss){
//            System.out.println(s1);
//        }

        return ss[ss.length-1].length() ;
    }

    public static int lengthOfLastWord1(String s) {
                //if(s.trim().length()==1||s.trim().length()==0){
           // return s.trim().length() ;
       // }
        boolean flag = false;
        int end = 0 ;
        int start = 0 ;
        for (int i=s.length()-1 ; i>=0 ; i--) {

            if (s.charAt(i)!=' '&&flag==false){
                end = i  ;
                flag=true;
            }
            if (s.charAt(i)==' '&&flag==true){
                start = i ;
                return end - start;
            }
        }
       return end - start +1;
    }

}
