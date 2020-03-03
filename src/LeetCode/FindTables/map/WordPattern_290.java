package LeetCode.FindTables.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordPattern_290 {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;
        Map<Object, Integer> mem = new HashMap<>();
        for (int i = 0; i < words.length; i++)
            //put返回的是oldVal,妙  ########这里是通过i建立映射并将pattern和str关联起来###########
            if (!Objects.equals(mem.put(words[i], i), mem.put(pattern.charAt(i), i)))
                return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new WordPattern_290().wordPattern("aaba", "dog cat cat dog"));
    }

    public boolean wordPattern2(String pattern, String str) {
        String[] s = str.split(" "); //以空格分隔str
        if(s.length != pattern.length())
            return false; //如果没有全部成对的映射则返回false
        Map<Character, String> map = new HashMap<>(); //存放映射
        for(int i = 0; i < pattern.length(); i++){
            if(!map.containsKey(pattern.charAt(i))){ //1. 没有映射时执行
                if(map.containsValue(s[i]))
                    return false; //2. 没有映射的情况下s[i]已被使用（表示匹配了别的pattern，匹配错了），则不匹配返回false
                map.put(pattern.charAt(i), s[i]); //3. 构建映射（先到先匹配的原则）
            }else{
                if(!map.get(pattern.charAt(i)).equals(s[i]))
                    return false; //当前字符串与映射不匹配,返回false
            }
        }
        return true;
    }

}
