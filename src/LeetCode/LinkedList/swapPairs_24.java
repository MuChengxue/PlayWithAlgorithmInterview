package LeetCode.LinkedList;

public class swapPairs_24 {
    public ListNode swapPairs(ListNode head) {
        ListNode beforeHead=new ListNode(0);
        beforeHead.next=head;

        ListNode pre=beforeHead;

        while (pre.next!=null&&pre.next.next!=null){
            ListNode node1=pre.next;
            ListNode node2=node1.next;
            ListNode next=node2.next;

            node2.next=node1;
            node1.next=next;
            pre.next=node2;

            pre=node1;
        }

        return beforeHead.next;
    }
}
