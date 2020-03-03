package LeetCode.Arrays.TwoPointers;

/**
 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 说明:
 返回的下标值（index1 和 index2）不是从零开始的。
 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 示例:
 输入: numbers = [2, 7, 11, 15], target = 9
 输出: [1,2]
 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */

import java.util.ArrayList;

public class TwoSum_167 {

    //时间超出限制 O(N^2)
    public int[] twoSum(int[] numbers, int target) {
        int [] res=new int[2];
        ArrayList arrayList=new ArrayList();
        for (int num:numbers){
            arrayList.add(num);
        }

        for (int i=0;i<numbers.length;i++){
            if (arrayList.contains(target-numbers[i])){
                int index=arrayList.indexOf(target-numbers[i]);
                if (index>i){
                    res[0]=i+1;
                    res[1]=index+1;
                }else if (index<i){
                    res[1]=i+1;
                    res[0]=index+1;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int [] data=new int[]{2,7,11,15};
        int [] res=new TwoSum_167().twoSum(data,9);
        for (int a:res){
            System.out.println(a);
        }
    }

    public int[] twoSum2(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {//同一个元素不能复用
            int sum = numbers[low] + numbers[high];
            if (sum == target)
                return new int[]{++low,++high};
            else if (sum < target)
                ++low;
            else
                --high;
        }
        return new int[]{-1,-1};
    }
}
