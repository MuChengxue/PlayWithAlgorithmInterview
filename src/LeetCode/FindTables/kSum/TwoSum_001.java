package LeetCode.FindTables.kSum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++){
            int tar=target-nums[i];
            if (map.containsKey(tar)&&map.get(tar)!=i)
                return new int[]{i,map.get(tar)};

        }
         return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            //在put之前先查找i之前是否有complement，有就返回没有再put
            //设想nums有两个2，target4，这样可以避免先put再查找会将两个2覆盖成一个2的情况
            map.put(nums[i], i);
        }

        return null;
    }
}
