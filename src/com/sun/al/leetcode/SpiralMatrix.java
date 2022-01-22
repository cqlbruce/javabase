package sun.al.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {


    public static void main(String[] args) {

        //Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
        //Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]


//        int[][] ints= {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] ints= {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        int[][] ints= {{3},{2}};

        spiralOrder(ints);

    }

    public static List<Integer> spiralOrder(int[][] matrix){

        List<Integer> list = new ArrayList<>();
        //每一层指数规律是一样的
        //这种数组题目，就是要找到下标之间可循环的规律
        int cel = 0 ;
        int i=0 ;
        int j=0 ;
        int k=0 ;
        while (k<matrix.length*matrix[0].length){

            for (j=cel ; j<matrix[0].length-cel ; j++){
                System.out.print(matrix[i][j]+" ");
                list.add(matrix[i][j]);
                k++;
            }
            if (k==matrix.length*matrix[0].length){
                break;
            }
            j--;
            for (i=cel+1;i<matrix.length-cel;i++){
                System.out.print(matrix[i][j]+" ");
                list.add(matrix[i][j]);
                k++;
            }
            if (k==matrix.length*matrix[0].length){
//                list.add(matrix[i][j]);
                break;
            }
            i--;
            for (j=j-1;j>=cel;j--){
                System.out.print(matrix[i][j]+" ");
                list.add(matrix[i][j]);
                k++;
            }
            if (k==matrix.length*matrix[0].length){
                break;
            }
            j++;
            for (i=i-1;i>cel;i--){
                System.out.print(matrix[i][j]+" ");
                list.add(matrix[i][j]);
                k++;
            }
            if (k==matrix.length*matrix[0].length){
                break;
            }
            i++;
            cel++;
//            k++;
        }

        return list ;

    }



}
