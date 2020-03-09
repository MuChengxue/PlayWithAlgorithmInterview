package LeetCode.DP;

public class CanPartition_416 {
    //###########################################自上而下（记忆搜索_n个物品填充sum/2容量的01背包）#############################
    //memo[i][c]表示使用索引为[0 ... i]的这些元素，是否可以完全填充一个容量为c的背包
    //0表示未计算，-1表示不可以填充，1表示可以填充

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums)
            sum += i;

        if (sum % 2 != 0)
            return false;

        int[][] memo = new int[nums.length][sum / 2 + 1];
        return tryPartition(nums, nums.length - 1, sum / 2, memo);
    }

    //使用nums[o ... index]，是否可以完全填充一个容量为sum的背包
    //(index,sum)会重复
    private boolean tryPartition(int[] nums, int index, int sum, int[][] memo) {
        if (sum == 0)
            return true;

        if (sum < 0 || index < 0)
            return false;

        if (memo[index][sum] != 0)
            return memo[index][sum] == 1;
        memo[index][sum] = (tryPartition(nums, index - 1, sum, memo) || tryPartition(nums, index - 1, sum - nums[index], memo))
                ? 1 : -1;
        return memo[index][sum] == 1;

    }

    //###########################################自下而上（记忆搜索_n个物品填充sum/2容量的背包）#############################
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i : nums)
            sum += i;

        if (sum % 2 != 0)
            return false;

        int n = nums.length;
        int C = sum / 2;
        boolean[] memo = new boolean[C + 1];
        for (int i = 0; i <= C; i++)
            memo[i] = (nums[0] == i);

        for (int i = 1; i < n; i++) {
            for (int j = C; j >= nums[i]; j--)//如果nums[i]>j了说明，当前物品放不进背包里了超重，提前终止
                memo[j] = (memo[j] || memo[j - nums[i]]);

        }
        return memo[C];
    }
}
