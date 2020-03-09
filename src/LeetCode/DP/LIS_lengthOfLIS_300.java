package LeetCode.DP;

import java.util.Arrays;

public class LIS_lengthOfLIS_300 {
//    LIS(i)表示第i个数字为结尾的最长上升子序列的长度
//    即[0,i]范围内，选择数字nums[i]可以获得的最长上升子序列的长度。一定要使用右边界i
//    状态转移方程：LIS(i)=max(1+LIS(j) if nums[i] > nums[j])(i>j)

    //###########################################二分 nlogn#############################
    int l = 0;
    //###########################################自上而下（记忆搜索）#############################
    private int[] memo;

    public static void main(String[] args) {
        int[] data = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
//        System.out.println(new lengthOfLIS_300().lengthOfLIS (data));
        System.out.println(new LIS_lengthOfLIS_300().lengthOfLIS3(data));
    }

    //###########################################自下而上（动态规划）########################################
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 1)
            return 0;

        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);

//        int res=1;
        for (int i = 1; i < nums.length; i++) {//O(n^2)
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
            }
//            res=Math.max(res,memo[i]);
        }
        int res = 1;
        for (int i = 0; i < memo.length; i++) {
            res = Math.max(res, memo[i]);
        }

        return res;
    }

    //###########################################自上而下（记忆搜索  没有AC?????????????）#############################
    public int lengthOfLIS2(int[] nums) {
        if (nums.length < 1)
            return 0;

        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        calLIS(nums, nums.length - 1, memo);

        int res = 1;
        for (int i = 0; i < memo.length; i++) {
            res = Math.max(res, memo[i]);
        }
        return res;
    }

    private int calLIS(int[] nums, int index, int[] memo) {

//        if (index == 0)
//            return memo[index] = 1;

        if (memo[index] != -1)
            return memo[index];
        int res = 1;
        for (int i = 0; i <= index; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    res = Math.max(res, 1 + calLIS(nums, j, memo));
            }

        }

        return memo[index] = res;
    }

    public int lengthOfLIS3(int[] nums) {

        if (nums.length == 0)
            return 0;

        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int res = 1;
        for (int i = 0; i < nums.length; i++)
            res = Math.max(res, getMaxLength(nums, i));

        return res;
    }

    // 以 nums[index] 为结尾的最长上升子序列的长度
    private int getMaxLength(int[] nums, int index) {

        if (memo[index] != -1)
            return memo[index];

        int res = 1;
        for (int i = 0; i <= index - 1; i++)
            if (nums[index] > nums[i])
                res = Math.max(res, 1 + getMaxLength(nums, i));

        return memo[index] = res;
    }

    public int lengthOfLIS4(int[] nums) {
        int[] tails = new int[nums.length];
        int len = 0;
        for (int j = 0; j < nums.length; j++) {
            int l = 0;
            int r = len;
            while (l < r) {
                int mid = (r - l) / 2 + l;
                if (nums[j] > tails[mid])
                    l = mid + 1;
                else if (nums[j] <= tails[mid])
                    r = mid;
            }
            if (l == len)
                len++;
            // 把这张牌放到牌堆顶
            tails[l] = nums[j];
        }
        return len;

    }

    public int lengthOfLIS5(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);//Arrays.binarySearch() 方法返回搜索键的索引，如果它包含在数组中，则返回(否则（插入点）-1）
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }


}
