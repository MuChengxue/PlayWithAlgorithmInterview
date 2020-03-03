package LeetCode.StackAndQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal_145 {
    List resList=new ArrayList();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root!=null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            resList.add(root.val);
        }

        return resList;
    }

    public  List<Integer> postorderTraversal2(TreeNode head) {
        List res=new ArrayList();
        if (head == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return res;
    }
}
