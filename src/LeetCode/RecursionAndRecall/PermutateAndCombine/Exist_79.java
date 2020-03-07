package LeetCode.RecursionAndRecall.PermutateAndCombine;

public class Exist_79 {
    int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};//上 右 下 左 （原点在左上角）
    int m, n;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        m = board.length;
        if (m == 0)
            return false;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (searchWord(board, word, 0, i, j))
                    return true;
            }
        }

        return false;
    }

    //从board[startX][startY]开始，寻找word[index,word,size()]
    private boolean searchWord(char[][] board, String word, int index, int startX, int startY) {
        if (index == word.length() - 1)
            return board[startX][startY] == word.charAt(index);

        if (board[startX][startY] == word.charAt(index)) {
            visited[startX][startY] = true;
            for (int i = 0; i < 4; i++) {
                int newX = startX + direction[i][0];
                int newY = startY + direction[i][1];
                if (inAera(newX, newY) && !visited[newX][newY] && searchWord(board, word, index + 1, newX, newY))
                    return true;

            }
            visited[startX][startY] = false;
        }
        return false;
    }

    private boolean inAera(int newX, int newY) {
        return newX >= 0 && newX < m && newY >= 0 && newY < n;
    }

}
