package sun.al.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class CombinationArrs {


    public static void main(String[] args) {

//        String[] strs = new String[]{"abc" , "efg" , "ijk" , "xyz"};
//
//        List<String> list = com(strs);
//
//        for (String str : list){
//            System.out.println(str);
//        }

        String[] strs = new String[]{"abc" , "efg" , "ijk" , "xyz"};
        List<List<String>> lists = new ArrayList<List<String>>();
        combileStr(strs , 2 , 0 , lists , new ArrayList<String>());

        for (int i = 0 ; i<lists.size();i++){
            List<String> list = lists.get(i);
            for (int j=0 ; j<list.size() ; j++){
                System.out.print(list.get(j)+",");
            }
            System.out.println();
        }



//        int[] ints = new int[]{1 , 3 , 5 , 7, 9 , 2 , 1};
//        List<List<Integer>> lists = new ArrayList<List<Integer>>();
//        combileInt(ints , 3 , 0 , lists , new ArrayList<Integer>());
//        for (int i = 0 ; i<lists.size();i++){
//            List<Integer> list = lists.get(i);
//            for (int j=0 ; j<list.size() ; j++){
//                System.out.print(list.get(j));
//            }
//            System.out.println();
//        }
    }

    public static void combileStr(String[] strs , int k , int start , List<List<String>> lists , List<String> tempList){

        if (tempList.size()==k){
            lists.add(new ArrayList<String>(tempList));
            return;
        }

        for (int i=start  ; i<strs.length ; i++){

            tempList.add(strs[i]);
            combileStr(strs , 2 , i+1 , lists , tempList);
            tempList.remove(tempList.size()-1);
        }

    }



    public static void combileInt(int[] nums , int k , int start , List<List<Integer>> lists , List<Integer> tempList ){

        if (tempList.size()==k){
            lists.add(new ArrayList<Integer>(tempList)) ;
            return;
        }

        for (int i=start ; i<nums.length ; i++){


            tempList.add(nums[i]);
            combileInt(nums , k , i+1 , lists , tempList);
            tempList.remove(tempList.size()-1);
        }


    }


//    public static List<String> com(String[] strs){
//
//
//
//        return null ;
//
//    }

}
