package LeetCode.TreeAndRecursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxDepth_104 {
    public int maxDepth(TreeNode root) {
        //递归终止条件
        if (root == null)
            return 0;

        //递归过程逻辑
//        int leftMax = maxDepth(root.left);//左子树高度
//        int rightMax = maxDepth(root.right);//右子树高度
//        return Math.max(leftMax, rightMax) + 1;//加上root

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepth2(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null)
            return levels.size();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            // start the current level
            levels.add(new ArrayList<Integer>());

            // number of elements in the current level
            int level_length = queue.size();
            for (int i = 0; i < level_length; ++i) {
                //Retrieves and removes the head of this queue.
                // This method differs from {@link #poll poll} only in that
                // it throws an exception if thisqueue is empty.
                TreeNode node = queue.remove();

                // fulfill the current level
                levels.get(level).add(node.val);

                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            // go to next level
            level++;
        }
        return levels.size();
    }

    public int maxDepth3(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null)
            return lists.size();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int cap = queue.size();
        int level = 0;
        while (!queue.isEmpty()) {
            lists.add(new ArrayList<>());
            while (cap-- > 0) {
                TreeNode node = queue.poll();
                lists.get(level).add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            cap = queue.size();
            level++;
        }

        return lists.size();
    }

}
