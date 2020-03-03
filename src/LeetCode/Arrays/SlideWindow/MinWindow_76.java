package LeetCode.Arrays.SlideWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */


public class MinWindow_76 {


    public String minWindow2(String s, String t) {
        int left = 0, right = 0, start = 0, minLen = Integer.MAX_VALUE;

        int count = t.length();//toBeMatched
        int[] map = new int[256];//needs 初始化为0
        for(char c: t.toCharArray()){
            map[c]++;
        }

        while(right< s.length()){
            if(map[s.charAt(right)]>0){
                count--;//表示当前字符命中一个T中的元素，toBeMatched--
            }
            map[s.charAt(right++)]--;//needs中相应的位置--，同时右划

            while(count == 0){//toBeMatched==0 表示找到一个可行解 下边开始优化
                if(right-left<minLen){//更新解
                    minLen = right-left;
                    start = left;
                }

                if(map[s.charAt(left)] == 0){//进入优化之前，需要被匹配的字母在map中都为0.若优化的过程中把为0的元素去除了，count自然要++
                    count++;
                }
                map[s.charAt(left++)]++;
            }
        }
        return minLen == Integer.MAX_VALUE?"":s.substring(start, start+minLen);
    }


    public String minWindow(String s, String t) {
        int start = 0, minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;

        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> widow = new HashMap<>();
        char[] chars = t.toCharArray();
        for (char c : chars) {
            int cnt = needs.getOrDefault(c, 0);
            needs.put(c, cnt + 1);

        }

        int match = 0;

        while (right < s.length()) {
            char c1 = s.charAt(right);
            int count1 = widow.getOrDefault(c1, 0);
            widow.put(c1, count1 + 1);
            if (needs.containsKey(c1) && needs.get(c1).intValue()== widow.get(c1).intValue() ) {
                match++;
            }
            right++;

            while (left <= right && match == needs.size()) {
                if (minLen==Integer.MAX_VALUE||right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }

                char c2 = s.charAt(left);
                int count2=widow.getOrDefault(c2, 0);
                widow.put(c2, count2 - 1);
                if (needs.containsKey(c2) && widow.get(c2).intValue()  < needs.get(c2).intValue() ) {
                    match--;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public String minWindow3(String s, String t) {
        if (s.equals(t))
            return s;
        int start = 0, minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int[] needs = new int[256];
        int[] window = new int[256];

        char[] chars = t.toCharArray();
        for (char c : chars) {
            needs[c]++;
        }

        int match = 0;

        while (right < s.length()) {
            char c1 = s.charAt(right);
            window[c1]++;
            if (window[c1]<= needs[c1] ) {
                match++;
            }
            right++;

            while (left <= right && match == t.length()) {
                if ( right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }

                char c2 = s.charAt(left);
                window[c2]--;
                if (window[c2] < needs[c2] ) {
                    match--;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        String s = new String("ABDOBECODEBANC");
        String t = new String("ABC");

        String s1 = new String("bbaa");
        String t1 = new String("aba");
        System.out.println(new MinWindow_76().minWindow3(s1, t1));

    }
}
