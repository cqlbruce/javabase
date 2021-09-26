package sun.al.leetcode;

public class ReverseNodesInKGroup {


    public static void main(String[] args) {

        ReverseNodesInKGroup rni = new ReverseNodesInKGroup();

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);

        ListNode ret = rni.reverseKGroupMyOne(listNode , 3);

        ListNode temp = ret;
        while (temp != null){
            System.out.print(temp.val);
            temp=temp.next;
        }

    }

    public ListNode reverseKGroupMyOne(ListNode head, int k) {

        if (head == null || head.next == null)
            return head;

        ListNode ret = new ListNode(0);
        ret.next = head;
        ListNode p = ret;
        ListNode flag = p ; //
        ListNode swap = null;
        ListNode swapBefore = null ;

        while (head!=null){
            flag = p ; // 判空节点
            for (int i=0 ; i<k ; i++){
                flag = flag.next;
                if (flag==null)
                    return ret.next ;
            }

            swap = p.next.next;//需要被交换节点
            swapBefore = p.next;
            head = p.next ;

            for (int i=0 ; i<k-1 ; i++){

                ListNode tempNode = swap.next;
                swapBefore.next = tempNode;
                swap.next = head;

                head = swap;
                p.next = swap;
                swap = swapBefore.next ;

                //head = swap;
            }
            //p.next = head;
            p = swapBefore ;
            //head = flag.next;

        }

        return ret.next ;
    }


}
