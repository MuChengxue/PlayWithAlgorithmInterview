package LeetCode.DP;

import java.util.List;

//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
public class MinimumTotal_120 {

    //###########################################自下而上########################################
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty())
            return 0;
        for (int i = triangle.size() - 2; i >= 0; i--)//第i行 从单数第二行开始（最后一行到下一层null的最近距离是其自身）
            for (int j = 0; j < triangle.get(i).size(); j++)//第i行从左到右搜索
                //在（i,j）记录当前位置到下一层的最近距离
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
        return triangle.get(0).get(0);
    }

    //###########################################自上而下（记忆搜索）########################################
    //最好将memo初始化全为Integer.max
    public int minimumTotal2(List<List<Integer>> triangle) {//递归法
        if (triangle == null || triangle.isEmpty())
            return 0;
        return minimumTotalHelper(triangle, 0, 0, new int[triangle.size()][triangle.size()]);
    }

    private int minimumTotalHelper(List<List<Integer>> triangle, int row, int col, int[][] memo) {
        if (memo[row][col] != 0) //当前位置到最后的最小距离算过了
            return memo[row][col];
        if (row == triangle.size() - 1) {//最后一层到最后的最小距离就是自身
            return memo[row][col] = triangle.get(row).get(col);
        }

        //        当前位置左翼（row + 1, col）到最后的最小距离
        int left = minimumTotalHelper(triangle, row + 1, col, memo);
        //        当前位置右翼（row + 1, col + 1）到最后的最小距离
        int right = minimumTotalHelper(triangle, row + 1, col + 1, memo);
        //当前位置的最小距离为 当前位置+min(左翼，右翼)
        return memo[row][col] = Math.min(left, right) + triangle.get(row).get(col);
    }
}
