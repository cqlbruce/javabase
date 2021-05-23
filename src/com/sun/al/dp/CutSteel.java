package com.sun.al.dp;

public class CutSteel {


    public static void main(String[] args) {
        try{
            int len = 15 ;
            int[] price = {1 , 5 , 10 , 16 , 18 , 19 , 20 , 25 , 27 , 30};
            int[] mem = new int[len];
            System.out.println(cut(price ,len , mem));
//            System.out.println(cutRod(price ,len));
        }catch (Exception e ){
            e.printStackTrace();
        }

    }

    public static int cut(int[] price , int len , int[] mem){
        if (mem[len-1]!=0){
            return mem[len];
        }
        if (len==0){
            return 0 ;
        }
        if (len==1){
            return price[0] ;
        }
        int max = 0 ;
        for (int i=0 ; i<len ; i++){
            if (i==0){
                if (len<price.length){
                    max=price[len-1];
                }
            }else {
                int cuts = cut(price , i , mem) + cut(price , len-i , mem);
//                mem[i] = cuts ;
                max = Math.max(max , cuts) ;
            }
        }
        return max ;
    }

    static int cutRod(int prof[], int n)
    {
        if (n == 0)
            return 0;
        else
        {
            int profit = 0;
            for (int i = 1; i <= n; i++)
                profit = Math.max(profit, prof[i] + cutRod(prof, n - i));
            return profit;
        }

    }


    int memoizedCutRodAux(int pro[], int r[], int n)
    {
        if (r[n] > 0)
            return r[n];
        else
        {
            int profit = 0;
            for (int i = 1; i <= n; i++)
                profit = Math.max(profit, pro[i] + memoizedCutRodAux(pro, r, n - i));
            r[n] = profit;
            return profit;
        }
    }


}
