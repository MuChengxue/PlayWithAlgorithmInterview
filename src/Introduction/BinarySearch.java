package Introduction;

public class BinarySearch {

    //logn  在[l,r]的范围里查找
    public static int binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1;//在[l,r]的范围里查找
        while (l <= r) {//l==r时 [l，r]依然有效代表只有一个元素
            int mid = l + (r - l) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] > target)
                r = mid - 1;//target在[l,mid-1]中
            else
                l = mid + 1;//target在[mid+1,r]中
        }

        return -1;
    }

    //logn  在[l,r]的范围里查找
    public static int binarySearch2(int[] arr, int target) {
        int l = 0, r = arr.length ;//在[l,r)的范围里查找,也就是[l,r-1]
        while (l <r) {//l==r时 [l，r)无效，l必须小于r
            int mid = l + (r - l) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] > target)
                r = mid;//target在[l,mid-1]中
            else
                l = mid + 1;//target在[mid+1,r]中
        }

        return -1;
    }

    public static int binarySearch3(int[] arr, int l, int r, int target) {
        if (l > r)
            return -1;
        int mid = l + (r - l) / 2;

        if (arr[mid] == target)
            return mid;
        else if (arr[mid] > target)
            return binarySearch3(arr, l, mid - 1, target);
        else
            return binarySearch3(arr, mid + 1, r, target);

    }

    public static void main(String[] args) {

    }
}
