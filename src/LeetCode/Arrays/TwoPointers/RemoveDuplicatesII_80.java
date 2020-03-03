package LeetCode.Arrays.TwoPointers;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 示例 1:
 * 给定 nums = [1,1,1,2,2,3],
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 * 你不需要考虑数组中超出新长度后面的元素。
 */

public class RemoveDuplicatesII_80 {
    public int removeDuplicates(int[] nums) {

        //数组是排序的
        // Initialize the counter and the second pointer.
        int j = 1, count = 1;//j及其前边的元素都是有用的

        // Start from the second element of the array and process elements one by one.
        for (int i = 1; i < nums.length; i++) {

            // If the current element is a duplicate, increment the count.
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                // Reset the count since we encountered a different element than the previous one.
                count = 1;
            }

            // For a count <= 2, we copy the element over thus overwriting the element at index "j" in the array
            if (count <= 2) {//小于等于2表示这些元素都是需要保留的，不然就跳过
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public int removeDuplicates2(int[] nums) {
        if(nums.length <= 2) return nums.length;
        int res = 2;
        for(int i = 2 ;i < nums.length; i++) {
            if(nums[res - 2] != nums[i] ) {
                nums[res++] = nums[i];
            }
        }
        return res;
    }



}
