package LeetCode.Arrays.SlideWindow;

/**
 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:

 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 示例 2:

 输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 示例 3:

 输入: "pwwkew"
 输出: 3
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring_03 {

    //暴力法 n^3  超时
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
                if (allUnique(s, i, j))
                    ans = Math.max(ans, j - i + 1);
        return ans;
    }

    private boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch))
                return false;
            set.add(ch);
        }
        return true;
    }

    //时间 n  HashMap
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range ############[i, j]##########
        for (int j = 0, i = 0; j < n; j++) {
//            if (map.containsKey(s.charAt(j))) {
//                i = Math.max(map.get(s.charAt(j)), i);
//            }
//            ans = Math.max(ans, j - i + 1);
//            map.put(s.charAt(j), j + 1);//映射到j+1 可以在get的时候直接让i索引到那个重复元素的下一个位置。
            //也可以直观的写成下边这样

            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j);
        }
        return ans;
    }

    //时间 n  也相当于是一种简单的hash算法：每个char映射到0-256
    //##########考虑""和" "
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;

        int[] index = new int[256]; // current index of character 存放当前j处字符asca码（0-256）在string中的索引
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public int lengthOfLongestSubstring4(String s) {
        int[] freq = new int[256];
        int l = 0, r = -1;//滑动窗口[l,r]
        int res = 0;

        while (l < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {//如果右边的下个位置没有重复
                freq[s.charAt(++r)]++;//往右滑动一格，并记录出现一次
            } else {
                freq[s.charAt(l++)]--;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int[] window=new int[256];
        int res = 0; // 记录最长长度

        while (right < s.length()) {
            char c1 = s.charAt(right);
            window[c1]++;
            right++;
            // 如果 window 中出现重复字符
            // 开始移动 left 缩小窗口
            while (window[c1] > 1) {
                char c2 = s.charAt(left);
                window[c2]--;
                left++;
            }

            res = Math.max(res, right - left);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new StringBuffer(" ").length());
    }

}
