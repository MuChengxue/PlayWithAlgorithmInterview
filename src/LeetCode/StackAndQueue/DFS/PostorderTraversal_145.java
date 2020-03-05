package LeetCode.StackAndQueue.DFS;

import LeetCode.StackAndQueue.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal_145 {
    List resList = new ArrayList();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            resList.add(root.val);
        }

        return resList;
    }

    public List<Integer> postorderTraversal2(TreeNode head) {
        List<Integer> list = new ArrayList<>();
        if (head == null) {
            return list;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            list.add(stack2.pop().val);
        }

        return list;
    }

    public List<Integer> postorderTraversal2_2(TreeNode head) {
        List<Integer> list = new ArrayList<>();
        if (head == null) {
            return list;
        }

        TreeNode cur = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            if (peek.left != null && peek.left != cur && peek.right != cur) {
                stack.push(peek.left);
                cur = peek.left;
            } else if (peek.right != null && peek.right != cur) {
                stack.push(peek.right);
                cur = peek.right;
            } else {
                TreeNode pop = stack.pop();
                list.add(stack.pop().val);
                cur = pop;
            }
        }

        return list;
    }

    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur == null) {
                continue;
            }
            if (!stack.isEmpty() && cur == stack.peek()) {
                stack.push(cur.right);
                stack.push(cur.right);
                stack.push(cur.left);
                stack.push(cur.left);
            } else {
                list.add(cur.val);
            }
        }
        return list;
    }

}
