package sun.al.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSumII {


    static Map<String , String > map = new HashMap<String , String>();
    public static void main(String[] args) {

//        [2,5,2,1,2]
//        5

//        [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
//        30

        int[] cans = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(cans);
        combinationSum2(cans , 30 , 0 , 0 , lists , new ArrayList<Integer>());
        for (int i = 0 ; i<lists.size();i++){
            List<Integer> list = lists.get(i);
            for (int j=0 ; j<list.size() ; j++){
                System.out.print(list.get(j));
            }
            System.out.println();
        }
    }



    //np 问题 递归会导致执行时间爆炸性增长，比如 candidates 数组的
    public static void combinationSum2(int[] candidates , int target , int sum , int start , List<List<Integer>> lists , List<Integer> tempList){
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

        for (int i = start ; i<candidates.length ; i++){

            tempList.add(candidates[i]);
            sum = sum + candidates[i];
            combinationSum2(candidates , target , sum , i+1 , lists , tempList);
            sum = sum - candidates[i];
            tempList.remove(tempList.size()-1);
            //不符合去除最后一个元素，向后遍历
            while(i < candidates.length -1 && candidates[i] == candidates[i+1])//去重
            {
                i++;
            }
        }
    }


}
