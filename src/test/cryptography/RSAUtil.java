package com.sun.al.cryptography;

import java.util.concurrent.ThreadLocalRandom;

public class RSAUtil {


    public static void main(String[] args) {
        int i = 2 << 10 ;
        System.out.println(i);
    }


    public static long gcd(long m , long n ){
        while (true){
            if((m = m % n) == 0)
                return n ;
            if ((n = n % m) == 0 )
                return m ;
        }
    }

    public static long getPrime(int range , int rounds){
        if(range > 0 && rounds > 0){
            ThreadLocalRandom random = ThreadLocalRandom.current();
            while (true){
                int num = random.nextInt(range)+2 ;
                if(RSAUtil.primeTester(num))
                    return  num ;
            }
        }
        return -1 ;
    }


    public static boolean primeTester(long t){
        //0 1 既不是素数也不是合数
        if(t<=3){
            return t>1 ;
        }
        //我们继续分析，其实质数还有一个特点，就是它总是等于 6x-1 或者 6x+1，其中 x 是大于等于1的自然数。
        //如何论证这个结论呢，其实不难。首先 6x 肯定不是质数，因为它能被 6 整除；其次 6x+2 肯定也不是质数，因为它还能被2整除；依次类推，6x+3 肯定能被 3 整除；6x+4 肯定能被 2 整除。那么，就只有 6x+1 和 6x+5 (即等同于6x-1) 可能是质数了。所以循环的步长可以设为 6，然后每次只判断 6 两侧的数即可。
        if(t%6 != 1&& t%6 != 5){
            return false ;
        }
        //如果t是合数，那么必然存在p*q=t 且p<sqrt(t) q>sqrt(t)
        long sqrt = (long)Math.sqrt(t);
        for(int i=2 ; i<=sqrt ; i++){
            if(t%i==0)
                return false ;
        }
        return true ;
    }

}
