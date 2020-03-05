package LeetCode.TreeAndRecursion;

public class HasPathSum_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)//空的话 是找不到任何一个sum的
            return false;
        if (root.left == null && root.right == null)
            return root.val == sum;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
