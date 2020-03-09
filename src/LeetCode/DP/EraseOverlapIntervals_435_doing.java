package LeetCode.DP;

import java.util.Arrays;

//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
//******************也可以理解为最多保留多少个区间，可以让这些区间之间互相不重叠******************
//保理方法（(2^n)*n）
//先要排序，方便判断重叠与否
public class EraseOverlapIntervals_435_doing {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3},
                {1, 4}

        };
        Arrays.sort(intervals, (int[] a, int[] b) -> (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));//区间范围越靠左的排在前边

        for (int[] a : intervals) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        System.out.println("################");
        Arrays.sort(intervals, (int[] a, int[] b) -> (a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]));//区间范围越靠左的排在前边

        for (int[] a : intervals) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    //###########################################自下而上 动态规划#############################
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return 0;

//        List<Interval> list=new ArrayList<>();
//        for (int[] inter:intervals)
//            list.add(new Interval(inter[0],inter[1]));
//        Collections.sort(list,(Interval i1,Interval i2)->(i1.start!=i2.start?i1.start-i2.start:i1.end-i2.end));

        Arrays.sort(intervals, (int[] a, int[] b) -> (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));//按照开始最早的排列
        //memo[i]表示使用intervals[0 ... i]的区间所能构成的最长不重叠区间序列 所用子区间个数
        int[] memo = new int[intervals.length];
        Arrays.fill(memo, 1);

        for (int i = 1; i < intervals.length; i++) {
            //memo[i]
            for (int j = 0; j < i; j++) {
                if (intervals[i][0] >= intervals[j][1])//第i个区间可以跟在第j个区间的后面而不重叠：当前区间的开始大于某个区间的结束
                    memo[i] = Math.max(memo[i], 1 + memo[j]);//1+memo[j]以第i个区间结尾（前一个是j）的不重叠区间的子区间个数
            }
        }

        Arrays.sort(memo);
        return intervals.length - memo[memo.length - 1];//总区间数减去最多保留的 就是最少删除的

    }

    //###############################################贪心算法_思路 好理解#################################################
    //每个区间结尾的值end很重要，end越小，留给后面的空间越大，后面越有可能容纳更多的区间
    public int eraseOverlapIntervals2(int[][] intervals) {
        if (intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (int[] a, int[] b) -> (a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]));//按照结尾最早的排列

        int res = 1;
        int pre = 0;//开始遍历之前选择使用第0个区间，此时
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[pre][1]) {//当前区间的开始大于上一个区间的结束
                res++;
                pre = i;
            }

        }

        return intervals.length - res;//总区间数减去最多保留的 就是最少删除的
    }

    //###############################################贪心算法_思路 好理解#################################################
    public int eraseOverlapIntervals3(int[][] intervals) {
        if (intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (i1, i2) -> (i1[0] - i2[0]));//按照开始最早的排序

        int count = 0;//删除区间计数
        int end = intervals[0][1];//之前区间的结束时间 2
        //从第二个区间开始遍历
        for (int i = 1; i < intervals.length; i++) {//1 2 3 4
            //当前区间和前任区间重合
            if (intervals[i][0] < end) {//当前区间的开始小于上个区间的结束
                count++;//1 2
                //从前任区间和当前区间中删除结束时间晚(大 )的区间，可以给后边留出更多的空间，就可以删除更少的子区间
                end = Math.min(end, intervals[i][1]);// 2 2
            } else {//当前区间不重合
                end = intervals[i][1];//3  4
            }
        }
        return count;
    }

}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
