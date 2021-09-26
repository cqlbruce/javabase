package sun.al.name;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoWord {


    public static void main(String[] args) {

        try{

            BufferedReader bReader = new BufferedReader(new FileReader("/data/doc/name/new.txt"));
            String s = bReader.readLine();
            List<String> list = new ArrayList<String>();
            while (null != s){
                String[] ss = s.split(",");
                List<String> sList = Arrays.asList(ss) ;
                list.addAll(sList);
                s = bReader.readLine();
            }

            bReader.close();

            List<String> list2 = new ArrayList<String>();
            list2.addAll(list);
            List<String> twoWords = new ArrayList<String>();


            File file =new File("/data/doc/name/twoWords.txt");
            if (file.exists()) file.delete();
            file.createNewFile();

            FileOutputStream fos = new FileOutputStream("/data/doc/name/twoWords.txt") ;


            for (int i = 0 ; i <list.size() ; i++){
                for (int j=0 ; j<list.size() ; j++){
                    String str  = list.get(i)+list.get(j)+"," ;
                    twoWords.add(str);
                    fos.write(str.getBytes());
                }
            }

            fos.close();
//            for (String str : twoWords){
////                System.out.print(str);
////            }
            System.out.println("----------");

            System.out.println(twoWords.size());
            System.out.println(twoWords.size());



//            for (String str : list){
//                System.out.print(str);
//            }
//            System.out.println(list.size());
//            System.out.println(list.size());
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
