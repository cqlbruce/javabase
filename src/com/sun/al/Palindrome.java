package sun.al;

public class Palindrome {


    public static void main(String[] args) {
        int i = 13531;
        System.out.println(palindromeFlag(i));

    }

    public static  boolean palindromeFlag(int i){

        int pa = 0 ;
        int ibak = i;

        if (i<0 || i%10==0)
            return false;

        while (true){

            int a = i/10 ;
            int b = i%10 ;
            pa = pa * 10 + b ;
            if(i<10)
                break;
            else
                i = a ;
        }
        System.out.println(pa);
        if (pa == ibak)
            return true ;
        else
            return false;
    }


}
