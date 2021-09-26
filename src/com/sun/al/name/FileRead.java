package sun.al.name;

import java.io.*;

public class FileRead {

    public static void main(String[] args) {

        try{

            FileInputStream fis = new FileInputStream("/data/doc/name/aa.txt");

            File file = new File("/data/doc/name/new.txt");
            if (file.exists()){
                file.delete();
            }
            file.createNewFile();

            BufferedInputStream bis = new BufferedInputStream(fis);

            BufferedReader bReader = new BufferedReader(new FileReader("/data/doc/name/aa.txt"));
            FileOutputStream fos = new FileOutputStream("/data/doc/name/new.txt") ;
            String s = bReader.readLine();
            int i = 0 ;
            while (null != s ){
                s = s + "," ;
                fos.write(s.getBytes());
                s = bReader.readLine();
                i+=1;
                System.out.println(i);
            }
            bReader.close();
            fos.close();
        }catch (Exception e ){
            e.printStackTrace();
        }finally {
        }


    }


}
