package LeetCode.FindTables.kSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        // 最左侧值为定值，右侧所有值进行两边推进计算
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length<3)
            return res;
        Arrays.sort(nums);
        int size = nums.length;
        if (nums[0] <= 0 && nums[size - 1] >= 0) {
            // 保证有正数负数

            for (int i = 0;i <= size -1;i++) {
                if (nums[i] > 0)
                    return res; // 最左侧大于0，无解
                if(i > 0 && nums[i] == nums[i-1]) //去重
                    continue;

                int first = i + 1;
                int last = size - 1;
                while (first < last) {
                    int sum = nums[i] + nums[first] + nums[last];
                    if (sum == 0) {
                        ArrayList list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[first]);
                        list.add(nums[last]);
                        res.add(list);
                        while (nums[first] == nums[++first] && first < last) {
                        }
                        while (nums[last] == nums[--last] && first < last) {
                        }
                    }else if (sum <  0) {
                        // 负数过小，first右移
                        while (nums[first] == nums[++first] && first < last) {
                        } // 重复值跳过
                    } else {
                        while (nums[last] == nums[--last] && first < last) {
                        } // 重复值跳过
                    }
                }

            }
        }

        return res;

    }

    //改着改着这俩方法一样了
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int len = nums.length;
        if (len<3)
            return lists;
        //排序
        Arrays.sort(nums);
        //双指针
        for(int i = 0;i < len;++i) {
            if(nums[i] > 0)
                return lists;

            if(i > 0 && nums[i] == nums[i-1]) //去重
                continue;

            int curr = nums[i];
            int L = i+1, R = len-1;
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if(tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);

                    while (nums[L] == nums[++L] && L < R) {}//去重
                    while (nums[R] == nums[--R] && L < R) {}

                } else if(tmp < 0) {
                    while (nums[L] == nums[++L] && L < R) {}
                } else {
                    while (nums[R] == nums[--R] && L < R) {}
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum_15().threeSum (new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
