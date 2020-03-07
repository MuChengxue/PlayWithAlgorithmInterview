package LeetCode.RecursionAndRecall.PermutateAndCombine;

import java.util.ArrayList;
import java.util.List;

public class Combine_77 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        res.clear();
        if (n <= 0 || k <= 0 || k > n)
            return res;

        //1,2,3,4,```` ,n
        generateCombinations(n, k, 1, new ArrayList<>());

        return res;
    }

    //求解C(n,k)当前已经找到的组合存储在c中，需要从start开始搜索新的元素
    public void generateCombinations(int n, int k, int start, List<Integer> c) {
        if (c.size() == k) {
            res.add(new ArrayList<>(c));
            return;
        }

        //还有k-c.size()个空位，所以在[i ... n]中至少要有k-c.size()个元素供选择
        //i最多为n-(k-c.size())+1
        for (int i = start; i <= n - (k - c.size()) + 1; i++) {//###############剪枝######################
            c.add(i);
            generateCombinations(n, k, i + 1, c);//c中在这次递归之前已经有一个元素了，所以相当于从i+1 开始找C(n,k-1)
            c.remove(c.size() - 1);//回溯
        }

        return;
    }
}
