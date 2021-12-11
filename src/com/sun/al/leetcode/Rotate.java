package sun.al.leetcode;

import java.util.List;

public class Rotate {


    public static void main(String[] args) {
        int[][] matrix = new int[1000][1000];
//        matrix[0] = new int[]{1 , 2 , 3} ;
//        matrix[1] = new int[]{4 , 5 , 6} ;
//        matrix[2] = new int[]{7 , 8 , 9} ;
        for(int k=0 ; k<1000 ; k++){
            for(int l=0 ; l <1000 ; l++){
                matrix[k][l] = 1000*k + l ;
            }
        }

        for(int i=0 ; i<matrix.length ; i++){
            for (int j=0 ; j<matrix[0].length ; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        rotate(matrix);
        System.out.println("------------------------------");
        for(int i=0 ; i<matrix.length ; i++){
            for (int j=0 ; j<matrix[0].length ; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }


    /**
     * 先找出旋转后 对应行列下标 行数变成列数，列数 为 n-j
     * 1、matrix[i][j] 旋转后下标为 matrix[j][matrix[0].length-1-i]
     * 2、二维数据需要标注已经替换过的格子，不然难以了解。
     * */
    public static void rotate(int[][] matrix){
        int[][] flagArr = new int[matrix.length][matrix[0].length];
        for(int i=0 ; i<matrix.length ; i++){
            for(int j=0 ; j<matrix[i].length;j++){
                if(flagArr[i][j]!=1){
                    int temp = matrix[i][j];
                    matrix[i][j]=matrix[j][matrix[0].length-1-i];
                    matrix[j][matrix[0].length-1-i]=temp;
                    flagArr[j][matrix[0].length-1-i] = 1;
                }
            }
        }
    }


}
