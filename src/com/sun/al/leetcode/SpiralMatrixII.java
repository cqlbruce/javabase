package sun.al.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixII {


    public static void main(String[] args) {

        generateMatrix(3);

    }


    public static int[][] generateMatrix(int n){

        int[][] ints = new int[n][n];
        //每一层指数规律是一样的
        //这种数组题目，就是要找到下标之间可循环的规律
        int cel = 0 ;
        int i=0 ;
        int j=0 ;
        int k=1 ;
        while (k<=n*n){

            for (j=cel ; j<n-cel ; j++){
                System.out.print(k+" ");
                ints[i][j]=k;
                k++;
            }
            if (k>n*n){
                break;
            }
            j--;
            for (i=cel+1;i<n-cel;i++){
                System.out.print(k+" ");
                ints[i][j]=k;
                k++;
            }
            if (k>n*n){
                break;
            }
            i--;
            for (j=j-1;j>=cel;j--){
                System.out.print(k+" ");
                ints[i][j]=k;
                k++;
            }
            if (k>n*n){
                break;
            }
            j++;
            for (i=i-1;i>cel;i--){
                System.out.print(k+" ");
                ints[i][j]=k;
                k++;
            }
            if (k>n*n){
                break;
            }
            i++;
            cel++;
//            k++;
        }

        return ints ;

    }




}
