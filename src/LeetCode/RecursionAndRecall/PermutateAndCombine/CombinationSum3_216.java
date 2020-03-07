package LeetCode.RecursionAndRecall.PermutateAndCombine;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/combination-sum-iii/solution/hui-su-jian-zhi-by-liweiwei1419/
public class CombinationSum3_216 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        res.clear();
        // 寻找 n 的上限：[9, 8, ... , (9 - k + 1)]，它们的和为 (19 - k) * k / 2,比上限还大，就不用搜索了
        //找不到k个合为k的，除非k个1，但是因为不能重复
        if (n <= 0 || k <= 0 || k >= n || (19 - k) * k / 2 < n)
            return res;

        dfs(new ArrayList<Integer>(), k, n, 1);
        return res;
    }

    public void dfs(List<Integer> list, int k, int n, int start) {

        if (n == 0 && k == 0) {//此时list.size()正好是第一次进dfs时的k
            res.add(new ArrayList<>(list));
            return;
        }

        // 剪枝：[start, 9] 这个区间里的数都不够 k 个，不用继续往下搜索
        if (10 - start < k)
            return;

        // 剪枝：从start开始找k个合为n的，start,start+1, ... start+k-1的和为(2 * start + k - 1) * k / 2
        if ((2 * start + k - 1) * k / 2 > n) {
            return;
        }

//        if (n <= 0 || k <= 0)
//            return;

        // 枚举起点值 [..., 7, 8, 9]
        // 找 3 个数，起点最多到 7
        // 找 2 个数，起点最多到 8
        // 规律是，起点上界 + k = 10，故起点上界 = 10 - k
        for (int i = start; i <= 10 - k; i++) {
            // 剪枝：如果下轮要找的n小于0，不存在
            if (n - i < 0) {//也可以不在这里剪，在if (n <= 0 || k <= 0)见会让代码看起来更优雅吧
                break;
            }

            list.add(i);//显然k和list.size()有关，一个增一个减，同步进行
            dfs(list, k - 1, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }

    //###############################################################################################
    public List<List<Integer>> combinationSum3_2(int k, int n) {
        dfs2(new ArrayList<Integer>(), k, n, 9);
        return res;
    }

    public void dfs2(List<Integer> temp, int k, int n, int end) {
        if (n == 0 && k == 0) {
            res.add(new ArrayList(temp));
            return;
        }
        if (n <= 0 || k <= 0)
            return;

        for (int i = end; i > 0; i--) {
            temp.add(i);
            dfs2(temp, k - 1, n - i, i - 1);
            temp.remove(temp.size() - 1);
        }
    }
}
