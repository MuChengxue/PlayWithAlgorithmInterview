package LeetCode.RecursionAndRecall.PermutateAndCombine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res.clear();
        Arrays.sort(candidates);
        if (candidates.length < 1)
            return res;
        if (target < candidates[0])
            return res;

        backtrack(candidates, 0, target, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int[] candidates, int index, int target, ArrayList<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int start = index; start < candidates.length; start++) {
            if (target < candidates[start])
                break;//continue的话就做了没必要的查找
            //System.out.println(start);
            list.add(candidates[start]);
            //System.out.println(tmp_list);
            backtrack(candidates, start, target - candidates[start], list);
            list.remove(list.size() - 1);
        }
    }
}
