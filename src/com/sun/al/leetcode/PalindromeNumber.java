package sun.al.leetcode;


/*
*
* Follow up:
Coud you solve it without converting the integer to a string?
* */
public class PalindromeNumber {

    public static void main(String[] args) {
//        System.out.println(isPalindrome(121));
//        System.out.println(isPalindrome(12345345));
        System.out.println(isPalindromeTwo(12321));
//        System.out.println(isPalindromeTwo(10));
    }

    //思路:先建模
    // 确定一个数的总位数。
    //每次对比首位两位数，对比完则减掉相应的值
    public static boolean isPalindromeOne(int x){

        if (x<0)
            return false;
        if (x<10)
            return true;
        int i=1 ;
        int l = 0 ;
        int j=1 ;
        while (j>0){
            l++ ;
            i=i*10;
            j = x/i ;
            if (l==10)
                break;
        }

        while (l>1){
            int y = x%10 ;
            int z = x/(int)Math.pow(10,l-1) ;
            if (y!=z){
                return false;
            }
            x = (x - z *(int)Math.pow(10,l-1))/10 ;
            l = l-2 ;
        }
        return true;
    }


    // 方式二、 取出来的一半的数字完全可以逆序再重组， 重组完直接跟剩下的前半部分数字比较一下
    //方式三、看了一下讨论区， 发现其实时间都花费在求x的位数上面， 我们可不可以不求x的位数呢？
    /*
    *
    * 我们在把x的位数不断抽走的过程中， rev的位数是不断增加的， x的位数不断减小:
    * 如果是奇数的话， 取到一半加1的位置以后x > rev 就变成了x < rev;
    * 我们就可以根据x > rev为循环判断条件
    * 如果是偶数的话，取到一半如果x <= rev,  退出循环， 如果x仍然大于rev， 多取一位， 退出循环
    * 取完之后只有两种情况是回文：
    * 1）奇数：rev//10 == x
    * 2)  偶数： rev == x
    *
    *
    * ---------------------牛叉，对比上下真是天壤之别-------------------------------
    * */
    public static boolean isPalindromeTwo(int x){
        if(x>=0&&x<10){
            return true;
        }
        if (x<0 || x%10==0)
            return false;
        int rev = 0 ;
        while (rev<x){
            rev = rev*10 + x%10;
            x = x/10 ;
        }

        return rev==x || rev/10==x  ;
    }

}
