package com.sun.al.leetcode;

import java.util.List;

public class RomoveNodeFromEnd {


    public static void main(String[] args) {





    }

    // 这道题也是经典题，利用的是faster和slower双指针来解决。
    //首先先让faster从起始点往后跑n步。
    //然后再让slower和faster一起跑，直到faster==null时候，slower所指向的node就是需要删除的节点。
    //注意，一般链表删除节点时候，需要维护一个prev指针，指向需要删除节点的上一个节点。
    //为了方便起见，当让slower和faster同时一起跑时，就不让 faster跑到null了，让他停在上一步，faster.next==null时候，
    // 这样slower就正好指向要删除节点的上一个节点，充当了prev指针。这样一来，就很容易做删除操作了。
    //slower.next = slower.next.next(类似于prev.next = prev.next.next)。
    //同时，这里还要注意对删除头结点的单独处理，要删除头结点时，没办法帮他维护prev节点，所以当发现要删除的是头结点时，
    // 直接让head = head.next并returnhead就够了。

    public ListNode removeNthFromEnd(ListNode head , int n){

        ListNode ln = head.next;
        int i = 1 ;
        while (ln != null){
            ln = ln.next;
            i++;
        }

        int j = 0 ;
        ListNode lln = head.next;
        while (j < i-n+2){

            if ()

        }

        return null ;

    }

}
