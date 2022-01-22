package sun.al.leetcode;

public class InsertIntervals {


    public static void main(String[] args) {


        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}} ;
        int[] ints1 = {7,8};

        int[][] intss = new int[intervals.length+1][2];
        for (int i=0 ; i<intervals.length ; i++){

            intss[i][0]=intervals[i][0];
            intss[i][1]=intervals[i][1];

        }

        intss[intervals.length]=ints1;


        //先排序
        int[][] sortInt = new int[intss.length][2];
        sortInt[0][0]=intss[0][0];
        sortInt[0][1]=intss[0][1];
        for (int i=1 ; i<intss.length;i++){
            int n = i;
            while (n>0){
                if (intss[i][0]<sortInt[n-1][0]){
                    sortInt[n][0]=sortInt[n-1][0];
                    sortInt[n][1]=sortInt[n-1][1];

                    sortInt[n-1][0]=intss[i][0];
                    sortInt[n-1][1]=intss[i][1];
                    n--;
                }else {
                    sortInt[n][0]=intss[i][0];
                    sortInt[n][1]=intss[i][1];
                    break;
                }
            }
        }

//        ArrsPrint.printArrs(sortInt);

        int[][] res = merge(sortInt);
        ArrsPrint.printArrs(res);

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
