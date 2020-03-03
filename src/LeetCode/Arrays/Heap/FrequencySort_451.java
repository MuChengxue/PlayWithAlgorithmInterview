package LeetCode.Arrays.Heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class FrequencySort_451 {

    public String frequencySort(String s) {
        HashMap<Integer, String> map = new HashMap<>();

        int[] freq = new int[256];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                char ch = (char) i;

                String str = map.get(freq[i]);
                // 字符出现次数相同, 进行拼接
                if (str != null) {
                    String strNew = str.concat(build(ch, freq[i]));
                    map.put(freq[i], strNew);
                } else {
                    map.put(freq[i], build(ch, freq[i]));
                }
            }
        }

        Integer[] keys = map.keySet().toArray(new Integer[]{});
        Arrays.sort(keys);
        StringBuilder sbl = new StringBuilder();
        for (int i = keys.length - 1; i >= 0; i--) {
            sbl.append(map.get(keys[i]));
        }

        return sbl.toString();
    }

    private String build(char ch, int times) {
        String string = Character.toString(ch);
        StringBuilder res = new StringBuilder(string);
        int t = 1;
        while (t < times) {
            res.append(string);
            t++;
        }

        return res.toString();
    }

    public String frequencySort2(String s) {
        //初始化字母数组
        int[] letters = new int[256];
        //填充数组
        for (char c : s.toCharArray()) {
            letters[c]++;
        }
        //排序
        PriorityQueue<Letter> queue = new PriorityQueue<>();

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != 0) {
                queue.add(new Letter((char) i, letters[i]));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();

        while (!queue.isEmpty()) {
            Letter letter = queue.poll();
            for (int i = 0; i < letter.count; i++)
                stringBuilder.append(letter.letter);
        }


        return stringBuilder.toString();
    }

    public class Letter implements Comparable<Letter> {
        public char letter = '0';
        public int count = 0;

        public Letter(char latter, int count) {
            this.letter = latter;
            this.count = count;
        }

        @Override//构造大顶堆
        public int compareTo(Letter o) {
            return o.count - this.count;
        }
    }

}
