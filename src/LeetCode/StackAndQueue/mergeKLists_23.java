package LeetCode.StackAndQueue;

import LeetCode.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class mergeKLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int min = Integer.MAX_VALUE;
        int minNode = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < min) {
                min = lists[i].val;
                minNode = i;
            }
        }
        if (minNode == -1)
            return null;

        ListNode node = lists[minNode];
        lists[minNode] = lists[minNode].next;

        node.next = mergeKLists(lists);
        return node;
    }

    //##################################################################################################
    public ListNode mergeKLists2(ListNode[] lists) {
        int len = lists.length;
        List<Integer> list = new ArrayList();
        for (int i = 0; i < len; i++) {
            while (lists[i] != null) {
                list.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }

        Collections.sort(list);
        ListNode beforeHead = new ListNode(0);
        ListNode cur = beforeHead;
        for (int v : list) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }

        return beforeHead.next;
    }

    //######################################################################################
    public ListNode mergeKLists3(ListNode[] lists) {
        int len = lists.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (a - b));//小顶
        List<Integer> list = new ArrayList();
        for (int i = 0; i < len; i++) {
            while (lists[i] != null) {
                queue.offer(lists[i].val);
                lists[i] = lists[i].next;
            }
        }

        ListNode beforeHead = new ListNode(0);
        ListNode cur = beforeHead;
        while (!queue.isEmpty()) {
            cur.next = new ListNode(queue.poll());
            cur = cur.next;
        }

        return beforeHead.next;
    }

    //######################################################################################
    public ListNode mergeKLists4(ListNode[] lists) {
        int len = lists.length;
        if (len == 0)
            return null;
        ListNode beforeHead = new ListNode(1);
        ListNode cur = lists[0];

        for (int i = 1; i < len; i++) {
            cur = mergeTwoLists(cur, lists[i]);
        }

        return cur;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode beforeHead = new ListNode(-1);
//        ListNode curr = beforeHead;
//
//        while (l1 != null && l2 != null) {
//            if (l1.val < l2.val) {
//                curr.next = l1;
//                l1 = l1.next;
//            } else {
//                curr.next = l2;
//                l2 = l2.next;
//            }
//
//            curr = curr.next;
//        }
//
//        curr.next = l1 != null ? l1 : l2;
//        return beforeHead.next;

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    //######################################################################################
    public ListNode mergeKLists5(ListNode[] lists) {
        int len = lists.length;
        if (len == 0)
            return null;
        if (len == 1)
            return lists[0];

        // #########循环 log n 次##########
        for (int i = 1; i < len; i <<= 1) {
            // 循环 k次:链表最大长度
            for (int j = 0; j < len - i; j = j + (i * 2)) {
                lists[j] = mergeTwoLists5(lists[j], lists[j + i]);
            }
        }

        return lists[0];
    }

    public ListNode mergeTwoLists5(ListNode l1, ListNode l2) {
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
}
