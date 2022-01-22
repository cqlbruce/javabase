package sun.al.leetcode;

public class ArrsPrint {




    public static void printArrs(int[][] arrs){


        for (int i=0 ; i<arrs.length ; i++){
            for (int j=0 ; j<arrs[0].length ;j++){
                System.out.print(arrs[i][j]+" ");
            }
            System.out.println();
        }


    }


}
