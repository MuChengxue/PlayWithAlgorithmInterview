package LeetCode.FindTables.map;

import java.util.Arrays;
import java.util.HashMap;

public class IsAnagram_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length())
            return false;
        HashMap<Character,Integer> sMap=new HashMap<>();

        for (char cs:s.toCharArray()){
            sMap.put(cs,sMap.getOrDefault(cs,0)+1);
        }

        for (char ct:t.toCharArray()){
            if (sMap.containsKey(ct)&&sMap.get(ct)>0){
                sMap.put(ct,sMap.get(ct)-1);
            }else {
                return false;
            }
        }

        return true;

    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }


    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s=new String("ab");
        String t=new String("a");
        System.out.println(new IsAnagram_242().isAnagram(s,t));

    }
}
