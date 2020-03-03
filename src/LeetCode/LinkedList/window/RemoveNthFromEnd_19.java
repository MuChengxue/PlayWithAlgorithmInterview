package LeetCode.LinkedList.window;

import LeetCode.LinkedList.ListNode;

public class RemoveNthFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode beforeHead=new ListNode(0);
        beforeHead.next=head;

        ListNode p=beforeHead;
        ListNode q=beforeHead;
        for (int i=0;i<n+1;i++){
            if (q!=null)
                q=q.next;
        }

        while (q!=null){
            p=p.next;
            q=q.next;
        }

        ListNode tmp=p.next;
        p.next=tmp.next;
        tmp.next=null;

        return beforeHead.next;
    }
}
