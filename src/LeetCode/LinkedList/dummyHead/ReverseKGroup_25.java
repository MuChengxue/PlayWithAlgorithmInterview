package LeetCode.LinkedList.dummyHead;

import LeetCode.LinkedList.ListNode;

public class ReverseKGroup_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // pre  [start end] next
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++)
                end = end.next;
            if (end == null)
                break;

            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;

            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    private ListNode reverse2(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode p = reverse2(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }

}
