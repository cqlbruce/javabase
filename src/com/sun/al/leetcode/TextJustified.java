package sun.al.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustified {


    public static void main(String[] args) {


//        Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
//        String[] strs = {"This", "is", "an", "example", "of", "text", "justification."};
//        ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"]


        String[] strs = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};

        List<String> lists = fullJustify(strs , 20);
        for (String str : lists){
            System.out.println("\""+str+"\",");
        }

    }


    public static List<String> fullJustify(String[] words , int maxWidth){

        List<String> resList = new ArrayList<String>();
        
        int length = 0 ;
        List<String> lists = new ArrayList<String>();

        int tempLength = 0 ;

        for (int i=0 ; i<words.length ; i++){

            tempLength = length + words[i].length();

            if (tempLength+lists.size()>maxWidth) {

                if (lists.size()==1){
                    lists.add(words[i]);
                    length=tempLength;
                    int size = maxWidth - lists.get(0).length();
                    String endEmptyStr = new String(new char[size]).replace("\0", " ");
                    String str = lists.get(0) + endEmptyStr ;
                    resList.add(str);
                }else {

                    int tapAll = maxWidth - length;
                    String str = null ;
                    int tap = tapAll/(lists.size()-1);
                    int tap1=tapAll%(lists.size()-1);

//                    if (tap>0){
                    String emptyStr = new String(new char[tap]).replace("\0", " ");
//                    String endEmptyStr = new String(new char[tap1]).replace("\0", " ");

                    str = String.join(emptyStr,lists);
                    for (int j=0;j<tap1;j++){
                        str = str.replaceFirst(emptyStr,emptyStr+" ");
//                        str.rep
                    }

//                    }
//                    if (tap1>0){
//                        str = str + endEmptyStr ;
//                    }
                    resList.add(str);
                    length = words[i].length() ;
                }
//                i--;
                lists.clear();
                lists.add(words[i]);
                length=words[i].length();
                continue;

            }else {
                lists.add(words[i]);
                length=tempLength;
            }

        }

        if (lists.size()>0){

            String str = String.join(" ",lists);
            int size = maxWidth - str.length();
            String endEmptyStr = new String(new char[size]).replace("\0", " ");
            str = str + endEmptyStr ;
            resList.add(str);
        }

        return resList ;

    }



}
