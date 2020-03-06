package LeetCode.RecursionAndRecall;

import java.util.ArrayList;
import java.util.List;

public class Permute_46 {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;

    public static void main(String[] args) {
        System.out.println(new Permute_46().permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        res.clear();
        if (nums.length == 0)
            return res;

        used = new boolean[nums.length];
        generatePermutation(nums, 0, new ArrayList<Integer>());
        return res;
    }

    //p中保存了一个有index个元素的排列。
    //向这个排列的末尾添加第index+1个元素，获得一个有index+1个元素的排列
    private void generatePermutation(int[] nums, int index, List<Integer> p) {
        if (index == nums.length) {//此时
            res.add(new ArrayList<>(p));
            System.out.println(res);

            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {//没有使用
                p.add(nums[i]);
                System.out.println("p" + p);
                used[i] = true;
                generatePermutation(nums, index + 1, p);
                p.remove(p.size() - 1);//回复
                used[i] = false;
            }
        }

        return;
    }
}
