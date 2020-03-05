package LeetCode.TreeAndRecursion;

public class PathSum_437 {
    //###################################################################################
    int pathnumber;

    //在以root为根节点的二叉树中，寻找和为sum的路径（广义），返回这样的路径个数
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;

        int res = findPath(root, sum);//包含这个节点其和为sum
        res += pathSum(root.left, sum);//在左子树中不包含其和为sum
        res += pathSum(root.right, sum);//在右子树中不包含其和为sum

        return res;
    }

    //在以node为根节点的二叉树中，寻找包含node的路径，和为sum
    //返回这样的路径个数
    private int findPath(TreeNode root, int sum) {
        if (root == null)
            return 0;

        int res = 0;
        if (root.val == sum)
            res++;
        res += findPath(root.left, sum - root.val);//可可能后边经过正负两个数有等于sum了
        res += findPath(root.right, sum - root.val);

        return res;
    }

    public int pathSum2(TreeNode root, int sum) {
        if (root == null)
            return 0;

        Sum(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return pathnumber;
    }

    public void Sum(TreeNode root, int sum) {
        if (root == null)
            return;

        sum -= root.val;
        if (sum == 0) {
            pathnumber++;
        }
        Sum(root.left, sum);
        Sum(root.right, sum);
    }
}
