package LeetCode.TreeAndRecursion;

public class DeleteNode_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;   // Item not found; do nothing

        int compareResult = key - root.val;

        if (compareResult < 0)
            root.left = remove(key, root.left);
        else if (compareResult > 0)
            root.right = remove(key, root.right);
        else if (root.left != null && root.right != null) // have Two children
        {
            root.val = findMin(root.right).val;//找到右边最小的元素填充进被删除的位置
            root.right = remove(root.val, root.right);//在右边删除被提上来的元素
        } else
            root = (root.left != null) ? root.left : root.right;
        return root;
    }

    private TreeNode findMin(TreeNode t) {
        if (t == null)
            return null;
        else if (t.left == null)
            return t;
        return findMin(t.left);
    }

    private TreeNode remove(int x, TreeNode t) {
        if (t == null)
            return t;   // Item not found; do nothing

        int compareResult = x - t.val;

        if (compareResult < 0)
            t.left = remove(x, t.left);
        else if (compareResult > 0)
            t.right = remove(x, t.right);
        else if (t.left != null && t.right != null) // have Two children
        {
            t.val = findMin(t.right).val;//找到右边最小的元素填充进被删除的位置
            t.right = remove(t.val, t.right);//在右边删除被提上来的元素
        } else
            t = (t.left != null) ? t.left : t.right;
        return t;
    }
}
