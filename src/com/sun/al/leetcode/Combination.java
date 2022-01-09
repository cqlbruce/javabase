package sun.al.leetcode;

import com.sun.deploy.util.StringUtils;

import java.util.*;

public class Combination {

    public static List<List<Integer>> lists = new ArrayList<List<Integer>>();
    public static Map<String,String> map = new HashMap<String ,String>();

    public static void main(String[] args) {

//        int[] nums = new int[]{1 , 3 , 6 ,8};
//        int[] nums = new int[]{1 , 3 , 6 , 8 , 9 , 2};

//        combination(nums , 3 ,new ArrayList<Integer>()) ;
//
//        for (int i = 0 ; i<lists.size();i++){
//            List<Integer> list = lists.get(i);
//            for (int j=0 ; j<list.size() ; j++){
//                System.out.print(list.get(j));
//            }
//            System.out.println();
//        }

        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        combine(100 , 3 , 1 , lists , new ArrayList<Integer>());

        for (int i = 0 ; i<lists.size();i++){
            List<Integer> list = lists.get(i);
            for (int j=0 ; j<list.size() ; j++){
                System.out.print(list.get(j)+ ",") ;
            }
            System.out.println();
        }
    }



    public static void combine(int n , int k  , int start , List<List<Integer>> lists , List<Integer> tempList){


        if (tempList.size()==k){
            lists.add(new ArrayList<Integer>(tempList));
            return ;
        }

        for (int i=start ; i<=n ; i++){
            tempList.add(i);
            combine(n , k , i+1 , lists , tempList);
            tempList.remove(tempList.size()-1);
        }

    }


    public static void combination(int[] nums , int n  , List<Integer> list){

        if (list.size() == n){
//            Collections.sort(list);
//            String s = StringUtils.join(list,"");
//            if (!map.containsKey(s)){
//                lists.add(list);
//            }
            lists.add(list);
            return;
        }

        for (int i=0 ; i<nums.length ; i++){
            if (list.contains(nums[i])){
                continue;
            }
            List<Integer> list1 = new ArrayList<>();
            list1.addAll(list);
            list1.add(nums[i]);
            combination(nums , n ,  list1);
        }

    }

}
