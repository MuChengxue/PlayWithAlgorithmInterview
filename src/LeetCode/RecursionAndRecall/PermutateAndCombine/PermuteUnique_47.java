package LeetCode.RecursionAndRecall.PermutateAndCombine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//题解
//https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/


public class PermuteUnique_47 {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res.clear();
        int len = nums.length;
        if (nums.length == 0) {
            return res;
        }

        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);

        used = new boolean[len];

        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> path) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (used[i]) {//使用过
                continue;
            }

            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {//去除重复的元素。used[i - 1]也可以，好像也更容易理解
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            dfs(nums, index + 1, path);//递归
            // 回溯部分的代码，和 dfs 之前的代码是对称的
            used[i] = false;
            path.remove(path.size() - 1);
        }

        return;
    }


}
