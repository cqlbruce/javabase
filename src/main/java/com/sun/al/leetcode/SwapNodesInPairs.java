package com.sun.al.leetcode;

public class SwapNodesInPairs {

    public static void main(String[] args) {

        SwapNodesInPairs snip = new SwapNodesInPairs();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);

        ListNode res = snip.swapPairsThree(listNode);
        ListNode temp = res;
        while (temp != null){
            System.out.print(temp.val);
            temp=temp.next;
        }

    }

    public ListNode swapPairsOne(ListNode head){
        if (head==null || head.next==null)
            return head;

        ListNode res = new ListNode(0);
        ListNode reslist = res;
        ListNode orgList = head;
        while (orgList!=null){
            if (orgList.next != null ){
                reslist.next = new ListNode(orgList.next.val);
                reslist.next.next = new ListNode(orgList.val);
                reslist = reslist.next.next;
                orgList = orgList.next.next;
            }else {
                reslist.next = new ListNode(orgList.val);
                return res.next;
            }
        }
        return res.next ;
    }

    // 将相邻的两个节点进行交换，在不交换值的前提条件下，只对节点指针进行交换。   时间复杂度为o(n)，空间复杂度为O(1)。
    //  思路： 可以利用链表中的哨兵机制来简化操作。具体操作步骤如下：

    public ListNode swapPairsTwo(ListNode head){
        if (head==null || head.next==null)
            return head;

        ListNode ln = new ListNode(0);
        ListNode p = ln ;
        ln.next = head;
        ListNode temp = null ;
        while (head!=null && head.next!=null){
            temp = head.next;
            head.next = temp.next;
            temp.next = head;
            p.next=temp;
            p=head;
            head=head.next;
        }
        return ln.next ;
    }

    // 递归法
    public ListNode swapPairsThree(ListNode head){
        if (head==null || head.next==null)
            return head;


        ListNode list = head.next;
        head.next=swapPairsTwo(head.next.next);
        list.next = head;

        return list ;
    }


}
