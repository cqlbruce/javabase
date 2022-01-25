package sun.al.leetcode;

public class RotateList {

    class ListNode{

        int val ;
        ListNode next ;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }

        ListNode(int val , ListNode next){
            this.val = val;
            this.next=next;
        }

    }


    public static void main(String[] args) {



    }


    public static ListNode rotateRight(ListNode head , int k){
        if(head==null){
            return null;
        }
        ListNode node = head;
        int l=1;
        while (node.next!=null){
            node = node.next;
            l++;
        }
        node.next = head;
        k=k%l;
        ListNode nextNode = head;
        ListNode preNode = head;
        for (int i=0 ; i<l-k ; i++){
            preNode = nextNode;
            nextNode = nextNode.next;
        }

        preNode.next = null ;


        return nextNode ;
    }



}
