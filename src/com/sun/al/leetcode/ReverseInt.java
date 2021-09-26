package sun.al.leetcode;

public class ReverseInt {


    public static void main(String[] args) {
        System.out.println(reverseIntOne(123));
        System.out.println(reverseIntOne(-123));
        //1534236469
        System.out.println(reverseIntOne(1534236469));
    }

    public static int reverseIntOne(int x ){
        String s = String.valueOf(x);
        String res = "" ;
        if (x < 0){
//            return -Integer.parseInt(reverse(s.substring(1,s.length())));
            res = reverse(s.substring(1,s.length()));
        }else if (x==0||s.length()==1){
            return x ;
        }else {
            res = reverse(s);
        }

        Long l = Long.parseLong(res);
        if (l>Math.pow(2,31)||l<-Math.pow(2,31)){
            return 0 ;
        }
        if (x<0){
            return -l.intValue();
        }else {
            return l.intValue();
        }
    }


    /*
    *
    * 将int 转换为String
    * 然后更换首位下标
    * 数值越界问题
    *
    * */
    public static String reverse(String s){
        int i=0 , j=s.length()-1;
        char[] cs = new char[s.length()];
        while (i<=j){
            cs[j] = s.charAt(i);
            cs[i] = s.charAt(j);
            i++;
            j--;
        }
        return new String(cs);
    }




}
