package LeetCode.FindTables.map;

import java.util.*;

public class MaxPoints_149 {

    public int maxPoints(int[][] points) {
        if(points.length < 3){
            return points.length;
        }
        int i = 0;
        //判断所有点是否都相同的特殊情况
        for (; i < points.length - 1; i++) {
            if (points[i][0] != points[i + 1][0] || points[i][1] != points[i + 1][1]) {
                break;
            }
        }
        if (i == points.length - 1) {
            return points.length;
        }

        HashSet<String> set = new HashSet<>();
        int max = 0;
        //先确定两个点构成一条直线，判断剩下的点是否在这条直线上
        for (i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    continue;
                }

                String key = getK(points[i][0], points[i][1], points[j][0], points[j][1])
                        + "@"
                        + getB(points[i][0], points[i][1], points[j][0], points[j][1]);
                if (set.contains(key)) {//已经存在了 说明判断过了，就没必要再判断一遍
                    continue;
                }

                int tempMax = 0;
                for (int k = 0; k < points.length; k++) {
                    if (k != i && k != j) {
                        if (test(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1])) {
                            tempMax++;
                        }
                    }

                }
                if (tempMax > max) {
                    max = tempMax;
                }
                set.add(key);
            }
        }
        return max + 2;
    }

    private double getB(int x1, int y1, int x2, int y2) {
        if (y2 == y1) {
            return Double.POSITIVE_INFINITY;
        }
        return (double) (x2 - x1) * (-y1) / (y2 - y1) + x1;
    }

    private double getK(int x1, int y1, int x2, int y2) {
        if (x2 - x1 == 0) {
            return Double.POSITIVE_INFINITY;
        }
        return (double) (y2 - y1) / (x2 - x1);
    }

    private boolean test(int x1, int y1, int x2, int y2, int x, int y) {
        return (long)(y2 - y1) * (x - x2) == (long)(y - y2) * (x2 - x1);
    }


    public int maxPoints2(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }

        int res = 0;
        //遍历每个点
        for (int i = 0; i < points.length; i++) {
            int duplicate = 0;
            int max = 0;//保存经过当前点的直线中，最多的点
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                //求出分子分母
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                if (x == 0 && y == 0) {
                    duplicate++;
                    continue;
                }
                //进行约分
                int gcd = gcd(x, y);
                x = x / gcd;
                y = y / gcd;
                String key = x + "@" + y;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            //1 代表当前考虑的点，duplicate 代表和当前的点重复的点
            res = Math.max(res, max + duplicate + 1);
        }
        return res;
    }

    //求最大公约数
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public int maxPoints3(int[][] points) {
        if (points == null || points.length == 0)
            return 0;
        int len = points.length;
        if (len < 3)
            return len;
        //先对点进行排序，将  横坐标纵坐标  差值较小的点排在前面
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                return Math.abs(arr1[0] - arr1[1]) - Math.abs(arr2[0] - arr2[1]);
            }
        });

        int res = 0;
        for (int i = 1; i < len; i++) {
            long x = points[i][0];
            long y = points[i][1];
            long dx = x - points[i - 1][0];
            long dy = y - points[i - 1][1];
            int count = 0;//记录重复
            if (dx == 0 && dy == 0) {
                for (int j = 0; j < len; j++) {
                    if (points[j][0] == x && points[j][1] == y)
                        count++;
                }
            } else {
                for (int j = 0; j < len; j++) {
                    if ((points[j][1] - y) * dx == (points[j][0] - x) * dy)
                        count++;
                }
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {
//        int [][] data=new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
//        System.out.println(new MaxPoints_149().maxPoints(data));
        System.out.println(new MaxPoints_149().gcd(12,6));
    }
}
