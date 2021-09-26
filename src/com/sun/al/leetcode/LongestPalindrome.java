package sun.al.leetcode;


/*
*
* Longest Palindromic Substring
*
* Given a string s, find the longest palindromic substring in s.
* You may assume that the maximum length of s is 1000.
*
* Example 1:
    Input: "babad"
    Output: "bab"
    Note: "aba" is also a valid answer
*
* Example 2:
    Input: "cbbd"
    Output: "bb"
* */
public class LongestPalindrome {

    //回文：关于中间字符对称的文法，即“aba”(单核)、“cabbac”(双核)等
    //最长回文子串：1.寻找回文子串；2.该子串是回文子串中长度最长的。

    public static void main(String[] args) {

        String str = "abacc";
        String str1 = "acaacc";
        String str2 = "bb";
        String str3 = "ccc";
        String str4 = "babad";


//        System.out.println(longestPalindromeThree(str));
//        System.out.println(longestPalindromeThree(str1));
//        System.out.println(longestPalindromeThree(str2));
//        System.out.println(longestPalindromeThree(str3));
        System.out.println(longestPalindromeThree(str4));


    }

    /*
    *
    * s1: 暴力破解
    * 时间效率 o(n*n)
    *
    * */
    public static String longestPalindromeOne(String s ){
        if (null==s||"".equals(s))
            return "";
        if (s.length()==1)
            return s;
        String maxStr = "";
        String tempStr = "";
        boolean flag = false;
        for (int i = 1 ; i<s.length() ; i++){
            char c1 = s.charAt(i);
            char c2 = s.charAt(i-1);
            if (c1 == c2) {//双核
                tempStr = doubleCore(s,i);
                if (tempStr.length()>=maxStr.length())
                    maxStr = tempStr ;
            }
            //单核
            tempStr = singleCore(s,i);
            if (tempStr.length()>=maxStr.length())
                maxStr = tempStr ;
        }
        if(maxStr.length()==0){
            return s.substring(0,1);
        }
        return maxStr ;
    }


    /*
    * 回文子串判断: 垃圾
    * 建模思路很重要:我的第一次建是基于单核与双核，所以单核使用第一，双核使用第二种
    * */
    public static String singleCore(String s , int i){
        String maxStr="";
        for (int j = 1 ; j <= i ; j ++) {
            if (i-j<0||i+j>=s.length())
                break;
            //单核
            if (s.charAt(i-j) == s.charAt(i+j)){
                String str = s.substring(i-j , i+j+1);
                if (str.length()>maxStr.length())
                    maxStr = str ;
            }else {
                break;
            }
        }
        return maxStr ;
    }

    /*
    * 回文子串判断: 垃圾
    * */
    public static String doubleCore(String s , int i){
        String maxStr=s.substring(i - 1, i + 1);
        for (int j = 1 ; j <= i ; j ++) {
            if (i-j<0||i+j>=s.length())
                break;
            if (i-j-1<0)
                break;
            if (s.charAt(i-j-1) == s.charAt(i+j)){
                String str = s.substring(i-j-1 , i+j+1);
                if (str.length()>maxStr.length())
                    maxStr = str ;
            }else {
                break;
            }
        }
        return maxStr;
    }


    /*
    *
    * 思路：从每个点开始做奇，偶扩展，当扩展的长度最大时，记录left，right的index值，我的写法不是最优，因为我每次扩展返回的是string，然而实际上返回index即可。
    *
    * */
    public static String longestPalindromeTwo(String s){
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }




    // s3: 时间效率 o(n*n)
    //思路很不错: 1、判断回文子串  2 、遍历所有字符子串，丢入方法中判断。
    public static String longestPalindromeThree(String s){
        if (null==s||s.length()==0||s.length()==1)
            return s;
        int i=0 , j=1 , size=0 , location=0;
        while (i<(s.length()-1)&&j<s.length()){
            if (j-i>size){
                if(isPalindrome(s.substring(i , j+1))){
                    size = j-i ;
                    location = i ;
                }
            }
            j++;
            if (j==s.length()){
                i++;
                j=i+size;
            }
        }
        return s.substring(location,location+size+1) ;
    }
    /*
     *
     * 这个思路是参考网上一朋友的，
     * 思路为回文子串一定是离边界下标相等的两边两个元素一定是相等的，不管单核还是双核，单核会在中间相会，如其中一对不等，
     * 则不为回文子串。
     *
     * */
    public static boolean isPalindrome(String s){
        int i = 0 , j=s.length()-1 ;
        while (i<=j){
            if (s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }

}
