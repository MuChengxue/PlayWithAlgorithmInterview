package LeetCode.SortAlgrothims;

public class QuickSort {

    public static void quickSort(int[] arr, int leftBound, int rightBound) {
        if (leftBound >= rightBound) {
            return;
        }
        int mid = partion1(arr, leftBound, rightBound);
        quickSort(arr, leftBound, mid - 1);
        quickSort(arr, mid + 1, rightBound);
    }

    //pivot选在最右边
    private static int partion1(int[] arr, int leftBound, int rightBound) {
//        int pivot = arr[(int) (Math.random()*(rightBound-leftBound)+leftBound-1)];
        int pivot=arr[rightBound];
        int left = leftBound;
        int right = rightBound - 1;

        while (left <= right) {
            while (left <= right && arr[left] <= pivot)
                left++;
            while (left <= right && arr[right] > pivot)
                right--;

            if (left < right)//==的时候不用交换
                swap(arr, left, right);
        }
//        System.out.println(left-right);//1

//        swap(arr, right+1, rightBound);
//        return right+1;
        swap(arr, left, rightBound);
        return left;
    }

    //pivot选在最左边
    private static int partion2(int[] arr, int leftBound, int rightBound) {
//        int pivot = arr[(int) (Math.random()*(rightBound-leftBound)+leftBound-1)];
        int pivot=arr[leftBound];
        int left = leftBound+1;
        int right = rightBound ;

        while (left <= right) {//循环结束的时候有left-right==1
            while (left <= right && arr[left] <= pivot)//left<right
                left++;
            while (left <= right && arr[right] > pivot)
                right--;

            if (left < right)//==的时候不用交换
                swap(arr, left, right);
        }
//        System.out.println(left-right);//1

//        swap(arr, left-1, leftBound);
//        return left-1;
        swap(arr, right, leftBound);
        return right;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
//        int[] arr = {7, 3, 2, 10, 8, 1, 9, 5, 4, 6};
        int[] arr= TesterUtil.generateRandomArray(10, 0, 1000);
        System.out.println(1);
        quickSort(arr, 0, arr.length - 1);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}
