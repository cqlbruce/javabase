package sun.al.leetcode;

import java.util.*;

public class AnagramsTwo {


    public static void main(String[] args) {

       String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
//        String[] strs = new String[]{"hhhhu","tttti","tttit","hhhuh","hhuhh","tittt"};

        getAnagrams(strs);

    }

    public static List<List<String>> getAnagrams0(String[] strs){

        List<List<String>> lists = new ArrayList<List<String>>();
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        String str = null ;
        char[] cs = null ;
        String strSort = null ;
        for(int i=0 ; i<strs.length ; i++){
            str = strs[i];
            cs = str.toCharArray();
            Arrays.sort(cs);
            strSort = new String(cs);
            if(map.get(strSort)!=null){
                map.get(strSort).add(str);
            }else {
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(strSort,list) ;
            }
        }
        for (List<String> list : map.values()){
            lists.add(list);
        }
        return lists ;
    }


    public static List<List<String>> getAnagrams(String[] strs){

        List<String> orgList = new ArrayList<String>();
        Collections.addAll(orgList , strs);
        List<List<String>> lists = new ArrayList<List<String>>();

        while (!orgList.isEmpty()){
            List<String> list = new ArrayList<>();
            List<String> listNew = new ArrayList<String>();
            String str = orgList.remove(0);
            listNew.addAll(orgList);
            list.add(str);
            if (orgList.size()>0){
                for (int i=0 ; i<orgList.size() ; i++){
                    if(checkSame(str,orgList.get(i))){
                        list.add(orgList.get(i));
                        listNew.remove(orgList.get(i));
                    }
                }
                orgList.clear();
                orgList.addAll(listNew);
            }
            lists.add(list);

        }
        return lists ;
    }

    public static boolean checkSame(String str1 , String str2){
        if (str1.length()!=str2.length()){
            return false;
        }
        for (int i=0 ; i<str1.length() ; i++){
            int j = str2.indexOf(str1.charAt(i)) ;
            if (-1==j){
                return false;
            }
            str2 = str2.substring(0,j ) + str2.substring(j+1 , str2.length());
        }
        if (str2.length()>0){
            return false;
        }
        return true;
    }
}
