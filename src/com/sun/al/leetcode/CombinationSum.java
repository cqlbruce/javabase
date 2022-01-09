package sun.al.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSum {

    static Map<String , String > map = new HashMap<String , String>();

    public static void main(String[] args) {

        int[] candidates = new int[]{1 , 3 , 6 , 8 , 9};
        int target = 16 ;

        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0 ; i<candidates.length ; i++){

            int k = target/candidates[i] ;
            if (k>1){
                for (int l=0 ; l<k ; l++){
                    list.add(candidates[i]);
                }
            }else {
                list.add(candidates[i]);
            }
        }
        Collections.sort(list) ;
        combinationSum2(list , target  , 0 , 0 ,lists , new ArrayList<Integer>());

        for (int i = 0 ; i<lists.size();i++){
            List<Integer> list1 = lists.get(i);
            for (int j=0 ; j<list1.size() ; j++){
                System.out.print(list1.get(j)+",");
            }
            System.out.println();
        }
    }



    //np 问题 递归会导致执行时间爆炸性增长，比如 candidates 数组的
    public static void combinationSum2(List<Integer> list , int target , int sum , int start , List<List<Integer>> lists , List<Integer> tempList){
        if (sum>target){
            return ;
        }else if(sum==target){
            List<Integer> list1 = new ArrayList<Integer>(tempList);
            Collections.sort(list1);
            String str = list1.stream().map(String::valueOf).collect(Collectors.joining(""));
            if (!map.containsKey(str)){
                map.put(str,str);
                lists.add(new ArrayList<Integer>(tempList));
            }
            return;
        }

        for (int i = start ; i<list.size() ; i++){

            tempList.add(list.get(i));
            sum = sum + list.get(i);
            combinationSum2(list , target , sum , i+1 , lists , tempList);
            sum = sum - list.get(i);
            tempList.remove(tempList.size()-1);
            //不符合去除最后一个元素，向后遍历
            while(i < list.size() -1 && list.get(i) == list.get(i+1))//去重
            {
                i++;
            }
        }
    }



    public static void combinationSum(List<Integer> list ,int target , int start ,  List<List<Integer>> lists , List<Integer> tempList){

        if (target==0){
            lists.add(new ArrayList<Integer>(tempList));
            return;
        }else if(target<0){
            return;
        }

        for (int i=0 ; i<list.size() ; i++){

            tempList.add(list.get(i));
            target = target - list.get(i);
            combinationSum(list , target , i+1 , lists , tempList);
            tempList.remove(tempList.size()-1);
            target = target + list.get(i);
            while (i<list.size()-1&&list.get(i)==list.get(i+1)){
                i++ ;
            }

        }
    }

}
