package LeetCode.LinkedList.dummyHead;

import LeetCode.LinkedList.ListNode;

public class InsertionSortList_147 {
    public ListNode insertionSortList(ListNode head) {
        // 定义三个指针 pre, cur, lat
        //pre    cur    lat
        // h  ->  4  ->  2  ->  5  ->  3  ->  null
        if (head == null || head.next == null) {
            return head;
        }

        ListNode beforeHead = new ListNode(-1);
        beforeHead.next = head;
        ListNode pre = beforeHead;
        ListNode cur = head;
        ListNode next;

        while (cur != null) {
            next = cur.next; // 记录下一个要插入排序的值

            if (next != null && next.val < cur.val) { // 只有 cur.next 比 cur 小才需要向前寻找插入点
                // 寻找插入点，从 pre 开始遍历 （每次都是头节点 h 开始向后遍历，因为单向链表是无法从后往前遍）
                while (pre.next != null && pre.next.val < next.val) { // 如果当前节点的值小于要插入排序的值
                    pre = pre.next; // 继续向后移动
                }
                // 找到要插入的位置，此时 pre 节点后面的位置就是 lat 要插入的位置

                // 交换 pre后边的节点 跟 lat 节点
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
                // 由于每次都是从前往后找插入位置，但是单向链表是无法从后往前遍历，所以需要每次插入完成后要让 pre 复位
                pre = beforeHead;
            } else {
                // 都这直接把 cur 指针指向到下一个
                cur = next;
            }
        }

        return beforeHead.next;
    }


}
