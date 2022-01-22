package sun.al.leetcode;

import java.util.Arrays;

public class MergeIntervals {


    public static void main(String[] args) {

//        Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//        Input: intervals = [[1,4],[4,5]]
//[[2,3],[4,5],[6,7],[8,9],[1,10]]


        int[][] ints = {{1,3},{2,6},{8,10},{15,18}} ;
//        int[][] ints = {{1,4},{4,5}} ;
//        int[][] ints = {{1,4},{0,0}} ;

//        int[][] ints = {{2,3},{4,5},{6,7},{8,9},{1,10}} ;

        //先排序
        int[][] sortInt = new int[ints.length][2];
        sortInt[0][0]=ints[0][0];
        sortInt[0][1]=ints[0][1];
        for (int i=1 ; i<ints.length;i++){
            int n = i;
            while (n>0){
                if (ints[i][0]<sortInt[n-1][0]){
                    sortInt[n][0]=sortInt[n-1][0];
                    sortInt[n][1]=sortInt[n-1][1];

                    sortInt[n-1][0]=ints[i][0];
                    sortInt[n-1][1]=ints[i][1];
                    n--;
                }else {
                    sortInt[n][0]=ints[i][0];
                    sortInt[n][1]=ints[i][1];
                    break;
                }
            }
        }

//        ArrsPrint.printArrs(sortInt);


        int[][] res = merge(sortInt);
        ArrsPrint.printArrs(res);

    }



    public static int[][] merge1(int[][] ints){




        return null ;

    }


    public static int[][] merge(int[][] intervals){

        int[][] res = new int[intervals.length][2];

        int k=0;
        int index = 0 ;


        for (int i=0 ; i<intervals.length ; i++){
            res[k][0] = intervals[i][0];
            res[k][1] = intervals[i][1];
            while (i<intervals.length-1){
//                int[] ints1 = intervals[i];
                int[] ints2 = intervals[i+1];
                res[k][0] = Math.min(res[k][0],ints2[0]);
                if (res[k][1]>=ints2[0]){
                    res[k][1]= Math.max(intervals[i+1][1],res[k][1]);
                    i++;
                    index++ ;
                }else {
                    break;
                }
            }
            k++;
        }

        int[][] res0 = null ;
        if (index>0){
            res0=new int[res.length-index][2];
            for (int i=0;i<res0.length;i++){
                res0[i][0]=res[i][0];
                res0[i][1]=res[i][1];

            }

        }else {
            res0=res;
        }

        return res0 ;
    }



}
