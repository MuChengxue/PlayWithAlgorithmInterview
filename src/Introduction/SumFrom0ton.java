package Introduction;

public class SumFrom0ton {
    public static int sum1(int n) {
        int res = 0;
        if (n >= 0) {

            for (int i = 0; i <= n; i++) {
                res += i;
            }
        } else {
            res = -sum1(-n);
        }
        return res;
    }

    public static int sum2(int n){

        if (n==0)
            return  0;
        if (n > 0) {
            return n+sum2(n-1);
        }else {
            return n+sum2(n+1);
        }

    }

    public static void main(String[] args) {
        System.out.println(sum2(-10)
        );
    }
}
