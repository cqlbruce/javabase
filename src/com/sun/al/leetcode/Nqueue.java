package sun.al.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Nqueue {

    static Scanner scanner = new Scanner(System.in);
    static int n ;
    static int[] rec ;
    static int ans = 0 ;

    static List<List<String>> resLists = new ArrayList<List<String>>();


    public static void main(String[] args) {
        solveNQeens(4);
    }

    public static List<List<String>> solveNQeens(int n){

        List<List<String>> lists = new ArrayList<List<String>>();
        for (int i=0 ;i<n;i++){
            List<String> list = new ArrayList<>();
            for (int j=0 ;j<n;j++){
                list.add(".");
            }
            lists.add(list);
        }
        nqeenSet(lists);
        for (int i=0 ;i<resLists.size();i++){
            for (int j=0 ;j<resLists.get(0).size();j++){
                System.out.println(resLists.get(i).get(j));
            }
            System.out.println("--");
        }
        System.out.println(resLists.size());
        return lists ;

    }


    public static boolean nqeenSet(List<List<String>> lists){

        for(int i=0 ; i<lists.size() ; i++){
//            System.out.println();
//            if (i>=2){
//                System.out.println(i);
//            }
            if (lists.get(i).contains("Q")){
                continue;
            }
            for (int j=0 ; j<lists.size() ; j++){
                if (noAttack(lists,i , j )){
                    lists.get(i).set(j,"Q");
                    if (nqeenSet(lists)){
//                        return true;
                        List<String> strs = new ArrayList<>();
                        for (List list:lists){
                            strs.add(String.join("",list));
                        }
                        if (!resLists.contains(strs)){
                            resLists.add(strs);
                        }
                        lists.get(i).set(j,".");

                    }else {
                        lists.get(i).set(j,".");
                    }
                }
            }
            if (!lists.get(i).contains("Q")){
                return false;
            }
        }
        return true;
    }

    //判断行列以及四个角
    public static boolean noAttack(List<List<String>> lists , int i , int j){

        List<String> rowList = lists.get(i);
        if (rowList.contains("Q")){
            return false;

        }

        for (List<String> list : lists){
            if (list.get(j).equals("Q")){
                return false;
            }
        }

        //正斜线
        int index = i+j;

        if (index>=lists.size()){
            for (int l=lists.size()-1;l>index-lists.size();l--){
                if (lists.get(index-l).get(l).equals("Q")){
                    return false;
                }
            }
        }else {
            for (int k=0 ; k<index ; k++){
                if (lists.get(k).get(index-k).equals("Q")){
                    return false;
                }
            }
        }



        //反斜线
        int i1 , j1 ;
        if (i>=j){
            i1=i-j;
            j1=0;
            while (i1<lists.size()){
                if (lists.get(i1).get(j1).equals("Q")){
                    return false;
                }
                i1++;
                j1++;
            }
        }else {
            j1=j-i;
            i1=0;
            while (j1<lists.size()){
                if (lists.get(i1).get(j1).equals("Q")){
                    return false;
                }
                i1++;
                j1++;
            }
        }





//
//        if (i-1>=0&&j-1>=0){
//            if (lists.get(i-1).get(j-1).equals("Q")){
//                return false;
//            }
//        }
//
//        if (i-1>=0&&j+1<lists.size()){
//            if (lists.get(i-1).get(j+1).equals("Q")){
//                return false;
//            }
//        }
//
//        if (i+1<lists.size()&&j-1>=0){
//            if (lists.get(i).get(j-1).equals("Q")){
//                return false;
//            }
//        }
//
//        if (i+1<lists.size()&&j+1<lists.size()){
//            if (lists.get(i+1).get(j+1).equals("Q")){
//                return false;
//            }
//        }

        return true;
    }



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


//    public static void main(String[] args) {
//
//        n = scanner.nextInt();
//        rec = new int[n];
//        Arrays.fill(rec , -1);
//        dfs(0);
//
//    }


}
