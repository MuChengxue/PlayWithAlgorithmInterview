package LeetCode.GreedyAlgorithm;

public class IsSubsequence_392 {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(new IsSubsequence_392().isSubsequence(s, t));
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        return i == s.length();
    }

    public boolean isSubsequence2(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);//子序列，保证s在t中的相对顺序
            if (index == -1)
                return false;
        }
        return true;
    }
}
