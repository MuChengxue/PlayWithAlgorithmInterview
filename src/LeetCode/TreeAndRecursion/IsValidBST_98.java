package LeetCode.TreeAndRecursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IsValidBST_98 {
    //####################################################################################################
    private long prev = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validate(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public boolean isValidBST2(TreeNode root) {
        return (root == null) || (isValidBST2(root.left) && prev < (prev = root.val) && isValidBST2(root.right));
    }

    //####################################################################################################
    public boolean isValidBST3(TreeNode root) {
        List<Integer> list = inorder(root, new ArrayList<>());

        int len = list.size();
        if (len < 2)
            return true;
        if (list.get(0) <= Long.MIN_VALUE || list.get(len - 1) >= Long.MAX_VALUE)
            return false;

        for (int i = 1; i < len; i++) {
            if (list.get(i) <= list.get(i - 1))
                return false;
        }

        return true;
    }

    public List<Integer> inorder(TreeNode node, List list) {
        if (node == null)
            return list;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);

        return list;
    }

    //#################################################################################
    public boolean isValidBST4(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double min = Long.MIN_VALUE;//保证不越界

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // If next element in inorder traversal
            // is smaller than the previous one
            // that's not BST.
            if (root.val <= min)
                return false;

            min = root.val;
            root = root.right;
        }
        return true;
    }

}
