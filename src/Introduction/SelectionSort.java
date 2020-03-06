package Introduction;

public class SelectionSort {

    //n^2
    public static void selectionSort(int[] arr){
        int n=arr.length;
        for (int i=0;i<n;i++){
            int minIndex=i;
            for (int j=i+1;j<n;j++){
                if (arr[j]<arr[minIndex])
                    minIndex=j;
            }
            swap(arr,i,minIndex);

        }
    }

    private static void swap(int[] arr, int i, int minIndex) {
        int temp=arr[i];
        arr[i]=arr[minIndex];
        arr[minIndex]=temp;
    }

    public static void main(String[] args) {
        int [] arr=new int[]{1,2,3,2};
        selectionSort(arr);
        for(int a:arr){
            System.out.println(a);
        }
    }
}
