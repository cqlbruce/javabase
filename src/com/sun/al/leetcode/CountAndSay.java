package sun.al.leetcode;

public class CountAndSay {


    public static void main(String[] args) {

        CountAndSay cas = new CountAndSay();
        System.out.println(cas.countAndSay(10));

    }

    public String countAndSay(int n){

        if (n==0)
            return "";
        if (n==1)
            return "1";
        if (n==2)
            return "11";
        String str = countAndSay(n-1);

        String res = "";
        char c = str.charAt(0);
        int j = 1;
        for (int i=1 ; i<str.length() ; i++){

            if (str.charAt(i)==c){
                j++;
            }else {

                res = res + j + Character.toString(c) ;
                j=1;
                c=str.charAt(i);

            }
        }
        return res+j+Character.toString(c);
    }


}
