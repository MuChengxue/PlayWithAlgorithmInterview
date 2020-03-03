package LeetCode.FindTables.slow_fast;

import java.util.HashSet;

public class IsHappy_202 {
    public boolean isHappy(int n) {
        int data=n;
        HashSet<Integer> set=new HashSet();

        while (data!=1){
            int[] tmp=help(data);
            data=0;
            for (int i=0;i<10;i++){
                data+=(tmp[i]*tmp[i]);
            }

            if (set.contains(data)){
                return false;
            }else {
                set.add(data);
            }
        }

        return true;
    }

    private int[] help(int n){
        int[] nums=new int[10];
        int i=0;
        while (n!=0){
            nums[i++]=n%10;
            n/=10;
        }
        return nums;
    }

    //判断循环就用快慢指针
    public boolean isHappy2(int n) {
        int p = n, q = getNext(n);
        while (q != 1) {
            p = getNext(p);
            q = getNext(getNext(q));
            if (p == q) return false;
        }
        return true;
    }

    private int getNext(int x) {
        int n = 0;
        while (x!=0) {
            n += (x % 10) * (x % 10);
            x /= 10;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new IsHappy_202().isHappy2(22));

    }
}
