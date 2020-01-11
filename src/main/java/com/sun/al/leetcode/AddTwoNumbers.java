package com.sun.al.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {
/*
    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807
*/
    public static void main(String[] args) {
        ListNode l1 = new ListNode(8) ;
        l1.next = new ListNode(3) ;
        l1.next.next = new ListNode(6) ;
        ListNode l2 = new ListNode(6) ;
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(9) ;

//        ListNode l1 = new ListNode(9) ;
//        l1.next = new ListNode(8) ;
//        ListNode l2 = new ListNode(1) ;
//        ListNode ll = AddTwoNumbers.addTwoNumOne(l1 , l2);
        ListNode ll = AddTwoNumbers.addTwoNumTwo(l1 , l2);

        while (true){
            System.out.print(ll.val);
            ll = ll.next ;
            if(ll !=null){
                System.out.print("->");
            }else {
                break;
            }
        }
    }

    //s1 时间效率 o(n)
    public static ListNode addTwoNumOne(ListNode l1 , ListNode l2){
        ListNode l3 = null;
        ListNode firstNode = null ;
        boolean flag = false;
        while (l1 !=null||l2 != null){
            ListNode l = null  ;
            int a = 0 ;
            if(null != l1){
                a = l1.val ;
                l1 = l1.next ;
            }
            int b = 0 ;
            if(null != l2){
                b = l2.val;
                l2 = l2.next ;
            }
            int c = a + b ;
            if(flag){
                c =  c + 1 ;
                flag = false ;
            }
            if(c >= 10 ){
                flag = true ;
                l = new ListNode(c -10);
            }else {
                l = new ListNode(c);
            }
            if (l3 == null){
                firstNode = l ;
                l3 = l ;
            }else {
                l3.next = l ;
                l3 = l3.next;
            }
        }
        if (flag){
            l3.next = new ListNode(1);
        }
        return  firstNode ;
    }


    //s2 时间效率 o(n)
    //改进空间效率
    public static ListNode addTwoNumTwo(ListNode l1 , ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result ;
        boolean flag = false;
        int sum = 0 ;
        int a = 0 ;
        int b = 0 ;
        while (true) {
            if(l1 == null && l2 == null && flag==false){
                break;
            }
            a = 0;
            b = 0;
            if(null != l1){
                a = l1.val ;
                l1 = l1.next ;
            }
            if(null != l2){
                b = l2.val;
                l2 = l2.next ;
            }
            sum = a + b ;
            if(flag){
                sum =  sum + 1 ;
                flag = false ;
            }
            if(sum >= 10 ){
                flag = true ;
                current = current.next  = new ListNode(sum -10);
            }else {
                current = current.next  = new ListNode(sum);
            }
        }
        return  result.next ;
    }

}
