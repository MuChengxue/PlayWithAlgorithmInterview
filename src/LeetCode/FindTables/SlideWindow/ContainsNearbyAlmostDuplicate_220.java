package LeetCode.FindTables.SlideWindow;

import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate_220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length<2 ){
            return false;
        }

        int left=0;
        TreeSet<Double> record= new TreeSet();
        while (left<nums.length){
            double num=nums[left];
            Double small=record.ceiling(num);//Returns the least key greater than or equal to the given key,
            if (small!=null&&small-num <=t)
                return true;

            Double big=record.floor(num );//Returns the greatest key less than or equal to the given key,
            if (big!=null&&num -big<=t)
                return true;

            record.add(num );
            if (record.size()==k+1){
                record.remove((double)nums[left-k]);
            }

            left++;
        }

        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = Math.max(i - k, 0); j < i; ++j) {
                double ni=nums[i];
                double nj=nums[j];

                if (Math.abs(ni - nj) <= t)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ContainsNearbyAlmostDuplicate_220().containsNearbyAlmostDuplicate(new int[]{1,2,3,1},3,0));
    }

}
