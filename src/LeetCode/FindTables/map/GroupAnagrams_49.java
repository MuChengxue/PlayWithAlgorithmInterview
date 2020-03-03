package LeetCode.FindTables.map;

import java.util.*;

class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList();

        //key是一种pattern：具有相同的元素就是一种pattern 映射
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);

            if (!ans.containsKey(key))
                ans.put(key, new ArrayList());

            ans.get(key).add(s);
        }

        return new ArrayList(ans.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0)
            return new ArrayList();

        //key是一种pattern：#_#_#_#_#_#_#_#_#_#_#_  映射
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            for (char c : s.toCharArray())
                count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }

            String key = sb.toString();
            if (!ans.containsKey(key))
                ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

}
