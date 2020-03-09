package SortAlgrothims;

import java.util.Arrays;

public class QuickSortTest {

    public static void test01(int n) {
        for (int i = 0; i < n; i++) {
            int[] arr1 = TesterUtil.generateRandomArray(10000, 0, 1000);
            int[] arr2 = new int[arr1.length];
            for (int j = 0; j < arr1.length; j++) {
                arr2[j] = arr1[j];
            }

            QuickSort.quickSort(arr1, 0, arr1.length - 1);
            Arrays.sort(arr2);

            for (int k = 0; k < arr1.length; k++) {
                if (arr1[k] != arr2[k]) {
                    System.out.println(false);
                    break;
                }
            }
        }

    }

    public static void test02(int n) {
        for (int i = 0; i < n; i++) {
            int[] arr1 = TesterUtil.generateRandomArray(10000, 0, 1000);
            int[] arr2 = new int[arr1.length];
            for (int j = 0; j < arr1.length; j++) {
                arr2[j] = arr1[j];
            }

            Div3DeScanSort.Div3DeScanSort(arr1, 0, arr1.length - 1);
            Arrays.sort(arr2);

            for (int k = 0; k < arr1.length; k++) {
                if (arr1[k] != arr2[k]) {
                    System.out.println(false);
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {
        test02(100);
    }
}
