package LeetCode.StackAndQueue.DFS;

import LeetCode.StackAndQueue.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preorderTraversal_144_2 {

//    public List<Integer> preorderTraversal2(TreeNode root) {
//        List res = new ArrayList();
//        if (root == null)
//            return res;
//
//        Stack<Command> stack = new Stack<>();
//        stack.push(new Command("go", root));
//        while (!stack.isEmpty()) {
//            Command command = stack.pop();
//
//            if (command.cmd == "print") {
//                res.add(command.node.val);
//            } else {//go
//                if (command.node.right != null) {
//                    stack.push(new Command("go", command.node.right));
//                }
//                if (command.node.left != null) {
//                    stack.push(new Command("go", command.node.left));
//                }
//                stack.push(new Command("print", command.node));
//            }
//        }
//
//        return res;
//    }

//    class Command {
//        String cmd;
//        TreeNode node;
//
//        public Command(String cmd, TreeNode node) {
//            this.cmd = cmd;
//            this.node = node;
//        }
//    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List res = new ArrayList();
        if (root == null)
            return res;

        Stack<Commad> stack = new Stack();
        stack.push(new Commad("go", root));
        while (!stack.isEmpty()) {
            Commad command = stack.pop();
            if (command.cmd == "print") {
                res.add(command.node.val);
            } else {//go
                if (command.node.right != null)
                    stack.push(new Commad("go", command.node.right));
                if (command.node.left != null)
                    stack.push(new Commad("go", command.node.left));
                stack.push(new Commad("print", command.node));
            }

        }

        return res;
    }

    class Commad {
        String cmd;//go print
        TreeNode node;

        public Commad(String cmd, TreeNode node) {
            this.cmd = cmd;
            this.node = node;
        }
    }

}


