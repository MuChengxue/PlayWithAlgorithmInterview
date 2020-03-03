package LeetCode.FindTables.kSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3)
            return result;

        int n_size = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n_size - 3; i++) {
            // 不存在
            if (target <= 0 && nums[i] > 0)
                break;
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                break;
            // 此时条件不满足
            if (nums[i] + nums[n_size - 3] + nums[n_size - 2] + nums[n_size - 1] < target)
                continue;
            // 重复项
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < n_size - 2; j++) {
                // 不存在
                if (target - nums[i] <= 0 && nums[j] > 0)
                    break;
                // 不存在
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target)
                    break;
                // 此时条件不满足
                if (nums[i] + nums[j] + nums[n_size - 2] + nums[n_size - 1] < target)
                    continue;
                // 重复项
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int start = j + 1, end = n_size - 1;
                while (start < end) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum < target) {
                        while (nums[start] == nums[++start] && start < end) { }
                    } else if (sum > target) {
                        while (nums[end] == nums[--end] && start < end) { }
                    } else {
                        ArrayList list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        result.add(list);
                        int last_start = start, last_end = end;
                        // 剔除重复项
                        while (start < end && nums[start] == nums[++start]) { }
                        while (start < end && nums[end] == nums[--end]) { }
                    }
                }
            }
        }
        return result;
    }
}
