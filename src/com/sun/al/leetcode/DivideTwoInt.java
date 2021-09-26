package sun.al.leetcode;

public class DivideTwoInt {


    public static void main(String[] args) {
        DivideTwoInt dti = new DivideTwoInt();
        //-2147483648
          //      -1

        //2147483647
        //3

        //-2147483648
         //       -1
        //2147483647
       // 2
        System.out.println(dti.divide(2147483647 , 2));

    }

    public int divide(int dividend , int divisor){

        if (divisor==0)
            return Integer.MAX_VALUE;

        int result=0;
        if(divisor == 0) //除数为0，返回最大值
            return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return ~dividend;
        }

        long temp = 0 ;
        int res = 0 ;
        long divie = Math.abs((long) dividend);
        long divis = Math.abs((long)divisor);
        if (divie<divis)
            return 0;
//        int i = 1 ;

        while (divie>=divis){

                int i=0 ;
                //temp = divis<<i;
                while(divie >= divis<<i){
                    i++;//记录左移次数（比实际次数多1）
                }
//                if (divie<=temp){//为何这种写法执行效率很慢
//                    i=1;
                divie = divie - (divis<<(i-1));
                //res = res + 1<<(i-1);  //这样为何返回结果不一致  res += 1<<(i-1);
                res += 1<<(i-1);
//                }

//                i = i+1;
//                while(dividend1 >= divisor1)//当被除数大于除数时，进行位移操作
//                {
//                    int shiftnum = 0;
//                    while(dividend1 >= divisor1<<shiftnum){
//                        shiftnum++;//记录左移次数（比实际次数多1）
//                    }
//                    result += 1<<(shiftnum-1);
//                    dividend1 -= divisor1<<(shiftnum-1);//更新被除数的值
//                }
            }



        if (dividend<0&&divisor<0){
            if (res>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            return  (int) res ;
        }else if (dividend<0 || divisor<0){
            return -(int) res;
        }

        return (int) res ;
    }


    public int divieTwo(int dividend, int divisor){
            int result=0;
            if(divisor == 0) //除数为0，返回最大值
                return Integer.MAX_VALUE;
            if(dividend == Integer.MIN_VALUE && divisor == -1){
                return ~dividend;
            }
            long dividend1 = Math.abs((long)dividend);
            long divisor1 = Math.abs((long)divisor);

            while(dividend1 >= divisor1)//当被除数大于除数时，进行位移操作
            {
                int shiftnum = 0;
                while(dividend1 >= divisor1<<shiftnum){
                    shiftnum++;//记录左移次数（比实际次数多1）
                }
                result += 1<<(shiftnum-1);
                dividend1 -= divisor1<<(shiftnum-1);//更新被除数的值
            }
            if((dividend>0 && divisor>0)||(dividend<0 && divisor<0))//计算正负数
                return result;
            else
                return -result;

    }

}
