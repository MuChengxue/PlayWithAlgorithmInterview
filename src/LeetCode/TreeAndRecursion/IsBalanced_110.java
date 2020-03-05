package LeetCode.TreeAndRecursion;

public class IsBalanced_110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

//        //递归过程逻辑
//        int leftMax=maxDepth(root.left);//左子树高度
//        int rightMax=maxDepth(root.right);//右子树高度
//        return Math.max(leftMax,rightMax)+1;//加上root
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
