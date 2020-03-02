package com.sun.al.leetcode;

public class RomanToInt {


    public static void main(String[] args) {

        RomanToInt rti = new RomanToInt();
        System.out.println(rti.romanToInt("MCMXCIV"));




    }


    public int romanToInt(String s) {
        int sum = 0 ;
        String temp = "";
        for (int i=0 ; i<s.length() ; i++){
            if ((i+2)<s.length()+1){
                temp = s.substring(i , i+2);
                if (temp.equals("IV")){
                    sum += 4 ;
                    ++i;
                    continue;
                }else if (temp.equals("IX")){
                    sum +=9 ;
                    ++i;
                    continue;
                }else if (temp.equals("XL")){
                    sum +=40 ;
                    ++i;
                    continue;
                }else if (temp.equals("XC")){
                    sum += 90 ;
                    ++i;
                    continue;
                }else if (temp.equals("CD")){
                    sum += 400 ;
                    ++i;
                    continue;
                }else if (temp.equals("CM")){
                    sum += 900;
                    ++i;
                    continue;
                }
            }
            temp=s.substring(i , i+1);
            if ("I".equals(temp)){
                sum +=1;
            }else if ("V".equals(temp)){
                sum += 5;
            }else if ("X".equals(temp)){
                sum += 10;
            }else if ("L".equals(temp)){
                sum += 50;
            }else if ("C".equals(temp)){
                sum += 100;
            }else if ("D".equals(temp)){
                sum += 500;
            }else if ("M".equals(temp)){
                sum += 1000;
            }
        }

        return sum ;
        }

    }
