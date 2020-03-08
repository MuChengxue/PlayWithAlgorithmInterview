package LeetCode.DP;

//    给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
public class IntegerBreak_343 {
    //状态：
//        考虑计算[1...n ]范围里的最大乘积，这是函数的定义
//        根据对状态的定义，决定状态的定义（状态转移方程）：
//        f(n)=max{1*(n-1),v(2)*f(n-2),v(3)*f(n-3), ... }
    //###########################################自上而下（记忆搜索）########################################
    public int integerBreak(int n) {
        if (n < 2)
            return -1;
        return breakinteger(n, new int[n + 1]);//memo[n]对应将n分割后的最大乘积结果
    }

    private int breakinteger(int n, int[] memo) {
        if (n == 1)
            return memo[1] = 0;
        if (memo[n] != 0)
            return memo[n];
        int res = 0;
        for (int i = 1; i <= n - 1; i++) {
            //i+(n-i)
            res = Math.max(Math.max(res, i * breakinteger(n - i, memo)), i * (n - i));
        }

        return memo[n] = res;
    }

    //###########################################自下而上 ########################################
    public int integerBreak2(int n) {
        if (n < 2)
            return 0;

        int[] memo = new int[n + 1];//memo[n]对应将n分割后的最大乘积结果
        memo[1] = 0;
        for (int i = 2; i <= n; i++) {
            //求解memo[i]
            for (int j = 1; j <= i - 1; j++) {
                //分成了j+(i-j)两部分.memo[i-j]必定存在是因为i-j肯定小于i
                memo[i] = Math.max(Math.max(j * (i - j), j * memo[i - j]), memo[i]);
            }
        }

        return memo[n];
    }
}
