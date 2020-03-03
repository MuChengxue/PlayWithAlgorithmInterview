package LeetCode.LinkedList;

public class CreatedLinkedList {
    public  static ListNode createdLinkedList(int[] arr){
        int n=arr.length;
        if (n==0)
            return null;

        ListNode head=new ListNode(arr[0]);
        ListNode cur=head;
        for (int i=1;i<n;i++){
            cur.next=new ListNode(arr[i]);
            cur=cur.next;
        }

        return head;
    }

    public static void printList(ListNode node){
        while (node!=null){
            System.out.print(node.val+" -> ");
            node=node.next;
        }
        System.out.print("null");
        System.out.println();
    }
}
