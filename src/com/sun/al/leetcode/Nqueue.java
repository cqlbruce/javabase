package sun.al.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class Nqueue {

    static Scanner scanner = new Scanner(System.in);
    static int n ;
    static int[] rec ;
    static int ans = 0 ;


    public static boolean cheak(int col , int row){
        for (int i=0 ; i<row ; i++){
            if (rec[i] == col || (i + rec[i] == row + col ) || (rec[i] - i == col - row)){
                return false ;
            }
        }
        return  true ;
    }

    public static void outPut(){
        for (int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                if(j == rec[i]){
                    System.out.print("Q");
                }else{
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    static void dfs(int row){

        if (row == n){
            outPut();
            System.out.println();
            return;
        }

        for(int col = 0 ; col<n ; col++){
            if (cheak(col , row)){
                rec[row] = col ;
                dfs(row + 1 );
                rec[row] = -1 ;
            }
        }
    }


    public static void main(String[] args) {

        n = scanner.nextInt();
        rec = new int[n];
        Arrays.fill(rec , -1);
        dfs(0);

    }


}
