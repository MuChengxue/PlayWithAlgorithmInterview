package LeetCode.StackAndQueue.BFS;

import LeetCode.StackAndQueue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView_199 {
    public List<Integer> rightSideView(TreeNode root) {
        //思路一：层次遍历，将每层的最后一个节点的值放入List<Integer>中
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        //用于放节点的队列
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode node = null;
        q.offer(root);
        int len = q.size();

        while (!q.isEmpty()) {
            for (int i = 0; i < len; i++) {
                node = q.poll();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);

                //每层队列的最后一个元素的值，放入res
                if (i == len - 1)
                    res.add(node.val);
            }
            len = q.size();
        }
        return res;
    }

    //##############################################################################################################
    public List<Integer> rightSideView2(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            levels.add(new ArrayList<Integer>());

            int level_length = queue.size();
            for (int i = 0; i < level_length; ++i) {
                TreeNode node = queue.remove();
                levels.get(level).add(node.val);

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            level++;
        }

        for (int i = 0; i < levels.size(); i++)
            res.add(levels.get(i).get(levels.get(i).size() - 1));

        return res;
    }

    //############################################################################################################
    public List<Integer> rightSideView3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, 0, res);
        return res;
    }

    public void inOrder(TreeNode node, int level, List<Integer> res) {
        if (node == null)
            return;
        if (res.size() == level)
            res.add(node.val);

        inOrder(node.right, level + 1, res);
        inOrder(node.left, level + 1, res);
    }


}
