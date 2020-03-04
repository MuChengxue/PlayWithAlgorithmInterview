package LeetCode.StackAndQueue.tree.DFS;

import LeetCode.StackAndQueue.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal_94 {
    List resList = new ArrayList();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            resList.add(root.val);
            inorderTraversal(root.right);
        }

        return resList;
    }


    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

}
