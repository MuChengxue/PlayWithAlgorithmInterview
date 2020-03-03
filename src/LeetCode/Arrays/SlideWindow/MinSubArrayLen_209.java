package LeetCode.Arrays.SlideWindow;

/**
 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。

 示例: 

 输入: s = 7, nums = [2,3,1,2,4,3]
 输出: 2
 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 */

public class MinSubArrayLen_209 {
    public int minSubArrayLen(int s, int[] nums) {
        int l=0,r=-1;
        int res=nums.length+1;
        int sum=0;

        while (l<nums.length){//只要l能取到值   r就也可以
            if (r+1<nums.length&&sum<s){//确保r不会划出界
                sum+=nums[++r];
            }else {
                sum-=nums[l++];
            }

            if (sum>=s)
                res=(res>r-l+1?r-l+1:res);
        }

        if (res==nums.length+1)
            res=0;
        return res;
    }

    //minSubArrayLen的优化
    public int minSubArrayLen2(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while (right < n) {
            sum += nums[right++];
            // 扩大窗口，直到>=s
            while (sum >= s) {
                min = Math.min(min, right - left);//进来之前已经right++过了，这里不必再加1

                sum -= nums[left++];
                //缩小窗口，直到<s
            }
        }
        //窗口扩大和缩小会使得它如同虫子一般蠕动向前

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    //暴力解法 n^3
    public int minSubArrayLen3(int s, int[] nums) {
        int n=nums.length;
        if(n==0){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                int sum=0;
                for (int k=i;k<j;j++){
                    sum+=nums[k];
                }

                if (sum>=s){
                    min=Math.min(min,j-i+1);
                }
            }
        }

        return min==Integer.MAX_VALUE?0:min;
    }

    //优化的暴力解法 n^2
    public int minSubArrayLen4(int s, int[] nums) {
        int n=nums.length;
        if(n==0){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        //优化求和
        int[] sums=new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++)//sums[i]表示前i个元素的和
            sums[i] = sums[i - 1] + nums[i];

        for (int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                int sum = sums[j] - sums[i] + nums[i];//i+1到j的和 再加上nums[i]就是i到j的和
                if (sum>=s){
                    min=Math.min(min,j-i+1);
                }
            }
        }

        return min==Integer.MAX_VALUE?0:min;
    }

    public static void main(String[] args) {
        System.out.println(new MinSubArrayLen_209().minSubArrayLen2(9,new int[]{8,2,2,3,2,1,2,4,3,6,1}));
    }

}
