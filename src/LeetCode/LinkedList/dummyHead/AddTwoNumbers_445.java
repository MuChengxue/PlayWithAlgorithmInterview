package LeetCode.LinkedList.dummyHead;

import LeetCode.LinkedList.ListNode;

import java.util.Stack;

public class AddTwoNumbers_445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode beforeHead = new ListNode(0), curNode = beforeHead;
        int carry = 0;
        int cur = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int sum = 0;
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }

            sum += carry;
            cur = sum % 10;
            carry = sum / 10;
            stack.push(cur);
        }

        if (carry == 1)
            stack.push(carry);

        while (!stack.isEmpty()) {
            curNode.next = new ListNode(stack.pop());
            curNode = curNode.next;
        }
        return beforeHead.next;
    }


    int flow = 0;

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode res1 = l1, res2 = l2;

        int len1 = 0, len2 = 0;
        while (l1 != null) {
            len1++;
            l1 = l1.next;
        }
        while (l2 != null) {
            len2++;
            l2 = l2.next;
        }

        ListNode res = len1 > len2 ? add(res1, res2, len1, len2) : add(res2, res1, len2, len1);
        if (flow == 1) {
            res1 = new ListNode(1);
            res1.next = res;
            return res1;
        }
        return res;
    }

    public ListNode add(ListNode l1, ListNode l2, int len1, int len2) {
        int temp;
        if ((len1 == 1) && (len2 == 1)) {
            temp = l1.val;
            l1.val = (l1.val + l2.val) % 10;
            flow = (temp + l2.val) / 10;
            return l1;
        }
        if (len1 > len2) {
            temp = l1.val;
            l1.next = add(l1.next, l2, len1 - 1, len2);
            l1.val = (temp + flow) % 10;
            flow = (temp + flow) / 10;
            return l1;
        }
        l1.next = add(l1.next, l2.next, len1 - 1, len2 - 1);
        temp = l1.val;
        l1.val = (temp + flow + l2.val) % 10;
        flow = (temp + flow + l2.val) / 10;
        return l1;

    }
}


