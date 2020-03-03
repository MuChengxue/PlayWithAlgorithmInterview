package LeetCode.LinkedList.dummyHead;

import LeetCode.LinkedList.CreatedLinkedList;
import LeetCode.LinkedList.ListNode;

public class Partition_86 {
    public ListNode partition(ListNode head, int x) {
        if (head==null||head.next==null)
            return head;

        ListNode smallHead=new ListNode(Integer.MIN_VALUE),smallNode=smallHead;
        ListNode bigHead=new ListNode(Integer.MAX_VALUE),bigNode=bigHead;
        ListNode cur=head;
        while (cur!=null){
            if (cur.val<x){
                smallNode.next=new ListNode(cur.val);
                smallNode=smallNode.next;
            }else {

                bigNode.next=new ListNode(cur.val);
                bigNode=bigNode.next;
            }

            cur=cur.next;
        }
        smallNode.next=bigHead.next;

        return smallHead.next;
    }

    public ListNode partition2(ListNode head, int x) {
        if (head==null||head.next==null)
            return head;

        ListNode smallHead=new ListNode(Integer.MIN_VALUE),smallNode=smallHead;
        ListNode bigHead=new ListNode(Integer.MAX_VALUE),bigNode=bigHead;
        ListNode cur=head;
        while (cur!=null){
            if (cur.val<x){
                smallNode.next=cur;
                smallNode=smallNode.next;
            }else {

                bigNode.next=cur;
                bigNode=bigNode.next;
            }

            cur=cur.next;
        }
        bigNode.next=null;//超级重要，不然成环
        smallNode.next=bigHead.next;

        return smallHead.next;
    }


    public static void main(String[] args) {
        CreatedLinkedList.printList(new Partition_86().partition(CreatedLinkedList.createdLinkedList(new int[]{1,4,3,2,5,2} ),3 ));
    }
}
