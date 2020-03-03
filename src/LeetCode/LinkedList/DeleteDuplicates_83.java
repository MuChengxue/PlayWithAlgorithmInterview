package LeetCode.LinkedList;

public class DeleteDuplicates_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode tmp = null;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                tmp = cur.next;
                cur.next = cur.next.next;
                tmp.next = null;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null)
            return null;

        ListNode low = head;
        ListNode fast = head;

        while (fast.next != null) {
            if (fast.next.val == low.val) {
                low.next = fast.next.next;
            } else {
                low = low.next;
                fast = fast.next;
            }
        }

        return head;
    }

    public ListNode deleteDuplicates3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null) {
            if (cur.val == pre.val) {
                pre.next=cur.next;
                cur.next=null;
                cur=pre.next;
            } else {
                pre=cur;
                cur = pre.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        CreatedLinkedList.printList(new DeleteDuplicates_83().deleteDuplicates2(CreatedLinkedList.createdLinkedList(new int[]{1, 1, 1})));
    }
}
