package LeetCode.StackAndQueue;

public class ReverseVowels_345 {

    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int l = 0, r = arr.length - 1;
        while (l < r) {
            while (l < arr.length && judge(arr[l]))
                l++;
            while (r >= 0 && judge(arr[r]))
                r--;

            if (l >= r) {
                break;
            }
            char tmp = arr[r];
            arr[r--] = arr[l];
            arr[l++] = tmp;
        }

        return String.valueOf(arr);
    }

    public boolean judge(char c) {
        if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
            return true;
        } else {
            return false;
        }
    }

}
