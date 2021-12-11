package sun.al.leetcode;

import java.util.*;

public class Permutations {
    public static List<List<Integer>> ret = new ArrayList<List<Integer>>();


    public static void main(String[] args) {
        int[] nums = new int[]{3 , 3 , 0 , 3};
//        permutate1(nums);
        permutateDfs(nums , 0);
        for (List<Integer> list:ret) {
            for (Integer i : list){
                System.out.print(i);
            }
            System.out.println();
        }
    }


    public static void permutateDfs(int[] nums , int dep ){
        if (dep == nums.length){
            List<Integer> list = new ArrayList<Integer>();
            for (int i=0 ; i<nums.length ; i++){
                list.add(nums[i]);
            }
            ret.add(list);
        }
        Map<String,List<Integer>> map = new HashMap();
        for (int i=dep ; i<nums.length ; i++){
            if (map.get(String.valueOf(dep))!=null && map.get(String.valueOf(dep)).contains(nums[i])){
                continue;
            }else {
                if(map.containsKey(String.valueOf(dep))){
                    List<Integer> list = map.get(String.valueOf(dep)) ;
                    list.add(nums[i]);
                }else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    map.put(String.valueOf(dep) , list);
                }
            }
//            if (dep!=i&&nums[dep]==nums[i]){
//                continue;
//            }
            swap(nums , dep , i);
            permutateDfs(nums,dep+1 );
            swap(nums,dep , i);
        }
    }

    public static void swap(int[] nums , int a , int b){
        int temp = nums[b] ;
        nums[b] = nums[a] ;
        nums[a] = temp;
    }



    public static List<List<Integer>> permutate1(int[] nums){
        List<Integer> ans = new ArrayList<Integer>() ;
        if (nums.length == 0) return ret ;
        ans.add(nums[0]);
        insertNum(nums , 1 , ans);
        return ret;
    }

    public static void insertNum(int[] nums , int index , List<Integer> ans){
        if (index == nums.length){
            List<Integer> new_ans = new ArrayList<Integer>(ans);
            ret.add(new_ans);
            return;
        }
        ans.add(nums[index]);
        insertNum(nums , index + 1 , ans);
        ans.remove(ans.size() - 1);
        for (int j=0 ; j<ans.size() ; j++){
            ans.add(j , nums[index]);
            insertNum(nums , index + 1 , ans);
            ans.remove(j);
        }
    }






    //全排列
    public static List<List<Integer>> permutate0(int[] ints){

        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if (ints.length<1){
            return null;
        }
        if (ints.length<=1){
            list.add(ints[0]);
            lists.add(list);
            return lists;
        }
        int[] intss = new int[ints.length-1];
        System.arraycopy(ints , 1,intss ,0 ,ints.length-1 );
        List<List<Integer>> listss = permutate0(intss);
        for (int i=0 ; i<listss.size() ; i++){
            List<Integer> list1 = new ArrayList<Integer>();
            List<Integer> list2 = new ArrayList<Integer>();
            list1.addAll(listss.get(i));
            list2.addAll(listss.get(i));
            list1.add(0 , ints[0]);
            lists.add(list1);
            list2.add(list2.size(),ints[0]);
            lists.add(list2);
        }
        return lists;

    }


}
