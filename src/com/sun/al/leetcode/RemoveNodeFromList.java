package sun.al.leetcode;

public class RemoveNodeFromList {

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        RemoveNodeFromList rnf = new RemoveNodeFromList();
        rnf.removeNthFromEnd(node , 2);

    }

    public void removeNthFromEnd(ListNode head , int n ){




    }

}
