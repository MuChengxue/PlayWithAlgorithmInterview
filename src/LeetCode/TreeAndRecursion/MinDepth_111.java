package LeetCode.TreeAndRecursion;

public class MinDepth_111 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);

        //1.如果左孩子和右孩子有为空的情况，直接返回m1+m2+1
        //也就是说当 root节点左右孩子有一个为空时，返回不为空的孩子节点的深度
        //2.如果都不为空，返回较小深度+1
        return root.left == null || root.right == null ? m1 + m2 + 1 : Math.min(m1, m2) + 1;
    }

}
