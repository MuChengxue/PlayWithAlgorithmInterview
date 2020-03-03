package LeetCode.FindTables.SlideWindow;

import java.util.HashSet;
import java.util.Set;

public class ContainsNearbyDuplicate_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length<2 ){
            return false;
        }

        int left=0;
        Set record=new HashSet();
        while (left<nums.length){
            if (record.contains(nums[left]))
                return true;
            record.add(nums[left]);
            if (record.size()==k+1){
                record.remove(nums[left-k]);
            }

            left++;
        }

        return false;
    }

    public static void main(String[] args) {
        int [] data=new int[]{1,2,3,1,2,3};
        System.out.println(new ContainsNearbyDuplicate_219().containsNearbyDuplicate(data,2));
    }
}
