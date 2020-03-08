package LeetCode.DP;

public class Fibonacci {

    //###########################################自上而下（记忆搜索）########################################
    public static int times;
    int[] memo;

    public static void main(String[] args) {
        int n = 40;
        long start = System.nanoTime();
        System.out.println("n=" + n + "  " + new Fibonacci().fib(n));
        System.out.println("Time:" + (System.nanoTime() - start));
        int tmp = times;
        System.out.println("times:" + tmp);

        System.out.println("#################");
        long start1 = System.nanoTime();
        System.out.println("n=" + n + "  " + new Fibonacci().fib2(n));
        System.out.println("Time:" + (System.nanoTime() - start1));
        System.out.println("times:" + (times - tmp));
    }

    public int fib(int n) {
        times = 0;
        memo = new int[n + 1];
        for (int i = 0; i < memo.length; i++)
            memo[i] = -1;
        return help(n);
    }

    private int help(int n) {
        times++;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        if (memo[n] == -1)
            memo[n] = help(n - 1) + help(n - 2);

        return memo[n];

    }

    //###########################################自上而下（有重叠）########################################
    public int fib2(int n) {
        times++;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        return fib2(n - 1) + fib2(n - 2);
    }

    //###########################################自下而上########################################
    public int fib3(int n) {
        int[] res = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];
    }
}
