package sun.al.leetcode;

public class UniquePath {


    public static void main(String[] args) {

        System.out.println(uniquePaths1(2,3));

    }


    public static int uniquePaths1(int m , int n){

        int[][] ints = new int[m][n];

        for (int i=0 ; i<m ; i++){
            for (int j=0 ; j<n ; j++){
                if (i==0||j==0){
                    ints[i][j]=1;
                }else {
                    ints[i][j] = ints[i-1][j]+ints[i][j-1];
                }
            }
        }
        return ints[m-1][n-1] ;
    }


    //Time Limit Exceeded
    public static int uniquePaths(int m , int n){




        for (int i=1 ; i<=m ; i++){
            for (int j=1;j<=n;j++){



            }
        }
        if (m==1&&n==1){
            return 1;
        }

        if (n==0||m==0){
            return 0 ;
        }

        if (m==1&&n==2){
            return 1;
        }

        if (m==2&&n==1){
            return 1;
        }

        return uniquePaths(m-1 , n) + uniquePaths(m , n-1);


    }


}
