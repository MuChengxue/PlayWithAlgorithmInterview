package LeetCode.Arrays.TwoPointers;
/**
        给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
        示例:
        输入: [0,1,0,3,12]
        输出: [1,3,12,0,0]
        说明:
        必须在原数组上操作，不能拷贝额外的数组。
        尽量减少操作次数。
*/

import java.util.ArrayList;

public class MoveZeroes_283 {
    //时间：n
    //空间：n
    public void moveZeroes1(int[] nums) {
        ArrayList<Integer> temp=new ArrayList<>();
        for (int a:nums){//找出所有非零元素
            if (a!=0)
                temp.add(a);
        }

        //将找到的非零元素放回原数组，并进行0填充
        for (int i=0;i<temp.size();i++){
            nums[i]=temp.get(i);
        }
        for (int i=temp.size();i<nums.length;i++){
            nums[i]=0;
        }
    }

    //时间：n
    //空间：1
    public void moveZeroes2(int[] nums) {
        int idx=0;
        //将所有非零元素挪到前边（不必考虑覆盖有用元素）
        for(int num:nums){
            if(num!=0){
                nums[idx++]=num;
            }
        }
        //0填充
        while(idx<nums.length)
            nums[idx++]=0;
    }

    public void moveZeroes3(int[] nums) {
        int k=0;
        for(int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                int temp=nums[i];
                nums[i]=nums[k];
                nums[k++]=temp;
            }
        }
    }

    public void moveZeroes4(int[] nums) {
        int k=0;
        for(int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                if((i!=k)){
                    int temp=nums[i];
                    nums[i]=nums[k];
                    nums[k++]=temp;
                }else{
                    k++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] arr=new int[]{0,1,0,3,12};
        new MoveZeroes_283().moveZeroes2(arr);
        for (int a :arr){
            System.out.println(a);
        }
    }
}
