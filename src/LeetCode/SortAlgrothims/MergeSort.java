package LeetCode.SortAlgrothims;

public class MergeSort {

    public static void mergeSort(int[] arr, int leftBound,int rightBound) {
        if (leftBound==rightBound){
            return;
        }
        //二分
        int mid=leftBound+(rightBound-leftBound)/2;
        //左边排排序
        mergeSort(arr,leftBound,mid);
        //右边排序
        mergeSort(arr,mid+1,rightBound);
        //排好序之后归并
        merge(arr,leftBound,mid+1,rightBound);
    }

    private static void merge(int[] arr,int left,int right,int rightBound) {//排好顺序之后归并
        int mid=right-1;
        int[] tmp=new int[rightBound-left+1];

        int i=left;
        int j=right;
        int k=0;

        while (i<=mid&&j<=rightBound){//两端：i属于[i,mid] j属于[mid+1,length-1]
            tmp[k++]=(arr[i]<=arr[j])?arr[i++]:arr[j++];
            //保证稳定性：如果遇到两一样的元素，会先把前半部分那个元素放进tmp.保证稳定性
        }

        while (i<=mid){
            tmp[k++]=arr[i++];
        }
        while (j<=rightBound){
            tmp[k++]=arr[j++];
        }

        for (int m=0;m<tmp.length;m++){
            arr[left++]=tmp[m];
        }
    }
}
