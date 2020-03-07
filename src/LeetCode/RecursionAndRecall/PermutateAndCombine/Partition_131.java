package LeetCode.RecursionAndRecall.PermutateAndCombine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Partition_131 {

    List<List<String>> res = new ArrayList<>();
    boolean[][] dp;

    public List<List<String>> partition(String s) {
        int len = s.length();
        if (len < 1)
            return res;

        // dp[i][j] 表示某一子串,s.substring(i, j +1) 左闭右开
        // 例如 s="babad",dp[0][0] = "b",dp[0][4] = "babad"
        dp = new boolean[len][len];
        dqPreProcess(dp, s);

        //回溯法,穿串串
        combination(s, new LinkedList<>(), 0);
        return res;
    }

    private void combination(String s, List<String> path, int index) {
        if (index >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            //相当于不符合就continue进行了剪枝
            if (dp[index][i]) {//###################### 剪 枝 ######################
                path.add(s.substring(index, i + 1));
                combination(s, path, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    //根据ij的定义只用到了上三角区域。一半有意义另一半就没有意义
    //dp[i][j] i<=j才有意义
    private void dqPreProcess(boolean[][] dp, String s) {
        int len = s.length();
        // one character
        // 斜着遍历 [0,0] -> [1,1] -> ...
        // 单个字符均为回文
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        // two character
        // 斜着遍历 [0,1] -> [1,2] -> ...
        // 两个字符均相同才是回文
        for (int i = 0; i < len - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        // others
        // 开始dp,  此子串 = 字符 + 左下角的子串 + 字符
        // 只有左下角是回文,同时两端添加的字符相同时,才是回文
        for (int i = 2; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                dp[j][j + i] = dp[j + 1][j + i - 1] && s.charAt(j) == s.charAt(j + i);
            }
        }
    }

    //###################################################################################################
    private void dqPreProcess2(boolean[][] dp, String s) {
        int len = s.length();
//         预处理
//         状态：dp[i][j] 表示 s[i][j] 是否是回文
//        boolean[][] dp = new boolean[len][len];

        // 状态转移方程：在 s[i] == s[j] 的时候，dp[i][j] 参考 dp[i + 1][j - 1]
        for (int j = 0; j < len; j++) {
            // 注意：left <= right 取等号表示 1 个字符的时候也需要判断
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }

        //这个过程显然可以简化，对角线上的必然是true不用比较，参考dqPreProcess

    }
}
