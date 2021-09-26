package sun.al.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationSum {


    public static void main(String[] args) {



    }

    public List<List<Integer>> combinationSum(int[] candidates,int target){

        List<List<Integer>> lists = new ArrayList<List<Integer>>() ;
        if (candidates==null || candidates.length>0){
            return lists;
        }

        Map<Integer,Integer> map = new HashMap<Integer, Integer>();

        for (int i=0 ; i<candidates.length ; i++){

            if (map.containsKey(target-candidates[i])){



            }


        }





        return null ;

    }

}
