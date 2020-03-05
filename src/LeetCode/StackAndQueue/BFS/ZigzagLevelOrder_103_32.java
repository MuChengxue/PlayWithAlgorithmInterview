package LeetCode.StackAndQueue.BFS;

import LeetCode.StackAndQueue.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder_103_32 {
    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                insert(node, level);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            level++;
        }
        return ans;
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
