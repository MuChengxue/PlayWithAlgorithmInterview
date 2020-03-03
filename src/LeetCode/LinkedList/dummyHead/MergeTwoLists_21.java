package LeetCode.LinkedList.dummyHead;

import LeetCode.LinkedList.ListNode;

public class MergeTwoLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode beforeHead = new ListNode(Integer.MIN_VALUE);
        ListNode cur = beforeHead;
        int num1 = 0, num2 = 0;
        while (l1 != null && l2 != null) {
            num1 = l1.val;
            num2 = l2.val;
            if (num1 < num2) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;

        }
        if (l1 != null)
            cur.next = l1;
        if (l2 != null)
            cur.next = l2;

        return beforeHead.next;
    }


    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }

    }


}
