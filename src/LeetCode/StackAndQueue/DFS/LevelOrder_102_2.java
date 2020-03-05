package LeetCode.StackAndQueue.DFS;

import LeetCode.StackAndQueue.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder_102_2 {


    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null)
            return levels;
        helper(root, 0, levels);

        return levels;
    }

    public void helper(TreeNode node, int level, List<List<Integer>> levels) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

        // fulfil the current level
        levels.get(level).add(node.val);//精髓

        // process child nodes for the next level
        if (node.left != null)
            helper(node.left, level + 1, levels);
        if (node.right != null)
            helper(node.right, level + 1, levels);
    }

    public void helper2(TreeNode node, int level, List<List<Integer>> levels) {
        if (node == null)
            return;
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

        // fulfil the current level
        levels.get(level).add(node.val);//精髓

        // process child nodes for the next level
        helper(node.left, level + 1, levels);
        helper(node.right, level + 1, levels);
    }

}
