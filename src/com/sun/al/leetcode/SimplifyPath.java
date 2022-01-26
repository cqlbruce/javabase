package sun.al.leetcode;

public class SimplifyPath {


    public static void main(String[] args) {

        //Input: path = "/home/"
        //"/a/./b/../../c/"
        // "/home//foo/"
        ///a/../../b/../c//.//
        // "/a//b////c/d//././/.."
//        String str = "/a//b////c/d//././/..";
        //"/home/of/foo/../../bar/../../is/./here/."

//        String str = "/.";
//        String str = "/a/./b/../../c/";
        String str = "/home/of/foo/../../bar/../../is/./here/.";

        System.out.println(simplifyPath1(str));
//
//        System.out.println("/c/a/../b/".indexOf("/../")+3);
//        int index1 = "/c/a/../b/".indexOf("/../")+3;
//        int index2 = "/c/a/../b/".lastIndexOf("/",3);
//        System.out.println("/c/a/../b/".lastIndexOf("/",3));
//        System.out.println("/c/a/../b/".replace("/.*?/../","/"));
//
//        System.out.println("/c/a/../b/".matches("/??/"));
//
//        System.out.println("/c/a/../b/".substring(index2 , index1));


    }


    public static String simplifyPath1(String path){


        String str = path ;

        while (true){


            if (str.contains("/./")){
                str = str.replaceAll("/\\./","/");
                continue;
            }


            if (str.contains("//")){
                str = str.replaceAll("//" , "/");
                continue;
            }

            if (str.startsWith("/../")){
                str = str.replaceFirst("/../" , "/");
                continue;
            }

            if (str.contains("/../")){
                int index2 = str.indexOf("/../");
                int index1 = str.lastIndexOf("/",index2-1);
                index2 = index2+4;
                String temp = str.substring(index1,index2);
                str = str.replace(temp,"/");
                continue;
            }
            if (str.endsWith("/..")){
//                str = str.replace("/..","");
                int index2 = str.indexOf("/..");
                if (index2==0){
                    return "/";
                }
                int index1 = str.lastIndexOf("/",index2-1);
                index2 = index2+3;
                str = str.substring(0,index1+1);
//                str = str.replace(temp,"");

                continue;
            }

            break;
        }

        if (str.endsWith("/.")){
            str = str.replace("/.","/");
        }

        if(str.length()==1){
            return str;
        }else if (str.endsWith("/")){
            return str.substring(0,str.length()-1) ;
        }else {
            return str ;
        }

    }




    public static String simplifyPath(String path){

//        String str = path.replace("/../" , "/");
        if (path.startsWith("/../")){
            return "/";
        }
        String str = path.replaceAll("/\\./","/");

        str = str.replaceAll("//","/");

        while (str.contains("/../")){

            if (str.startsWith("/../")){
                str = str.replaceFirst("/../" , "/");
                continue;
            }
            int index2 = str.indexOf("/../");
            int index1 = str.lastIndexOf("/",index2-1);
            index2 = index2+4;
            String temp = str.substring(index1,index2);
            str = str.replace(temp,"/");

        }
        if(str.length()==1){
            return str;
        }else{
            return str.substring(0,str.length()-1) ;
        }

    }

}
