package LeetCode.DP;

//状态转移方程：F(i,C)=max{F(i-1,c),v(i)+F(i-1,c-w(i))}

public class Knapsack01 {
    public static void main(String[] args) {
        int[] w = new int[]{1, 2, 3};
        int[] v = new int[]{6, 10, 12};
        int C = 5;
        System.out.println(new Knapsack01().knapsack01(w, v, C));
        System.out.println(new Knapsack01().knapsack01_4(w, v, C));
    }

    //###########################################自上而下（记忆搜索）########################################
    public int knapsack01(int[] w, int[] v, int C) {
        int n = w.length;
        int[][] memo = new int[n][C + 1];

        return bestValue(w, v, w.length - 1, C, memo);
    }

    //用[0,index]的物品，填充容积为C的背包的最大价值
    private int bestValue(int[] w, int[] v, int index, int c, int[][] memo) {
        if (index < 0 || c <= 0)//无法选物品或者装不进去物品都应返回0，没有价值
            return 0;

        if (memo[index][c] != 0)
            return memo[index][c];

        int res = bestValue(w, v, index - 1, c, memo);//index这个物品不放进去
        if (c >= w[index])//index这个物品放进去
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index], memo));//index,c会有重复。要记忆

        return memo[index][c] = res;
    }

    //###########################################自上而下（记忆搜索）########################################
    //memo[w][C+1]第i行表示共计i个物品放入容量为0,1,2,3 ... C，所能得到的最大价值
    public int knapsack01_2(int[] w, int[] v, int C) {
        if (w.length < 1 || w.length != v.length)
            return 0;

        int n = w.length;
        int[][] memo = new int[n][C + 1];

        for (int j = 0; j <= C; j++)//第一行
            memo[0][j] = j >= w[0] ? v[0] : 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
//                memo[i][j]=memo[i-1][j];
//                if (j>=w[i])
//                    memo[i][j]=Math.max(memo[i][j],v[i]+memo[i-1][j-w[i]]);
                memo[i][j] = Math.max(memo[i - 1][j], j >= w[i] ? v[i] + memo[i - 1][j - w[i]] : -1);
            }
        }

        return memo[n - 1][C];
    }

    //###########################################自上而下（记忆搜索_空间优化）########################################
    public int knapsack01_3(int[] w, int[] v, int C) {
        if (w.length < 1 || w.length != v.length)
            return 0;

        int n = w.length;
        int[][] memo = new int[2][C + 1];

        for (int j = 0; j <= C; j++)//第一行
            memo[0][j] = j >= w[0] ? v[0] : 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                memo[i % 2][j] = Math.max(memo[(i - 1) % 2][j], j >= w[i] ? v[i] + memo[(i - 1) % 2][j - w[i]] : -1);
            }
        }

        return memo[(n - 1) % 2][C];
    }

    //###########################################自上而下（记忆搜索_空间优化2）########################################
    public int knapsack01_4(int[] w, int[] v, int C) {
        if (w.length < 1 || w.length != v.length)
            return 0;

        int n = w.length;
        int[] memo = new int[C + 1];

        for (int j = 0; j <= C; j++)//第一行
            memo[j] = j >= w[0] ? v[0] : 0;

        for (int i = 1; i < n; i++) {
            for (int j = C; j >= w[i]; j--) {//如果w[i]>j了说明，当前物品放不进背包里了，提前终止
                memo[j] = Math.max(memo[j], j >= w[i] ? v[i] + memo[j - w[i]] : -1);
            }
        }

        return memo[C];
    }
}
