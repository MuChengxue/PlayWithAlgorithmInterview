package LeetCode.DP;

//状态：
//        考虑偷取[x...n-1]范围里的房子，这是函数的定义
//        根据对状态的定义，决定状态的定义（状态转移方程）：
//        f(0)=max{v(0)+f(2),v(1)+f(3),v(2)+f(4), ... v(n-3)+f(n-1),v(n-2),v(n-1)}
public class Rob_198 {
    //###########################################抢劫[x,n-1]########################################
    //###########################################自上而下（记忆搜索）########################################
    public int rob(int[] nums) {
        int[] memo = new int[nums.length + 1];
        for (int i = 0; i < memo.length; i++)
            memo[i] = -1;
        return tryRob(nums, 0, memo);
    }

    //    考虑rob[x...n-1]范围里的房子
    private int tryRob(int[] nums, int index, int[] memo) {
        if (index >= nums.length)
            return 0;

        if (memo[index] != -1)
            return memo[index];

        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + tryRob(nums, i + 2, memo));
        }

        return memo[index] = res;
    }

    //###########################################自下而上 ########################################
    public int rob2(int[] nums) {
        int n = nums.length;
        if (nums.length < 1)
            return 0;
        int[] memo = new int[n];//memo[n]对应考虑抢劫[i,n-1]所能获得的最大收益
        for (int i = 0; i < memo.length; i++)
            memo[i] = -1;
        memo[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            //求解memo[i]

            memo[i] = Math.max(nums[i] + (i + 2 >= n ? 0 : memo[i + 2]),//偷不偷第i家呢
                    nums[i + 1] + (i + 3 >= n ? 0 : memo[i + 3]));

//            for (int j=i;j<n;j++){
//                memo[i]=Math.max( memo[i], nums[j]+(j+2<n?memo[j+2]:0));
//            }
        }

        return memo[0];
    }

    //###########################################抢劫[0,x]########################################
    //###########################################自下而上（动态规划）########################################
    // 考虑rob[0...x]范围里的房子
    public int rob3(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return n == 0 ? 0 : nums[0];

        int[] memo = new int[n];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++)
            memo[i] = Math.max(memo[i - 1], nums[i] + memo[i - 2]);
        return memo[n - 1];
    }

    public int rob4(int[] nums) {
        int prev = 0;
        int curr = 0;

        // 每次循环，计算“偷到当前房子为止的最大金额”
        for (int i : nums) {
            // 循环开始时，curr 表示 dp[k-1]，prev 表示 dp[k-2]
            // dp[k] = max{ dp[k-1], dp[k-2] + i }
            int temp = Math.max(curr, prev + i);
            prev = curr;
            curr = temp;
            // 循环结束时，curr 表示 dp[k]，prev 表示 dp[k-1]
        }

        return curr;
    }

    //###########################################自上而下（记忆搜索）########################################
    public int rob5(int[] nums) {
        int n = nums.length;
        if (n < 1)
            return 0;
        int[] memo = new int[n];
        for (int i = 0; i < n; i++)
            memo[i] = -1;
        memo[0] = nums[0];
        return tryRob5(nums, n - 1, memo);
    }

    //    考虑rob[0...x]范围里的房子
    private int tryRob5(int[] nums, int index, int[] memo) {
        if (index < 0)
            return 0;

        if (memo[index] != -1)
            return memo[index];

        int res = 0;
        for (int i = 0; i <= index; i++) {
            res = Math.max(res, nums[i] + tryRob5(nums, i - 2, memo));
        }

        return memo[index] = res;
    }


}
