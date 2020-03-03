package LeetCode.Arrays.SlideWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 * <p>
 * 输入:
 * s: "abab" p: "ab"
 * <p>
 * 输出:
 * [0, 1, 2]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */

public class FindAnagrams_438 {
    public List<Integer> findAnagrams(String s, String p) {

        // 用数组记录答案
        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0;
        int match = 0;
        int[] needs = new int[26];//只有小写
        int[] window = new int[26];
        for (char c : p.toCharArray())
            needs[c-'a']++;

        while (right < s.length()) {
            char c1 = s.charAt(right);
            window[c1-'a']++;
            if (window[c1-'a'] <= needs[c1-'a']) {
                match++;
            }
            right++;

            while (left <= right && match == p.length()) {
                // 如果 window 的大小合适
                // 就把起始索引 left 加入结果
                if (right - left == p.length()) {
                    res.add(left);
                }

                char c2 = s.charAt(left);
                window[c2-'a']--;
                if (window[c2-'a'] < needs[c2-'a']) {
                    match--;
                }
                left++;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        String s = new String("abababababab");
        String p = new String("aba");

        System.out.println(new FindAnagrams_438().findAnagrams(s, p));

    }
}
