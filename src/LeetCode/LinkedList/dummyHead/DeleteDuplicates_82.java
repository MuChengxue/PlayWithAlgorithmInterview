package LeetCode.LinkedList.dummyHead;

import LeetCode.LinkedList.CreatedLinkedList;
import LeetCode.LinkedList.ListNode;

public class DeleteDuplicates_82 {//1-1-1-2-3  1-2-3-3-4-4-5
    public ListNode deleteDuplicates(ListNode head) {
        ListNode beforeHead=new ListNode(Integer.MIN_VALUE);
        beforeHead.next=head;
        ListNode cur=beforeHead;
        ListNode tmp=null;

        while (cur.next!=null&&cur.next.next!=null){//1-1-1-2-3  1-2-3-3-4-4-5
            if (cur.next.val==cur.next.next.val){//1
                tmp=cur.next.next;
                int val=tmp.val;

                while (tmp!=null&&tmp.val==val){
                    tmp=tmp.next;
                }
                cur.next=tmp;
            }else {
                cur=cur.next;
            }
        }
        return beforeHead.next;
    }

    public static void main(String[] args) {
        int[] a=new int[]{1,1,1,2,3};
        int[] b=new int[]{1,2,3,3,4,4,5};

        CreatedLinkedList.printList(new DeleteDuplicates_82().deleteDuplicates(CreatedLinkedList.createdLinkedList(b)));
    }
}
