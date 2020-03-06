package Introduction;

public class TesterUtil {
    public static int[] generateRandomArray(int n,int rangeL,int rangeR){
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]= (int) (Math.random()*(rangeR-rangeL+1)+rangeL);
        }

        return arr;
    }

    public static int[] generateOrderedArray(int n){
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=i;
        }

        return arr;
    }
}
