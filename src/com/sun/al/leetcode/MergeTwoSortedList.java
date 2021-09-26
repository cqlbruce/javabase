package sun.al.leetcode;

public class MergeTwoSortedList {

    public static void main(String[] args) {

        MergeTwoSortedList mtl = new MergeTwoSortedList();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode ll = mtl.mergeTwoList(l1 , l2);

        ListNode l = ll ;
        while (l!=null){
            System.out.print(l.val);
            l = l.next;
        }
    }

    public ListNode mergeTwoList(ListNode l1 , ListNode l2){

        if (l1==null && l2 == null)
            return null ;
        if (l1 == null && l2 !=null)
            return l2;
        if (l2 == null && l1!=null)
            return l1;



        ListNode l = new ListNode(0);


        ListNode ll = l ;
        ListNode ll1 = l1 ;
        ListNode ll2 = l2 ;

        while (ll1 != null || ll2 != null){


            if (ll1 == null && ll2 != null){
                ll.next = ll2;
                break;
            }

            if (ll1 != null && ll2 == null){
                ll.next = ll1;
                break;
            }

            if (ll1.val<=ll2.val){
                ll.next = ll1;
                ll = ll.next;
                ll1 = ll1.next;
            }else {
                ll.next = ll2;
                ll = ll2;
                ll2=ll2.next;

            }

        }

        return l.next ;
    }

}
