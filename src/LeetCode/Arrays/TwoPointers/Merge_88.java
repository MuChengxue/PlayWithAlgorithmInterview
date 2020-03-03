package LeetCode.Arrays.TwoPointers;

/**
 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 说明:
 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 示例:
 输入:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3
 输出: [1,2,2,3,5,6]
 */

public class Merge_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length==0)
            return;

        int index1=0,index2=0;
        int lenth1=nums1.length-nums2.length;
        int i=0;
        int[] res=new int[nums1.length];
        while (index1<lenth1&&index2<nums2.length){
            if (nums1[index1]<nums2[index2]){
                res[i++]=nums1[index1++];
            }else {
                res[i++]=nums2[index2++];
            }
        }

        if (index1<lenth1){
            while (index1<lenth1){
                res[i++]=nums1[index1++];
            }
        }else if (index2<nums2.length){
            while (index2<nums2.length){
                res[i++]=nums2[index2++];
            }
        }

        for (int j=0;j<res.length;j++){
            nums1[j]=res[j];
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length==0)
            return;
        int[] nums = new int[nums1.length];
        int i = 0;
        int j = 0;
        int cur = 0;
        while(i<=m-1||j<=n-1){
            if(j!=n&&(i==m||nums1[i]>=nums2[j]))
                nums[cur++] = nums2[j++];
            else
                nums[cur++] = nums1[i++];
        }

        for(int a = 0; a < nums1.length;a++){
            nums1[a] = nums[a];
        }
    }
}
