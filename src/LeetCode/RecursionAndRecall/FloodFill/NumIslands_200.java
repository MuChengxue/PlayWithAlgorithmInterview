package LeetCode.RecursionAndRecall.FloodFill;

//这个问题到底是递归还是回溯见仁见智
public class NumIslands_200 {
    int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int m, n;
    boolean[][] visited;

    public int numIslands(char[][] grid) {
        m = grid.length;
        if (m == 0)
            return 0;
        n = grid[0].length;
        visited = new boolean[m][n];

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {//找到了一个陆地，res++，floodfill成为一个岛屿
                    res++;
                    //floodfill
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    //从grid[x][y]的位置开始，进行floodfill
    //进入dfs的时候，保证了(x,y) inAera并且grid[i][j]=='1'&&!visited[i][j]是没有访问过的陆地
    private void dfs(char[][] grid, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + direction[i][0];
            int newY = y + direction[i][1];
            if (inAera(newX, newY) && !visited[newX][newY] && grid[newX][newY] == '1') {//递归的终止条件隐含在这里
                dfs(grid, newX, newY);
            }
        }
        return;
    }

    private boolean inAera(int newX, int newY) {
        return newX >= 0 && newX < m && newY >= 0 && newY < n;
    }
}
