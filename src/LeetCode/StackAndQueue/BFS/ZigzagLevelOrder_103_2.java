package LeetCode.StackAndQueue.BFS;

import LeetCode.StackAndQueue.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigzagLevelOrder_103_2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack0 = new Stack<TreeNode>();
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode>[] stacks = new Stack[]{stack0, stack1};

        ArrayList<Integer> list = new ArrayList();
        int current = 0;//奇偶层指示 当前层是奇数层
        int next = 1;//奇偶层指示 下一层是偶数层  两个指示没必要，用一个指示就可以了
        int i = 0;//第几层，指示result中的下标索引

        stacks[current].push(root);
        while (!stacks[current].empty() || !stacks[next].empty()) {
            TreeNode printNode = stacks[current].peek();
            stacks[current].pop();
            list.add(printNode.val);

            if (current == 0) {//奇数层
                if (printNode.left != null) {
                    stacks[next].push(printNode.left);
                }
                if (printNode.right != null) {
                    stacks[next].push(printNode.right);
                }
            } else {
                if (printNode.right != null) {
                    stacks[next].push(printNode.right);
                }
                if (printNode.left != null) {
                    stacks[next].push(printNode.left);
                }
            }

            if (stacks[current].empty()) {
                result.add(i, list);
                list = new ArrayList();//这点注意清空
                i++;
                current = 1 - current;
                next = 1 - next;
            }
        }

        return result;
    }
}
