package LeetCode.LinkedList.dummyHead;


import LeetCode.LinkedList.ListNode;

import java.math.BigInteger;

public class AddTwoNumbers_002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        while (l1 != null) {
            str1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            str2.append(l2.val);
            l2 = l2.next;
        }

        BigInteger a = new BigInteger(String.valueOf(str1.reverse()));
        BigInteger b = new BigInteger(String.valueOf(str1.reverse()));
        BigInteger sum = a.add(b);
        String sumStr = sum.toString();

        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for (int j = 0; j < sumStr.length(); j++) {
            cur.next = new ListNode((int) sumStr.charAt(j));
            cur = cur.next;
        }

        return head.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode beforeHead = new ListNode(0);
        ListNode cur = beforeHead;
        int carry = 0;
        int curNum = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            curNum = sum % 10;
            carry = sum / 10;

            cur.next = new ListNode(curNum);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return beforeHead.next;

    }

    public static void main(String[] args) {

    }
}
