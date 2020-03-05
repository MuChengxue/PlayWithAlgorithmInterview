package LeetCode.LinkedList.dummyHead;

import LeetCode.LinkedList.CreatedLinkedList;
import LeetCode.LinkedList.ListNode;

public class RotateRight_61 {

    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 4, 5};
        CreatedLinkedList.printList(new RotateRight_61().rotateRight(CreatedLinkedList.createdLinkedList(data), 2));
    }

    //超出时间限制:[1,2,3] 2000000000
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        int n = 0;
        ListNode node = head;
        while (node.next != null) {
            n++;
            node = node.next;
        }
        k = k % (n + 1);

        ListNode beforeHead = new ListNode(0);
        beforeHead.next = head;
        ListNode pre = beforeHead;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            while (cur.next != null) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = null;
            cur.next = beforeHead.next;
            beforeHead.next = cur;
        }

        return beforeHead.next;
    }

    /* 算法实现很直接：
     找到旧的尾部并将其与链表头相连 old_tail.next = head，整个链表闭合成环，同时计算出链表的长度 n。
     找到新的尾部，第 (n - k % n - 1) 个节点 ，新的链表头是第 (n - k % n) 个节点。
     断开环 new_tail.next = None，并返回新的链表头 new_head。*/
    public ListNode rotateRight2(ListNode head, int k) {
        // base cases
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        // close the linked list into the ring
        ListNode old_tail = head;
        int n;
        for (n = 1; old_tail.next != null; n++)
            old_tail = old_tail.next;
        old_tail.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++)
            new_tail = new_tail.next;
        ListNode new_head = new_tail.next;

        // break the ring
        new_tail.next = null;

        return new_head;
    }
}
