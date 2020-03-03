package LeetCode.StackAndQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preorderTraversal_144 {
    List resList = new ArrayList();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            resList.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }

        return resList;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
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
                if (command.node.right != null) {
                    stack.push(new Command("go", command.node.right));
                }
                if (command.node.left != null) {
                    stack.push(new Command("go", command.node.left));
                }
                stack.push(new Command("print", command.node));
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

    public  List<Integer> preOrderIteration3(TreeNode head) {
        List res=new ArrayList();
        if (head == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return res;
    }


}


