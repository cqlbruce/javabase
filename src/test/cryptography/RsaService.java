package com.sun.al.cryptography;

import java.util.Base64;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RsaService {


    //密钥属性组
    private long n , d , e ;

    //素数的选择范围
    private static final int RANGE = 2 << 10 ;

    //加密完得到的
    private static final  int SPLIT_POINT = 2 << 8 ;

    //素性测试轮数
    private static final  int PRIMALITY_TESTING_ROUNDS = 4 ;

    //Base64编码工具
    private static final Base64.Encoder encoder = Base64.getEncoder();
    private static final Base64.Decoder decoder = Base64.getDecoder();

    public RsaService(){

        Random random = ThreadLocalRandom.current();
        long p = RSAUtil.getPrime(RANGE,PRIMALITY_TESTING_ROUNDS);
        long q ;
        do{
            q = RSAUtil.getPrime(RANGE,PRIMALITY_TESTING_ROUNDS);
        }while (p == q) ;

        this.n = p*q ;
        long eulerVal = (p-1)*(q-1);

        //随机地取一个正整数 e , 1 < e < &(n) 且(e,&(n))=1 , 将e公开
//        do{
//            e = Math.abs(random.nextLong()) % eulerVal + 1 ;
//        }while(RSAUtil.gcd(e,eulerVal));


    }


}
