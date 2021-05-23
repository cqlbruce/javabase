package com.sun.al.leetcode;

public class Atoi {

    public static void main(String[] args) {

//        System.out.println(myAtoiOne("   -42"));
//        System.out.println(myAtoiOne("words and 987"));
//        System.out.println(myAtoiOne("4193 with words"));
        System.out.println(myAtoiOne("2147483648"));
    }


    //这种可以解出来，但是总感觉太挫啦。
    public static int myAtoiOne(String str) {
        // 先处理第一个字符
        char pre = ' ';
        int start = 0 ; //字符开始
        boolean flag = false;
        StringBuffer s = new StringBuffer("");
        boolean isNagative = false ;
        for (int i=0 ; i<str.length() ; i++){

            if ('+'==str.charAt(i) || '-' == str.charAt(i) || ' ' == str.charAt(i)){
                if (pre!=' ')
                    break;
                if ('-' == str.charAt(i))
                    isNagative = true ;
                pre = str.charAt(i) ;
                continue;
            }
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                flag = true ;
                pre = str.charAt(i);
                s.append(str.charAt(i));
                continue;
            }else {
                break;
            }
        }
        if (s.length()==0)
            return 0 ;
        String intStr = s.toString();
        Double d = Double.parseDouble(intStr);
//        Long l = Long.parseLong(intStr);

        if (isNagative){
            if (-d<=-2147483648)
                return -2147483648;
            else
                return -d.intValue();
        }else {
            if (d>=Math.pow(2,31))
                return 2147483647;
            else
                return d.intValue();
        }
    }





}
