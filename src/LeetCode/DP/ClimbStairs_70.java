package LeetCode.DP;

public class ClimbStairs_70 {
    //###########################################自下而上########################################
    public int climbStairs(int n) {
        // int[] res = new int[n + 1];
        if (n <= 3)
            return n;
        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];
    }

    //###########################################自上而下（有重叠）########################################
    public int climbStairs2(int n) {
        if (n <= 3)
            return n;

//        if (n ==1||n==0)//这样结束也是可以的
//            return 1;

        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }

    //###########################################自上而下（记忆搜索）########################################
    public int climbStairs3(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        return help(n, memo);
    }

    private int help(int n, int[] memo) {
        if (memo[n] == 0)
            memo[n] = help(n - 1, memo) + help(n - 2, memo);

        return memo[n];
    }
}
