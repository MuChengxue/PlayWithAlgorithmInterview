package LeetCode.StackAndQueue.stack;

import LeetCode.StackAndQueue.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigzagLevelOrder_103_5 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> evenLevel = new Stack<>();//记录偶数层的节点栈
        Stack<TreeNode> oddLevel = new Stack<>();//记录奇数层的节点栈
        evenLevel.push(root);
        for (int i = 0; !evenLevel.isEmpty() || !oddLevel.isEmpty(); i++) {
            List<Integer> cur = new ArrayList<Integer>();
            if ((i & 1) == 0) {
                // 偶数层,从0开始
                while (!evenLevel.isEmpty()) {
                    TreeNode pop = evenLevel.pop();
                    if (pop != null) {
                        cur.add(pop.val);
                        // 左子树先入栈，因为下一层（奇数层）访问顺序是:右节点->左节点
                        // 根据栈的FILO,左节点先入栈
                        oddLevel.push(pop.left);
                        oddLevel.push(pop.right);
                    }
                }
            } else {
                // 奇数层
                while (!oddLevel.isEmpty()) {
                    TreeNode pop = oddLevel.pop();
                    if (pop != null) {
                        cur.add(pop.val);
                        // 右子树先入栈，因为下一层（偶数层）访问顺序是:左节点->右节点
                        evenLevel.push(pop.right);
                        evenLevel.push(pop.left);
                    }
                }
            }
            if (!cur.isEmpty()) {
                res.add(cur);
            }
        }
        return res;
    }


}
