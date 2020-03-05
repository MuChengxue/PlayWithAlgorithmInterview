package LeetCode.TreeAndRecursion;

import javafx.util.Pair;

import java.util.LinkedList;

public class SumOfLeftLeaves_404 {
    //######################################################################################
    //逻辑清晰
    int res = 0;

    public int sumOfTrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leave = root.val;
        int left = sumOfTrees(root.left);
        int right = sumOfTrees(root.right);
        return left + right + leave;
    }

    //#############################################################################################
    public int sumOfLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leave = 0;
        // 叶子节点
        if (root.left == null && root.right == null) {
            leave = root.val;
        }
        int left = sumOfLeaves(root.left);
        int right = sumOfLeaves(root.right);
        return left + right + leave;
    }

    //######################################################################################
    //逻辑清晰
    public int sumOfLeftLeaves3(TreeNode root) {
        return sumOfLeftLeavesHelper(root, false);
    }

    // 先序遍历求所有左叶子节点值之和
    public int sumOfLeftLeavesHelper(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }
        int leave = 0;
        // 左叶子节点
        if (flag && root.left == null && root.right == null) {
            leave = root.val;
        }
        int left = sumOfLeftLeavesHelper(root.left, true);
        int right = sumOfLeftLeavesHelper(root.right, false);
        return left + right + leave;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        getSum(root, false);
        return res;
    }

    private void getSum(TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        }

        if (isLeft && root.left == null && root.right == null) {//左右孩子为空就是叶子结点，还要是left
            res += root.val;
        } else {
            getSum(root.left, true);
            getSum(root.right, false);
        }

    }

    //######################################################################################
    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left != null && root.left.right == null && root.left.left == null)
            return sumOfLeftLeaves2(root.right) + root.left.val;
        return sumOfLeftLeaves2(root.left) + sumOfLeftLeaves2(root.right);
    }

    //####################################################################################
    public int sumOfLeftLeaves4(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<Pair<TreeNode, Boolean>> stack = new LinkedList<>();
        stack.push(new Pair<>(root, false));

        int sum = 0;
        Boolean flag;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Boolean> pair = stack.pop();
            root = pair.getKey();
            flag = pair.getValue();
            if (flag && root.left == null && root.right == null) {
                sum += root.val;
            }
            if (root.left != null) {
                stack.push(new Pair<>(root.left, true));
            }
            if (root.right != null) {
                stack.push(new Pair<>(root.right, false));
            }
        }
        return sum;
    }


}
