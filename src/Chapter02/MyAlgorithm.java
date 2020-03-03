package Chapter02;

public class MyAlgorithm {
    //    log n
    public static int binarySearch(int[] arr,int target){
        int l=0,r=arr.length-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if (arr[mid]==target)
                return mid;
            if (arr[mid]>target)
                r=mid-1;
            else
                l=mid+1;
        }

        return -1;
    }

    //n
    public static int findMax(int[] arr){
        int res=0;
        if (arr.length>0){
            res=arr[0];
            for (int i=1;i<arr.length;i++){
                if (arr[i]>res)
                    res=arr[i];
            }
        }

        return res;
    }

    //nlogn
    public static void mergeSort(int [] arr){
        int n=arr.length;
        int[] res=new int[n];
        System.arraycopy(arr,0,res,0,n);

        for (int sz=1;sz<n;sz+=sz){
            for (int i=0;i<n;i+=sz+sz)
                merge(arr,i,i+sz-1,Math.min(i+sz+sz-1,n-1),res);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r, int[] res) {
        int i=l,j=mid+1;
        for (int k=l;k<=r;k++){
            if (i>mid){
                arr[k]=res[j];
                j++;
            }else if (j>r){
                arr[k]=res[i];
                i++;
            }else if (res[i]<res[j]){
                arr[k]=res[i];
                i++;
            }else {
                arr[k]=res[j];
                j++;
            }
        }
    }

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
        int []arr=new int[]{1,6,2,3};
        mergeSort(arr);
        for (int a:arr){
            System.out.println(a);
        }
    }
}
