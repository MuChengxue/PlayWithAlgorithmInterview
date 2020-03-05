package LeetCode.TreeAndRecursion;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree_226 {
    public TreeNode invertTree(TreeNode root) {//
        if (root == null)
            return root;

        //自底向上交换
        invertTree(root.left);//
        invertTree(root.right);//
        TreeNode tmp = root.left;//
        root.left = root.right;//
        root.right = tmp;

        return root;//
    }

    // 先序遍历--从顶向下交换
    public TreeNode invertTree2(TreeNode root) {//1
        if (root == null)
            return null;

        // 保存右子树
        TreeNode rightTree = root.right;//1-3
        // 交换左右子树的位置
        root.right = invertTree(root.left);//1-2
        root.left = invertTree(rightTree);
        return root;
    }

    // 中序遍历
    public TreeNode invertTree3(TreeNode root) {
        if (root == null)
            return null;

        invertTree(root.left); // 递归找到左节点
        TreeNode rightNode = root.right; // 保存右节点
        root.right = root.left;
        root.left = rightNode;
        // 递归找到右节点 继续交换 : 因为此时左右节点已经交换了,所以此时的右节点为root.left
        invertTree(root.left);
        return root;

    }

    // 后序遍历
    public TreeNode invertTree4(TreeNode root) {
        // 后序遍历-- 从下向上交换
        if (root == null)
            return null;

        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        root.right = leftNode;
        root.left = rightNode;
        return root;
    }

    // 层序遍历
    public TreeNode invertTree5(TreeNode root) {
        // 层次遍历--直接左右交换即可
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode rightTree = node.right;
            node.right = node.left;
            node.left = rightTree;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}
