package LeetCode.StackAndQueue.DFS;

import LeetCode.StackAndQueue.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preorderTraversal_144 {
    List resList = new ArrayList();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            resList.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }

        return resList;
    }

    public  List<Integer> preOrderIteration3(TreeNode head) {
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


