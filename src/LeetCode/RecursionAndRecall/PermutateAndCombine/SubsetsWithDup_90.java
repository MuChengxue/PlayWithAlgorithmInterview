package LeetCode.RecursionAndRecall.PermutateAndCombine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup_90 {
    //################################
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums == null || nums.length == 0)
            return res;

        Arrays.sort(nums);

        List<Integer> tmp = new ArrayList<>();
        tmp.add(nums[0]);
        res.add(tmp);
        if (nums.length == 1)
            return res;

        int lastLen = 1;
        for (int i = 1; i < nums.length; i++) {
            int size = res.size();
            if (nums[i] != nums[i - 1]) {
                lastLen = size;
            }

            for (int j = size - lastLen; j < size; j++) {
                List<Integer> inner = new ArrayList(res.get(j));
                inner.add(nums[i]);
                res.add(inner);
            }
        }

        return res;
    }

    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        res.clear();
        if (nums == null || nums.length == 0)
            return res;

        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return res;


    }

    public void backtrack(int[] nums, int index, List<Integer> tmp_list) {
        res.add(new ArrayList<>(tmp_list));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i - 1] == nums[i])
                continue;
            tmp_list.add(nums[i]);
            backtrack(nums, i + 1, tmp_list);
            tmp_list.remove(tmp_list.size() - 1);
        }
        return;
    }

}
