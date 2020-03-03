package LeetCode.FindTables.map;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic_205 {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false; //如果没有全部成对的映射则返回false
        Map<Character, Character> map = new HashMap<>(); //存放映射
        for(int i = 0; i < t.length(); i++){
            if(!map.containsKey(s.charAt(i))){ //1. 没有映射时执行
                if(map.containsValue(t.charAt(i)))
                    return false; //2. 没有映射的情况下s[i]已被使用（表示匹配了别的pattern，匹配错了），则不匹配返回false
                map.put(s.charAt(i), t.charAt(i)); //3. 构建映射（先到先匹配的原则）
            }else{
                if(!map.get(s.charAt(i)).equals(t.charAt(i)))
                    return false; //当前字符串与映射不匹配,返回false
            }
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        return isIsomorphicHelper(s).equals(isIsomorphicHelper(t));
    }

    private String isIsomorphicHelper(String s) {
        int[] map = new int[128];
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //当前字母第一次出现,赋值
            if (map[c] == 0) {
                map[c] = count;
                count++;
            }
            sb.append(map[c]);
        }
        return sb.toString();
    }

    public boolean isIsomorphic3(String s, String t) {
        char[] sArr = s.toCharArray(), tArr = t.toCharArray();
        if (sArr.length!=tArr.length)
            return false;

        char[] mapS = new char[128];
        boolean[] mapT = new boolean[128];

        for (int i = 0; i < sArr.length; i++) {
            if (mapS[sArr[i]] != '\0' ||mapT[tArr[i]] == true) {//默认mapS[sArr[i]] == '\0'
                if (mapS[sArr[i]] != tArr[i])
                    return false;
            }
            else {
                mapS[sArr[i]] = tArr[i];
                mapT[tArr[i]] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsIsomorphic_205().isIsomorphic3("egg","add"));
    }
}
