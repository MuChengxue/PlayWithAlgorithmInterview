package LeetCode.LinkedList;

public class ReverseList_206 {
    //迭代
    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;

    }

    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    //递归1-2-3-4-5-null
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null)//递归结束的base case是head.next == null  head==null是为了判断是否为空
            return head;
        ListNode p = reverseList(head.next);//1-2 2-3 3-4 4-5   返回p 5-4 4-3 3-2 2-1 1-null
        head.next.next = head;//1-2-3-4-null 5-4-null @@1-2-3-null 5-4-3-null @@1-2-null 5-4-3-2-null @@1-null 5-4-3-2-1-null
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        int [] arr=new int[]{1,2,3,4,5};
        ListNode head=CreatedLinkedList.createdLinkedList(arr );
        CreatedLinkedList.printList(head);
        CreatedLinkedList.printList(new ReverseList_206().reverseList3(head));
    }

}


