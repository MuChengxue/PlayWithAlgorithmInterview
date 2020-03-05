package LeetCode.LinkedList.dummyHead;

import LeetCode.LinkedList.CreatedLinkedList;
import LeetCode.LinkedList.ListNode;

public class ReorderList_143 {
    public static void main(String[] args) {
        int[] data1 = new int[]{1, 2, 3};
        int[] data2 = new int[]{5, 4};

        CreatedLinkedList.printList(new ReorderList_143().merge(CreatedLinkedList.createdLinkedList(data1), CreatedLinkedList.createdLinkedList(data2)));

//        CreatedLinkedList.printList(new ReorderList_143().reorderList2(CreatedLinkedList.createdLinkedList(data)));
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            cur.next = rotateRight(next, 1);
            cur = cur.next.next;
        }
    }

    private ListNode rotateRight(ListNode head, int k) {
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

    //############################################################################################################
    public ListNode reorderList2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        //1. 使用快慢指针,找出链表的中心节点。
        // 1->2->3->4->5,中心节点为3
        ListNode middle = middleNode(head);

        //2. 将原始链表按照中心链表分割为两个链表，并将右链表反转
        //2.1 原始链表：1->2->3->4->5 左链表：1->2->3 右链表：4->5
        ListNode right = middle.next;
        middle.next = null;
        ListNode left = head;

        //2.2 反转右链表
        //原始右链表：4->5 反转后：5->4
        right = reverse(right);

        //3. 合并两个链表，将右链表插入到左链表
        //左链表：1->2->3 右链表：4->5 合并后：1->5->2->4->3
        return merge(left, right);
    }

    //1. 使用快慢指针,找出链表的中心节点
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //2. 通过递归反转链表
    public ListNode reverse(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode pre=null;
//        ListNode cur=head;
//        while (cur!=null){
//            ListNode next=cur.next;
//
//            cur.next=pre;
//            pre=cur;
//            cur=next;
//        }
//        return  pre;

        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    //3. 合并两个链表，将右链表插入到左链表
    public ListNode merge(ListNode left, ListNode right) {
        ListNode beforeHead = new ListNode(-1);
        ListNode curr = beforeHead;
        int i = 0;
        while (left != null && right != null) {
            if (i == 0) {
                curr.next = left;
                curr = curr.next;
                left = left.next;
                i = 1 - i;
            } else {
                curr.next = right;
                curr = curr.next;
                right = right.next;
                i = 1 - i;
            }
        }
        curr.next = left == null ? right : left;
        return beforeHead.next;
    }
}
