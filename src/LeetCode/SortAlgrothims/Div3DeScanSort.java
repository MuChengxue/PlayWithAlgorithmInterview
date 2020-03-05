package LeetCode.SortAlgrothims;

public class Div3DeScanSort {


    /**
     * 双端扫描三分排序
     */
    public static void Div3DeScanSort(int[] arr, int leftBound, int rightBound) {

        if (leftBound >= rightBound) {
            return;
        }

        // Pointers
        int less = leftBound;  // The index of the first element of center part
        int great = rightBound; // The index before the first element of right part

        // Partitioning with one pivot
        /*
         * Use the third of the five sorted elements as pivot.
         * This value is inexpensive approximation of the median.
         */
        int pivot = arr[leftBound];

        /*
         * Partitioning degenerates to the traditional 3-way
         * (or "Dutch National Flag") schema:
         *
         *   left part    center part              right part
         * +-------------------------------------------------+
         * |  < pivot  |   == pivot   |     ?    |  > pivot  |
         * +-------------------------------------------------+
         *              ^              ^        ^
         *              |              |        |
         *             less            k      great
         *
         * Invariants:
         *
         *   all in (left, less)   < pivot
         *   all in [less, k)     == pivot
         *   all in (great, right) > pivot
         *
         * Pointer k is the first index of ?-part.
         */
        for (int k = less+1; k <= great; ++k) {
            int ak = arr[k];
            if (arr[k] < pivot) { // Move a[k] to left part
                swap(arr,less++,k);
            } else { // a[k] >= pivot - Move a[k] to right part
                while (arr[great] > pivot) {
                    --great;
                }
                if (arr[great] < pivot) { // a[great] < pivot
                    arr[k] = arr[less];
                    arr[less] = arr[great];
                    ++less;
                } else { // a[great] == pivot
                    arr[k] = pivot;
                }
                arr[great] = ak;
                great--;
            }
        }
//        int[] pointers=pariton3(arr,0,arr.length-1);

        /*
         * Sort left and right parts recursively.
         * All elements from center part are equal
         * and, therefore, already sorted.
         */
        Div3DeScanSort(arr, leftBound, less - 1);
        Div3DeScanSort(arr, great+ 1, rightBound);
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
        Div3DeScanSort(arr,0,arr.length-1);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}
