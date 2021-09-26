package sun.al.leetcode;

public class MergeKSortedList {


    public static void main(String[] args) {

        MergeKSortedList mtl = new MergeKSortedList();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(6);
        l3.next = new ListNode(7);
        l3.next.next = new ListNode(8);


        ListNode[] lists = {l1 , l2 , l3};

        ListNode ll = mtl.mergeKListsMyone(lists);

        ListNode l = ll ;
        while (l!=null){
            System.out.print(l.val);
            l = l.next;
        }


    }

    public ListNode mergeKListsMyone(ListNode[] lists) {

        if (null ==  lists || lists.length==0 )
            return null ;
        if (lists.length==1)
            return lists[0];

        ListNode l = lists[0] ;
        for (int i=1 ; i<lists.length ; i++){
            l = mergeTwoLists(l , lists[i]);
        }

        return l;
    }


    public ListNode mergeTwoLists(ListNode l1 , ListNode l2){
        if (null == l1 || null == l2)
            return l1 == null ? l2 : l1 ;

        ListNode l = new ListNode(0);

        ListNode ll = l ;

        while (l1 != null || l2 != null){

            if (l1==null){
                ll.next = l2 ;
                l2 = l2.next;
            }else if (l2 == null){
                ll.next = l1 ;
                l1 = l1.next;
            }else if (l1.val>l2.val){
                ll.next = l2 ;
                l2 = l2.next;
            }else{
                ll.next = l1 ;
                l1 = l1.next;
            }
            ll = ll.next;

        }

        return l.next ;

    }


}
