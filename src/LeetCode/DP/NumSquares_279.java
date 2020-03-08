package LeetCode.DP;

import java.util.Arrays;

public class NumSquares_279 {
    public static void main(String[] args) {
        System.out.println(new NumSquares_279().numSquares2(12));
    }

    //###########################################自下而上########################################
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; //n+1大小，f[0]为0
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;//很重要
        for (int i = 1; i <= n; i++) {//从f[1]开始计算
            for (int j = 1; j * j <= i; j++)
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
        }
        return dp[n];
    }

    //###########################################自上而下(记忆搜索)########################################
    public int numSquares2(int n) {
        return calculate(n, new int[n + 1]);
    }

    public int calculate(int n, int[] memo) {
        if (n == 0)
            return 0;

        if (memo[n] != 0)
            return memo[n];
        int res = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            res = Math.min(res, calculate(n - i * i, memo) + 1);
        }

        return memo[n] = res;
    }

}
