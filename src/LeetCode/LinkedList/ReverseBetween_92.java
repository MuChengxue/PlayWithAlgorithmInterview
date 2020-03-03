package LeetCode.LinkedList;

public class ReverseBetween_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }
        ListNode tmp = new ListNode(Integer.MIN_VALUE);
        tmp.next = head;//巧妙的设计，解决m==1的情况
        ListNode m_1 = tmp;//m_1是第m-1个Node
        int i = 1;
        for (; i < m; i++) {
            m_1 = m_1.next;
        }
        ListNode mNode = m_1.next;//head

        ListNode pre = null;
        ListNode cur = mNode;
        ListNode next=null;
        for (; i <n; i++) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        m_1.next.next=next;
        m_1.next=pre;
        //https://pic.leetcode-cn.com/3158b23f7e6919d47a11a2f57e921b5645fceb84212450336f2256f5659fa9e7.jpg
        return tmp.next;
    }

    ListNode successor = null; // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点 1-2-3-4-5-null 3  答案 3-2-1-4-5-null
    ListNode reverseN(ListNode head, int n) {//3
        if (n == 1) {//base case 变为 n == 1，反转一个元素，就是它本身，同时要记录后驱节点
            // 记录第 n + 1 个节点
            successor = head.next;//4
            return head;//
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);//1-2,2 2-3,1 返回3 2
        // 让反转之后的 head 节点和后面的节点连起来
        head.next.next = head;//3-2-4 1-2 4-5-null@3-2-1-4 4-5-null
        head.next = successor;
        return last;
    }

    ListNode reverseBetween2(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }


}


