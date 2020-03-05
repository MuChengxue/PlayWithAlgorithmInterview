package LeetCode.StackAndQueue.DFS;

import LeetCode.StackAndQueue.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class ZigzagLevelOrder_103_3 {
    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        helper(root, 0);
        return ans;
    }


    private void helper(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        insert(root, level);

        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }

    private void insert(TreeNode node, int level) {
        List<Integer> list = level >= ans.size() ? null : ans.get(level);
        if (list == null) {
            list = new LinkedList<>();
            list.add(node.val);
            ans.add(list);
        } else {
            boolean isOdd = (level & 1) == 1;
            list.add(isOdd ? 0 : list.size(), node.val);
        }
    }
}
