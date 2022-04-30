package sun.al.leetcode;

public class NumMatrix {

    int[][] preMatrix ;


    public NumMatrix(int[][] matrix){
        preMatrix = matrix;
        for (int i=0 ; i<matrix.length ; i++){
            for (int j=1 ; j<matrix[0].length ; j++){
                preMatrix[i][j]=preMatrix[i][j-1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1 , int col1 , int row2 , int col2){

        int sum = 0 ;
        for (int i=row1 ; i<=row2 ; i++){

            if (col1==0){
                sum = sum + preMatrix[i][col2];
            }else{
                sum = sum + (preMatrix[i][col2]-preMatrix[i][col1-1]);
            }

        }
        return sum;

    }



}
