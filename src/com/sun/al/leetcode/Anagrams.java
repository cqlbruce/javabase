package sun.al.leetcode;

import java.util.ArrayList;
import java.util.List;


public class Anagrams {





    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("tan") ;
        list.add("ant");
        list.add("abc");
        list.add("bac");
        list.add("a");
        List<List<String>> lists = new ArrayList<List<String>>();

        for(int i=0 ; i<list.size() ; i++){
            List<String> list2 = new ArrayList<String>();
            if ("--".equals(list.get(i))){
                continue;
            }
            for(int j=0 ; j<list.size() ; j++){
                if (i!=j&&list.get(j)!="--"&&list.get(i).length()==list.get(j).length()&&anagramsRet(list.get(i) , list.get(j))){
                    list2.add(list.get(j));
//                    list.remove(list.get(j));
                    list.set(j,"--");
                }
            }
            list2.add(list.get(i));
            lists.add(list2);
//            list.remove(list.get(i));
            list.set(i , "--") ;
        }

        for(List<String> list3 : lists){
            for(String str : list3){
                System.out.print(str + ",");
            }
            System.out.println();
        }

    }



    public static boolean  anagramsRet(String a , String b ){

        for(int i=0 ; i<a.length() ; i++){
            char c = a.charAt(i);
            int j = b.indexOf(c);
            if(j == -1){
                return false;
            }
            b = b.replace(c , '\0');
        }

        return true ;
    }



}
