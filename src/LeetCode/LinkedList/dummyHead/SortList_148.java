package LeetCode.LinkedList.dummyHead;

import LeetCode.LinkedList.ListNode;

public class SortList_148 {

    //递归方法
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;//链表已经从中间分开

        ListNode left = sortList(head);//递归用到了栈，空间不复杂度不是常数
        ListNode right = sortList(head2);

        ListNode beforeHead = new ListNode(0);
        ListNode cur = beforeHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }

            cur = cur.next;
        }

        cur.next = left == null ? right : left;
        return beforeHead.next;
    }

    //############################################################################################################
    //递归方法2，业务逻辑更清晰
    public ListNode sortList2(ListNode head) {
        // 1、递归结束条件
        if (head == null || head.next == null) {
            return head;
        }

        // 2、找到链表中间节点并断开链表 & 递归下探
        ListNode midNode = middleNode(head);
        ListNode rightHead = midNode.next;
        midNode.next = null;

        ListNode left = sortList2(head);
        ListNode right = sortList2(rightHead);

        // 3、当前层业务操作（合并有序链表）
        return mergeTwoLists(left, right);
    }

    //  找到链表中间节点（876. 链表的中间结点）
    private ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // 合并两个有序链表（ 合并两个有序链表）
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode beforeHead = new ListNode(-1);
        ListNode curr = beforeHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        curr.next = l1 != null ? l1 : l2;
        return beforeHead.next;
    }

//###################################################################################################################

    public ListNode sortList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 获取链表长度
        int len = listNodeLength(head);

        // 哨兵节点，也有叫傀儡节点（处理链表问题的一般技巧）
        ListNode sentry = new ListNode(-1);
        sentry.next = head;

        // #########循环 log n 次##########
        for (int i = 1; i < len; i <<= 1) {
            ListNode prev = sentry;
            ListNode curr = sentry.next;
            // 循环 n 次
            while (curr != null) {
                ListNode left = curr;
                ListNode right = split(left, i);
                curr = split(right, i);
                prev.next = mergeTwoLists2(left, right);

                while (prev.next != null) {
                    prev = prev.next;
                }
            }
        }

        return sentry.next;
    }

    // 根据步长分隔链表
    private ListNode split(ListNode head, int step) {
        if (head == null)
            return null;

        for (int i = 1; head.next != null && i < step; i++) {
            head = head.next;
        }

        ListNode right = head.next;
        head.next = null;
        return right;
    }

    // 获取链表的长度
    private int listNodeLength(ListNode head) {
        int length = 0;
        ListNode curr = head;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

        return length;
    }

    // 合并两个有序链表
    private ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode sentry = new ListNode(-1);
        ListNode curr = sentry;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        curr.next = l1 != null ? l1 : l2;
        return sentry.next;
    }


}
