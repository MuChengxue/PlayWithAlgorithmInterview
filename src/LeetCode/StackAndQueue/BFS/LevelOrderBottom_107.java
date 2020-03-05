package LeetCode.StackAndQueue.BFS;

import LeetCode.StackAndQueue.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom_107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        Collections.reverse(list);
        return list;
    }

}
