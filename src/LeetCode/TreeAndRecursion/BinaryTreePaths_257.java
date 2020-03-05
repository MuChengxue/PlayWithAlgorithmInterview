package LeetCode.TreeAndRecursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths_257 {
    //###############################################################################################
    List<String> ans = new ArrayList<>();
    StringBuilder builder = new StringBuilder();

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }

        List<String> left = binaryTreePaths(root.left);
        for (String l : left)
            res.add(root.val + "->" + l);
        List<String> right = binaryTreePaths(root.right);
        for (String r : right)
            res.add(root.val + "->" + r);

        return res;

    }

    public List<String> binaryTreePaths2(TreeNode root) {
        if (root == null)
            return ans;
        if (root.left == null && root.right == null) {//叶子结点
            ans.add(String.valueOf(root.val));
            return ans;
        }

        builder.append(root.val);
        helper(root.left);
        helper(root.right);
        return ans;
    }

    public void helper(TreeNode root) {
        if (root == null)
            return;
        int oldLength = builder.length();
        builder.append("->").append(root.val);
        if (root.left == null && root.right == null) {
            ans.add(builder.toString());
        } else {
            helper(root.left);
            helper(root.right);
        }
        builder.delete(oldLength, builder.length());
    }

    //############################################################################################
    public List<String> binaryTreePaths3(TreeNode root) {
        LinkedList<String> allPaths = new LinkedList<>();
        paths(root, "", allPaths);
        return allPaths;

    }

    private void paths(TreeNode root, String path, LinkedList<String> Allpaths) {
        if (root == null)
            return;
        path += Integer.toString(root.val);
        if (root.left == null && root.right == null) {
            Allpaths.add(path);
        } else {
            path += "->";
            paths(root.left, path, Allpaths);
            paths(root.right, path, Allpaths);
        }

    }
}
