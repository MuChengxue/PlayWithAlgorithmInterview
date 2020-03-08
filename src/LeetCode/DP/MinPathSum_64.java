package LeetCode.DP;

public class MinPathSum_64 {
    //###########################################自下而上########################################
    public int minPathSum(int[][] grid) {//O(mn)
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = m - 1; i >= 0; i--)//第i行 从单数第二行开始（最后一行上边处理过）
            for (int j = n - 1; j >= 0; j--)//第i行从右到左搜索
                //在（i,j）记录当前位置到右下角的最近距离
                if (j == n - 1 && i < m - 1) {//最后一列到右下角的最短距离
                    grid[i][j] += grid[i + 1][j];
                } else if (i == m - 1 && j < n - 1) {//最后一行到右下角的最短距离
                    grid[m - 1][j] += grid[m - 1][j + 1];
                } else if (i == m - 1 && j == n - 1) {//右下角数字到期距离就是自身
                } else {//其他位置：右边和下边选一个
                    grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
                }
        return grid[0][0];
    }


    //###########################################自上而下（记忆搜索）########################################
    public int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        //最好将memo初始化全为Integer.max
        return calculate(grid, 0, 0, new int[grid.length + 1][grid[0].length + 1]);
    }

    public int calculate(int[][] grid, int i, int j, int[][] memo) {
        if (memo[i][j] != 0)
            return memo[i][j];
        if (i == grid.length || j == grid[0].length) //增加一层和一列，越界，到右下角无穷
            return memo[i][j] = Integer.MAX_VALUE;
        if (i == grid.length - 1 && j == grid[0].length - 1) //到了右下角元素
            return memo[i][j] = grid[i][j];

        return memo[i][j] = grid[i][j] + Math.min(calculate(grid, i + 1, j, memo), calculate(grid, i, j + 1, memo));
    }


}
