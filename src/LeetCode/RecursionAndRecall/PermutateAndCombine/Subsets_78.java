package LeetCode.RecursionAndRecall.PermutateAndCombine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_78 {
    List<List<Integer>> res = new ArrayList<>();
    ///############################################################################################
    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new Subsets_78().subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        res.clear();
        if (nums.length == 0)
            return res;

        backtrack(nums, 0, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int[] nums, int i, List<Integer> tmp) {
        if (nums.length == i) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        tmp.add(nums[i]);
        backtrack(nums, i + 1, tmp);
        tmp.remove(tmp.size() - 1);
        backtrack(nums, i + 1, tmp);
    }

    //#############################################################################################
    public List<List<Integer>> subsets4(int[] nums) {
        res.clear();
        if (nums == null || nums.length == 0)
            return res;

        Arrays.sort(nums);
        backtrack2(nums, 0, new ArrayList<>());
        return res;

    }

    public void backtrack2(int[] nums, int index, List<Integer> tmp_list) {
        res.add(new ArrayList<>(tmp_list));

        for (int i = index; i < nums.length; i++) {
//            if (i > index && nums[i - 1] == nums[i])
//                continue;
            tmp_list.add(nums[i]);
            backtrack2(nums, i + 1, tmp_list);
            tmp_list.remove(tmp_list.size() - 1);
        }
        return;
    }

    public List<List<Integer>> subsets3(int[] nums) {
        int len = nums.length;
        for (int level = 0; level <= len; ++level) {
            backtrack2(nums, 0, level, new ArrayList<Integer>());
        }
        return result;
    }

    public void backtrack2(int[] nums, int first, int level, ArrayList<Integer> curr) {
        // if the combination is done
        if (curr.size() == level) {
            result.add(new ArrayList(curr));
            return;
        }

        for (int i = first; i < nums.length; ++i) {
            // add i into the current combination
            curr.add(nums[i]);
            // use next integers to complete the combination
            backtrack2(nums, i + 1, level, curr);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }

    //###############################################################
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums == null || nums.length == 0)
            return res;

//        System.out.println(res);
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
//                System.out.println(tmp+" "+i+" "+j);
                res.add(tmp);
//                System.out.println(res);
            }
//            System.out.println(res+"##"+i);
        }
        return res;
    }
}
