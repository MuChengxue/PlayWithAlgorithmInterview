package LeetCode.TreeAndRecursion;

public class KthSmallest_230 {
    int cnt = 0;
    int res = 0;

    /**
     * 查找左子树节点个数为leftN,如果K<=leftN,则所查找节点在左子树上.
     * 若K=leftN+1,则所查找节点为根节点
     * 若K>leftN+1,则所查找节点在右子树上,按照同样方法查找右子树第K-leftN个节点
     */
    public int kthSmallest(TreeNode root, int k) {
        int leftN = countChild(root.left);
        if (leftN + 1 == k) {
            return root.val;
        } else if (k <= leftN) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - leftN - 1);
        }
    }

    /**
     * 查找左子树节点个数
     */
    public int countChild(TreeNode root) {
        if (root == null)
            return 0;
        return countChild(root.left) + countChild(root.right) + 1;
    }

    //#######################################################################################
    public int kthSmallest2(TreeNode root, int k) {

        inorder(root, k);
        return res;
    }

    public void inorder(TreeNode root, int k) {
        if (root == null)
            return;

        inorder(root.left, k);
        if (++cnt == k) {
            res = root.val;
            return;
        }
        inorder(root.right, k);
    }

}
