package com.sun.al.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {
/*
    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807
*/
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {


    }

    public ListNode addTwoNumTwo(ListNode l1 , ListNode l2){
        ListNode l3 = null;
        boolean flag = false;
        while (l1.next !=null||l2.next != null){
            ListNode l = null  ;
            int a = 0 ;
            if(null != l1.next){
                l1 = l1.next ;
                a = l1.val ;
            }
            int b = 0 ;
            if(null != l2.next){
                l2 = l2.next ;
                b = l2.val;
            }
            int c = a + b ;
            if(flag)
                c =  c + 1 ;
            if(c > 10 ){
                flag = true ;
                l = new ListNode(c -10);
            }else {
                l = new ListNode(c);
            }
        }

        return  null ;

    }








}
