package LeetCode.RecursionAndRecall;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens_51 {
    List<List<String>> res = new ArrayList<>();
    boolean[] col, dia1, dia2;

    public static void main(String[] args) {
        System.out.println(new SolveNQueens_51().solveNQueens(3));
    }

    public List<List<String>> solveNQueens(int n) {
        res.clear();
        if (n < 1)
            return res;

        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        putQueen(n, 0, new ArrayList<>());
        return res;
    }

    //尝试在一个n皇后问题中，摆放第index行的皇后位置
    private void putQueen(int n, int index, List<Integer> row) {//一行一行地摆放

        if (index == n) {
            res.add(generateBoard(n, row));
            return;
        }

        for (int i = 0; i < n; i++) {
            //尝试将第index行的皇后摆放在第i列
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                row.add(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                putQueen(n, index + 1, row);
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                row.remove(row.size() - 1);
            }
        }

        return;
    }

    private List<String> generateBoard(int n, List<Integer> row) {
        List<String> res = new ArrayList<>();
        if (n != row.size())
            return res;

        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (row.get(i) == j) {
                    s.append("Q");
                } else {
                    s.append(".");
                }
            }
            res.add(s.toString());
        }

        return res;
    }
}
