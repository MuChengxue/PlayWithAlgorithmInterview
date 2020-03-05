package LeetCode.StackAndQueue.DFS;

import LeetCode.StackAndQueue.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal_145_2 {


    public List<Integer> postorderTraversal(TreeNode root) {
        List res = new ArrayList();
        if (root == null)
            return res;

        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while (!stack.isEmpty()) {
            Command command = stack.pop();

            if (command.cmd == "print") {
                res.add(command.node.val);
            } else {//go
                stack.push(new Command("print", command.node));
                if (command.node.right != null) {
                    stack.push(new Command("go", command.node.right));
                }
                if (command.node.left != null) {
                    stack.push(new Command("go", command.node.left));
                }
            }
        }

        return res;
    }

    class Command {
        String cmd;
        TreeNode node;

        public Command(String cmd, TreeNode node) {
            this.cmd = cmd;
            this.node = node;
        }
    }
}
