package LeetCode.TreeAndRecursion;

public class LowestCommonAncestor_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if (p == null)
            return q;
        if (q == null)
            return p;

        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);

        return root;//1 pq分居root两侧  2 root就是p 3 root就是q
    }
}
