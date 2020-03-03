package LeetCode.FindTables.SlideWindow;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i=1;i<nums.length;i++){
            if (nums[i]==nums[i-1])
                return true;
        }

        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Set record=new HashSet();
        for (int num:nums){
            if (record.contains(num ))
                return true;
            record.add(num);
        }

        return false;
    }
}
