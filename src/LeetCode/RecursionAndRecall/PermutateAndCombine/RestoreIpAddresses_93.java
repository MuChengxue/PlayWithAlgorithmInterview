package LeetCode.RecursionAndRecall.PermutateAndCombine;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses_93 {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        res.clear();
        if (s == null || s.length() < 4 || s.length() > 12)
            return res;

        restoreIpAddresses(s, 0, new ArrayList<>());
        return res;
    }

    public void restoreIpAddresses(String s, int index, List<String> list) {
        // 预期结果能有的最大长度 最多能有4格，每个3位。 list是已占有的格数
        int maxLength = (4 - list.size()) * 3;
        // 预期结果能有的最小长度 最少能有4格，每个1位。 list是已占有的格数
        int minLength = 4 - list.size();
        // 如果原字符串剩余字符 大于预期最大长度 不符合要求
        if (s.length() - index > maxLength || s.length() - index < minLength) {
            return;
        }//####################### 剪枝 #######################

        // 满足条件
        if (list.size() == 4 && s.length() == index) {//list里边有四段，并且index走到了s的末尾即刚好用完了string的全部数字
            // 拼接处结果
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    sb.append(list.get(i));
                } else {
                    sb.append(".").append(list.get(i));
                }
            }
            res.add(sb.toString());
        }

        for (int i = index + 1; i <= index + 3 && i <= s.length(); i++) {
            String ip = s.substring(index, i);
            // 大于255 不符合ip规则
            if (Integer.parseInt(ip) > 255)
                continue;//####################### 剪枝 #######################
            // 大于1位数时 0不能为头，三位数时第一位不能大于2
            if ((ip.length() > 1 && "0".equals(ip.substring(0, 1))) || (ip.length() == 3 && Integer.parseInt(ip.substring(0, 1)) > 2))
                continue;//####################### 剪枝 #######################

            list.add(ip);
            restoreIpAddresses(s, i, list);
            list.remove(list.size() - 1);
        }
    }
}
