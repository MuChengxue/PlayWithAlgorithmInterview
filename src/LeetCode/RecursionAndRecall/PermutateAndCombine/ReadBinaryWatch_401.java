package LeetCode.RecursionAndRecall.PermutateAndCombine;

import java.util.ArrayList;
import java.util.List;

public class ReadBinaryWatch_401 {
    //####################################################################################################
    List<String> ans = new ArrayList<>();

    public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<String>();
        String[][] hstrs = {
                {"0"},//0个亮
                {"1", "2", "4", "8"},//1
                {"3", "5", "6", "9", "10"},//2
                {"7", "11"}//3
        };
        String[][] mstrs = {
                {"00"},//0
                {"01", "02", "04", "08", "16", "32"},//1
                {"03", "05", "06", "09", "10", "12", "17", "18", "20", "24", "33", "34", "36", "40", "48"},
                {"07", "11", "13", "14", "19", "21", "22", "25", "26", "28", "35", "37", "38", "41", "42", "44", "49", "50", "52", "56"},
                {"15", "23", "27", "29", "30", "39", "43", "45", "46", "51", "53", "54", "57", "58"},
                {"31", "47", "55", "59"}//5
        };

        for (int i = 0; i <= Math.min(3, num); i++) {//i表示hour亮灯数 故不能超过3
            if (num - i > 5)//minute 不能超过5个亮灯
                continue;
            String[] hstr = hstrs[i];
            String[] mstr = mstrs[num - i];
            for (int j = 0; j < hstr.length; j++) {
                for (int k = 0; k < mstr.length; k++) {
                    ans.add(hstr[j] + ":" + mstr[k]);
                }
            }
        }
        return ans;

    }

    //#######################################################################################################
    public List<String> readBinaryWatch2(int num) {
        List<String> res = new ArrayList<>();
        //直接遍历  0:00 -> 12:00   每个时间有多少1
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (count1(h) + count1(m) == num) {
                    res.add(Integer.toString(h) + ":" +
                            (m < 10 ? "0" + Integer.toString(m) : Integer.toString(m)));
                }
            }
        }
        return res;
    }

    //计算二进制中1的个数
    int count1(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    //#######################################################################################################
    public List<String> readBinaryWatch3(int num) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == num)
                    times.add(String.format("%d:%02d", h, m));
            }
        }
        return times;
    }

    public List<String> readBinaryWatch4(int num) {
        ans.clear();

        int[] time = new int[10];
        DFS(num, 0, time);
        return ans;
    }

    private void DFS(int num, int pos, int[] time) {
        if (num == 0) {
            int hour = time[0] + 2 * time[1] + 4 * time[2] + 8 * time[3];
            int minute = time[4] + 2 * time[5] + 4 * time[6] + 8 * time[7] + 16 * time[8] + 32 * time[9];
            if (hour < 12 && minute < 60) {
                ans.add(String.format("%d:%02d", hour, minute));
            }
            return;
        }

        for (int i = pos; i <= 10 - num; i++) {
            time[i]++;
            DFS(num - 1, i + 1, time);
            time[i]--;
        }
    }


}
