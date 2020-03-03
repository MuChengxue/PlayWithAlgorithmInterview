package LeetCode.FindTables.kSum;

import java.util.Arrays;

public class ThreeSumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {
        // 最左侧值为定值，右侧所有值进行两边推进计算
        if (nums.length < 3)
            return 0;

        int len=nums.length;
        Arrays.sort(nums);
        int result = nums[len-1]+nums[len-2]+nums[len-3];
        int size = nums.length;
        for (int i = 0; i <= size - 1; i++) {
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }//去重：如果挨着的两个数相等，上一轮的结果和这一轮，或者是一样的或者这一轮。总之没必要再处理

            int first = i + 1;
            int last = size - 1;
            while (first < last) {
                int sum = nums[i] + nums[first] + nums[last];
                if (Math.abs(sum - target) <= Math.abs(result - target)) {
                    result = sum;
                }

                if (sum > target) {
                    while (nums[last] == nums[--last] && first < last) {}
                } else if (sum <target){
                    while (nums[first] == nums[++first] && first < last) {}
                }else {
                    return sum;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumClosest_16().threeSumClosest(new int[]{-3,-2,-5,3,-4}, -1));
    }
}
