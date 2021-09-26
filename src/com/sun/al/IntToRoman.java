package sun.al;

public class IntToRoman {


    public static void main(String[] args) {
        int i = 1670 ;
        System.out.println(IntToRoman.intToRoman(i));
    }

    public static String intToRoman1(int num ){
        StringBuffer res = new StringBuffer("");
        char[] symbol = {'I','V','X','L','C','D','M'};
        int[] value = {1 , 5 , 10 , 50 , 100 , 500 , 1000};
        for(int i=symbol.length-1 ; i<0 ; i--){
            int j = num/value[i];
            if (j<4){
                for(int k=0 ; k<j ; k++) res.append(symbol[j]);
                num = num%value[i];
            }
//            if ()
        }
        return null ;
    }

    public static String intToRoman(int num ){
        StringBuffer value = new StringBuffer("");
        int m = num/1000 ;
        if (m>0){
            value.append("M") ;
            num = num % 1000 ;
        }
        int d = num/500 ;
        if (d>0){
            value.append("D") ;
            num = num % 500 ;
        }

        int c = num/100 ;
        if (c>0){
            value.append("C") ;
            num = num % 100 ;
        }

        int l = num/50 ;
        if (l>0){
            value.append("L") ;
            num = num % 50 ;
        }

        int x = num/10 ;
        if (x>0){
            value.append("X") ;
            num = num % 10 ;
        }

        int v = num/5 ;
        if (v>0){
            value.append("D") ;
            num = num % 5 ;
        }

        int i = num/1 ;
        if (i>0){
            value.append("I") ;
        }
        return value.toString() ;
    }

}
