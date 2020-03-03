package LeetCode.LinkedList;

public class DeleteNode_237 {
    public void deleteNode(ListNode node) {
        if (node==null)
            return;
        if (node.next==null){
            node=null;
            return;
        }

        ListNode next=node.next;
        node.val=next.val;
        node.next=next.next;
        next.next=null;
    }
}
