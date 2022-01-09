package sun.al.leetcode;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubstringWithCon {


    public static void main(String[] args) {

//        String s = "abcbarfoo";
//        String[] words = new String[]{"abc" , "bar" , "foo"};
//        "barfoofoobarthefoobarman"
//                ["bar","foo","the"]


//        String s = "barfoofoobarthefoobarman" ;
//        String[] words = new String[]{"bar","foo","the"};

//        String s = "barfoothefoobarman" ;
//        String[] words = new String[]{"foo","bar"};


        String s = "foobarfoobar" ;
        String[] words = new String[]{"foo","bar"};

        List<Integer> list = findSubString01(s , words);


        for(int i:list){
            System.out.print(i+",");
        }
//        String s = "aaa" ;
//        String[] words = new String[]{"a","a"};
//        String[] words = new String[]{"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};
//
//        List<String> resList = new ArrayList<>();
//        findSubtring(words , words.length ,0 , resList );
//        for (String str : resList){
//            System.out.println(str);
//        }
//


//        List<Integer> listInt = new ArrayList<Integer>();
//        for (String str : resList){
//            int i=0 ;
//            while (i<s.length()){
//                i = s.indexOf(str , i);
//                if (i==-1)
//                    break;
//                listInt.add(i);
//                i = i+1;
//            }
//
//        }
//        Collections.sort(listInt);
//
//        for (int i : listInt){
//            System.out.print(i + ",");
//        }


    }



    public static List<Integer> findSubString01(String s , String[] words){

        List<Integer> resList = new ArrayList<Integer>();
        String indexWord = words[0] ;
        if(s.replaceAll(indexWord,"").isEmpty()&&s.length()==words.length){
            resList.add(0);
            return resList;
        }

        int index = s.indexOf(indexWord , 0) ;
        int strLength = indexWord.length();
//        int small = 0 ;

        while (index!=-1){

            List<String> list = Arrays.asList(words);
            List<String> tempList = new ArrayList<String>(list);

            tempList.remove(indexWord);
//            small=index;

            List<Integer> tempRestList = new ArrayList<Integer>();
            tempRestList.add(index);

            //先往左滑动
            int leftIndex = index - strLength;
            int l = 0 ;
            if (!resList.isEmpty()){
                l = resList.get(resList.size()-1)+strLength;
            }
            while (leftIndex>=l){
                String str = s.substring(leftIndex , leftIndex+strLength);
                if (tempList.contains(str)){
                    tempList.remove(str);
                    tempRestList.add(leftIndex);
                    leftIndex = leftIndex - strLength ;
                }else {
                    break;
                }
            }

            //后往右滑动
            int rightIndex = index+2*strLength ;
            while (rightIndex<=s.length()){
                String str = s.substring(rightIndex-strLength , rightIndex);
                if (tempList.contains(str)){
                    tempList.remove(str);
                    rightIndex = rightIndex + strLength ;
                }else {
                    break;
                }
            }


            //满足则list add small 不满足 则往下一个位置。
            if (tempList.size()==0){
                Collections.sort(tempRestList);
                resList.add(tempRestList.get(0));
                index = tempRestList.get(0) ;
//                small = small+strLength;
//                indexWord = s.substring(index+strLength , index+2*strLength);
            }
            index = s.indexOf(indexWord , index + strLength) ;

        }

        return resList ;

    }






    public static void findSubtring(String[] words, int count , int start , List<String> resList){

        if (start==count){
//            resList.add(Arrays.toString(words).replaceAll(", ",""));
            String str = String.join("",words);
            if (!resList.contains(str)){
                resList.add(String.join("",words));
            }
            return;
        }

        for (int i = start ; i<words.length ; i++){
            change(words , start , i);
            findSubtring(words, count ,start+1 , resList);
            change(words , start , i);
        }

    }

    public static void change(String[] words , int i , int j){
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }

}
