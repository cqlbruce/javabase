package sun.al.leetcode;

public class MinPathSum {

    public static void main(String[] args) {

        //Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
        int[][] ints= {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(ints));


    }


    public static int minPathSum(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int[][] arrs = new int[m][n];
        for (int i=0 ; i<m ; i++){
            for (int j=0 ; j<n ; j++ ){
                if (i==0&&j==0){
                    arrs[i][j] = grid[i][j];
                }else if (i==0){
                    arrs[i][j] = arrs[i][j-1]+grid[i][j];
                }else if (j==0){
                    arrs[i][j] = arrs[i-1][j]+grid[i][j];
                }else {
                    arrs[i][j] = Math.min(arrs[i-1][j],arrs[i][j-1]) + grid[i][j];
                }
            }
        }
        return arrs[m-1][n-1] ;
    }


}
