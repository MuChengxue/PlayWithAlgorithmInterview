package LeetCode.Arrays.Binary;

/**
 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。

 示例: 

 输入: s = 7, nums = [2,3,1,2,4,3]
 输出: 2
 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 */

public class MinSubArrayLen_209 {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {//至此，sums就是递增的了  可以二分查找
            sums[i] = nums[i] + sums[i - 1];
        }

        for (int i = 0; i < n; i++) {
            int s2 = s - nums[i];
            //二分查找，目标值是 s2 + sums[i]
            //从第 i 个数字开始，总和大于等于 s 时的长度，我们只需要找从第 i + 1 个数字到第几个数字的和大于等于s2= s - nums[i] 即可。
            int k = binarySearch(i, n - 1, sums, s2 + sums[i]);
            if (k != -1) {
                min = Math.min(min, k - i + 1);
            }

        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    //寻求刚好大于 target 的 sums 的下标，也就是大于等于 target 所有 sums 中最小的那个
    private int binarySearch(int start, int end, int[] sums, int target) {
        int mid = -1;
        while (start <= end) {
            mid = (start + end) >>> 1;
            if (sums[mid] == target) {
                return mid;
            } else if (sums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        //是否找到，没有找到返回 -1
        return sums[mid] > target ? mid : -1;
    }


    public static void main(String[] args) {
        System.out.println(new MinSubArrayLen_209().minSubArrayLen(9,new int[]{8,2,2,3,2,1,2,4,3,6,1}));
    }

}
