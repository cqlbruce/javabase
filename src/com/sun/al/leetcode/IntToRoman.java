package sun.al.leetcode;

public class IntToRoman {


    public static void main(String[] args) {

        IntToRoman itr = new IntToRoman();
        System.out.println(itr.intToRoman(1994));
        //Output: "MCMXCIV"
        //Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


    }

    public String intToRoman(int num){

        int temp = 0 ;
        String res = "";
        char[] c = {'M','D','C','L','X','V','I'};
        int[] ints = {1000 , 500 , 100 , 50 , 10 , 5 , 1};
        for (int i=0 ; i<ints.length ; i++){
            if (num==0)
                break;


            if (num==4){
                res = res+"IV";
                num = num - 4 ;
                continue;
            }else if (num==9){
                res = res+"IX";
                num = num - 9 ;
                continue;
            }else if (num<50 && num>=40){
                res = res+"XL";
                num = num - 40 ;
                continue;
            }else if (num<100&&num>=90){
                res = res+"XC";
                num = num - 90 ;
                continue;
            }else if (num<500 && num>=400){
                res = res+"CD";
                num = num - 400 ;
                continue;
            }else if (num<1000 && num>=900){
                res = res+"CM";
                num = num - 900 ;
                continue;
            }

            temp = num/ints[i] ;
            for (int j=0 ; j<temp ; j++){
                res = res + c[i];
            }
            num = num % ints[i];

        }
        return  res ;
    }


}
