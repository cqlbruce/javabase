package sun.al.leetcode;

public class PlusOne {


    public static void main(String[] args) {

//        int[] ints = {1 , 2 , 3};
        int[] ints = {9};

        int[] resInt = plusOne(ints);
        for (int i : resInt){
            System.out.println(i+" ");
        }
    }

    public static int[] plusOne(int[] digits){

        int temp = 0 ;
        int carry = 0 ;
        for (int i=digits.length-1 ; i>=0 ; i--){
            temp = digits[i]+carry;
            if (i==digits.length-1){
                temp = temp + 1;
            }
            digits[i] = temp%10;
            carry = temp/10;

        }

        if (carry>0){
            int[] ints = new int[digits.length+1];
            ints[0] = carry;
            for (int i=1 ; i<ints.length ; i++){
                ints[i] = digits[i-1];
            }
            return ints ;
        }

        return digits ;

    }


}
