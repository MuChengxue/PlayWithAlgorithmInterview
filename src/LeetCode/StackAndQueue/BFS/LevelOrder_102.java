package LeetCode.StackAndQueue.BFS;

import LeetCode.StackAndQueue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null)
            return levels;

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
        return levels;

    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null)
            return list;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode node = null;
        q.offer(root);
        int len = q.size();

        while (!q.isEmpty()) {
            List<Integer> l = new LinkedList<>();
            while (len-- > 0) {//本质哈还是按照level利用queue的特性进行操作的。len表示当前层要操作多少个元素
                node = q.poll();
                l.add(node.val);
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            list.add(l);
            len = q.size();//更新下一层要操作元素的个数
        }

        return list;
    }


    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            result.add(temp.val);
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }
        return result;
    }

}
