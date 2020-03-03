package LeetCode.LinkedList.dummyHead;

import LeetCode.LinkedList.ListNode;

public class RemoveElements_203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head==null)
            return head;

        ListNode beforeHead=new ListNode(0),pre=beforeHead;
        while (head!=null){
            if (head.val==val){
                pre.next=head.next;
                head.next=null;
                head=pre.next;
            }else {
                pre.next=head;
                pre=head;
                head=head.next;
            }
        }

        return beforeHead.next;
    }

    public ListNode removeElements2(ListNode head, int val) {


        ListNode beforeHead=new ListNode(0);
        beforeHead.next=head;
        ListNode cur=beforeHead;
        ListNode tmp=null;
        while (cur.next!=null){
            if (cur.next.val==val){
                tmp=cur.next;
                cur.next=tmp.next;
                tmp.next=null;
            }else {
                cur=cur.next;
            }
        }

        return beforeHead.next;
    }
}
