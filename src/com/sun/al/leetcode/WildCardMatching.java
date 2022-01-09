package sun.al.leetcode;

public class WildCardMatching {


    public static void main(String[] args) {
//        String str = "ab";
//        String p = "*?*?*";

        String str = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb" ;
        String p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb" ;
//        String p = "*?*?*";
//        "leetcode"
//        "*e*t?d*"
//        String str = "leetcode";
//        String p = "*e*t?d*";
//        "aaba"
//        "?***"
//        "acdcb"
//        "a*c?b"
//        "abcde"
//        "abc*?"

//        String str = "abcde";
//        String p = "abc*?";
//        String str = "aaba";
//        String p = "?***";
//        "mississippi"
//        "m??*ss*?i*pi"
//        "abcabczzzde"
//        "*abc???de*"
//        String str = "abcabczzzde";
//        String p = "*abc???de*";
        System.out.println(isMatch(str , p)) ;
//        for (int i=0 ; i<str.length() ; i++){
//            System.out.println(str.indexOf('s'));
//            System.out.println(str.indexOf('s'));
//            System.out.println(str.indexOf('s'));
//        }

    }

    public static boolean isMatch(String s , String p ){

        if (s.length()==0&&p.length()==0){
            return true;
        }else if (p.equals("*")||(p.contains("*")&&"".equals(p.replace("*" , "")))){
            return true;
        }else if (p.length()==0||s.length()==0){
            return false;
        }else if (!p.contains("*")&&s.length()!=p.length()){
            return false ;
        }else if(p.equals("*?")){
            return true ;
        }
        int l = 0 ;
        for (int i=0 ; i<s.length() ; i++){
            char cs = s.charAt(i);
            char cp = p.charAt(i);
            if (cp=='*'){
                int j = i ;
                if(p.substring(j,p.length()).replace("*" , "").length()==0){
                    return true ;
                }
                while (j<p.length()){


                    j++;
                    if(i==p.length()-1){
                        return true ;
                    }
                    if (p.charAt(j)!='*') {
                        int k = s.indexOf(p.charAt(j) , i);
                        if (p.charAt(j)=='?'){
                            k=i+1;
                        }
                        if (k==-1||k>=s.length()&&p.substring(j+1 , p.length()).replace("*" , "").length()!=0){
                            return false ;
                        }else if (k>=s.length()&&p.substring(j+1 , p.length()).replace("*" , "").length()==0){
                            return true;
                        }
                        if (p.charAt(j)!='?'){
                            k = k+1;
                        }
                        while (true){
                            boolean b = isMatch(s.substring(k , s.length()),p.substring(j+1 , p.length()));
                            if (b){
                                return true;
                            }
                            int t = s.indexOf(p.charAt(j) , k);
//                            k = s.indexOf(p.charAt(j) , k);
                            if (t==-1){
                                if (p.charAt(j)=='?'){
                                    k = k+1;
                                }else {
                                    k=t;
                                }
                                if (k==-1||k>=s.length()&&p.substring(j+1 , p.length()).replace("*" , "").length()!=0){
                                    return false ;
                                }else if (k>=s.length()&&p.substring(j+1 , p.length()).replace("*" , "").length()==0){
                                    return true;
                                }
                            }else {
                                k = t+1;
                            }
                            System.out.println("j==" + j);
                        }
                    }
                }
                break;
            }
            l=i ;
            if (i==s.length()-1&&i+1<=p.length()-1&&p.charAt(i+1)!='*'){
                return false;
            }
            if (cp=='?'){
                continue;
            }
            if (cp!=cs){
                return false;
            }
            if (s.length()-1>i&&i>=p.length()-1){
                return false ;
            }
        }

        if (p.length()-1>l&&p.substring(l+1,p.length()).replace("*" , "").length()!=0){
            return false;
        }else {
            return true;
        }


    }


}
