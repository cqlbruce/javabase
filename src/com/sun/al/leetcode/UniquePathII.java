package sun.al.leetcode;

public class UniquePathII {


    public static void main(String[] args) {

        //[[0,0,0],[0,1,0],[0,0,0]]

        int[][] ints= {{0,0,0},{0,1,0},{0,0,0}};
//        int[][] ints= {{0}};
        System.out.println(uniquePathsWithObstacles(ints));


    }


    public static int uniquePathsWithObstacles(int[][] obstacleGrid){

        int m = obstacleGrid.length ;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1){
            return 0 ;
        }

        int[][] ints = new int[m][n];

        for (int i=0 ; i<m ; i++){
            for (int j=0 ; j<n ; j++){

                if (obstacleGrid[i][j]==1){
                    ints[i][j]=0;
                    continue;
                }

                if (i==0&&j==0){
                    ints[0][0]=1;
                    continue;
                }

                if (i==0){
                    ints[i][j] = ints[i][j-1];
                }else if (j==0){
                    ints[i][j] = ints[i-1][j];
                }else {
                    ints[i][j] = ints[i-1][j]+ints[i][j-1];
                }

            }
        }
        return ints[m-1][n-1] ;

    }



}
