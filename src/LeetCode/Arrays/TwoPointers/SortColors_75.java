package LeetCode.Arrays.TwoPointers;

/**
 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 注意:
 不能使用代码库中的排序函数来解决这道题。
 示例:
 输入: [2,0,2,1,1,0]
 输出: [0,0,1,1,2,2]
 进阶：

 一个直观的解决方案是使用计数排序的两趟扫描算法。
 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */

public class SortColors_75 {
    //时间 n
    //空间 k
    //遍历2遍
    public void sortColors1(int[] nums) {
        int[] colors=new int[]{0,0,0};//红白蓝
        for(int color:nums){
            if (color>=0&&color<=2){
                colors[color]++;//计算三个 颜色频率
            }
        }

        int index=0;
        for (int i=0;i<colors.length;i++){//放回
            for (int j=0;j<colors[i];j++){
                nums[index++]=i;
            }
        }

    }

    //时间 n
    //空间 1
    //遍历一遍
    public void sortColors2(int[] nums) {
        int zero=-1;//[0,zero]都为0  刚开始的时候这一部分应该是无效的
        int two=nums.length;//[two,length-1]都为2 刚开始的时候这一部分应该是无效的
        for(int i=0;i<two;){
            if(nums[i]==1){
                i++;
            }else if (nums[i]==2){
                swap(nums,i,--two);
            }else if (nums[i]==0){
                swap(nums,i++,++zero);
            }
        }
    }

    private void swap(int[] nums, int i, int k) {
        int temp=nums[i];
        nums[i]=nums[k];
        nums[k++]=temp;
    }
}
