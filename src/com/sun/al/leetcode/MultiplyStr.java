package sun.al.leetcode;

public class MultiplyStr {


    public static void main(String[] args) {
        String num1 = "123" ;
        String num2 = "456" ;
        System.out.println(multiply(num1 , num2));

//        StringBuilder sb = new StringBuilder("abc");
//        System.out.println(sb.insert(0 , (char)1));

    }

    public static String multiply(String num1 , String num2){

        StringBuilder sum = new StringBuilder("0");
//        int sum = 0;
        int c = 0 ;
        for (int i=num2.length()-1 ; i>=0 ; i--){
            if (i!=num2.length()-1){
                c = c+1;
            }
            int b = 0 ;
            int l = 0 ;
            for (int j=num1.length()-1 ; j>=0 ; j--){
                if (j!=num1.length()-1){
                    b = b+1;
                }

                int add = 0 ;
                if (b+c-1>=0&&sum.length()>=b+c+1){
                    add = (num2.charAt(i)-'0') * (num1.charAt(j)-'0') + l + sum.charAt(b+c)-'0';
                }else {
                    add = (num2.charAt(i)-'0') * (num1.charAt(j)-'0') + l ;
                }

                int k = add%10;
                l = add/10;
                sum.replace(b+c , b+c+1 ,  String.valueOf(k));
            }
            if (l>0){
                sum.insert(sum.length(), l);
            }
        }

        String reStr =  sum.reverse().toString().replaceFirst("^0*", "");
        if ("".equals(reStr)){
            return "0" ;
        }else {
            return reStr ;
        }
    }

}
