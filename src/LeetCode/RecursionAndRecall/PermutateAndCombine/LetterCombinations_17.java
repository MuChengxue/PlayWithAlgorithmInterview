package LeetCode.RecursionAndRecall.PermutateAndCombine;

import java.util.*;

public class LetterCombinations_17 {
    public static String[] letterMap = new String[]{
            " ",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz",
    };
    //##########################################################################################
    public static String[] letterMap2 = {
            " ",
            "",
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };
    List<String> res = new ArrayList<>();

    private static List<String> getStringWithFor(String[] digit, int i, List<String> list, String stemp) {

        if (i < digit.length - 1) {
            for (int j = 0; j < digit[i].length(); j++) {
                list = getStringWithFor(digit, i + 1, list, stemp + digit[i].charAt(j));
            }
            i++;
        } else {
            for (int j = 0; j < digit[i].length(); j++) {
                list.add(stemp + digit[i].charAt(j));
            }
        }

        return list;
    }

    //###############################################################################################
    public static List<String> letterCombinations3(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }

        Queue<String> queue = new LinkedList<String>();
        int j = 0;
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "");
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        map.put("0", " ");

        String s = map.get(Character.toString(digits.charAt(j)));
        for (int i = 0; i < s.length(); i++) {
            queue.offer(s.substring(i, i + 1));
        }
        j++;
        while (j < digits.length()) {
            String s1 = map.get(Character.toString(digits.charAt(j)));
            while (queue.element().length() < j + 1) {
                String s2 = queue.poll();
                for (int i = 0; i < s1.length(); i++) {
                    queue.offer(s2 + s1.substring(i, i + 1));
                }
            }
            j++;
        }

        while (queue.peek() != null) {
            res.add(queue.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations_17().letterCombinations("234"));
    }

    //###############################################################################################
    public List<String> letterCombinations(String digits) {
        res.clear();
        if (digits.length() == 0)
            return res;

        findCombination(digits, 0, "");

        return res;
    }

    //s中保存了此时从digits [0 ... index-1]翻译得到的一个字母字符串
    //寻找和digits[index]匹配的字母，获得digits[0 ... index]翻译得到的结果
    private void findCombination(String digits, int index, String s) {
        System.out.println(index + ":" + s);
        if (index == digits.length()) {
            //保存S
            res.add(s);
            System.out.println("get " + s + ", return");
            return;
        }

        char c = digits.charAt(index);
//        if (c>='0'&&c<='9'&&c!='1'){}
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            System.out.println("digits[" + index + "]=" + c + ", use " + letters.charAt(i));
            findCombination(digits, index + 1, s + letters.charAt(i));
        }
        System.out.println("digits[" + index + "]=" + c + "complete, return");

    }

    public List<String> letterCombinations4(String digits) {

        LinkedList<String> resultlist = new LinkedList<>();
        if (digits.length() == 0)
            return resultlist;

        if (digits != null) {
            appendString(0, digits, new StringBuilder(), resultlist);
        }
        return resultlist;
    }

    public void appendString(int i, String digits, StringBuilder unit, LinkedList reslist) {
        if (unit.length() == digits.length()) {
            reslist.addLast(unit.toString());
            return;
        }

        char curdigit = digits.charAt(i);
        String curLetters = letterMap2[curdigit - '0'];
        for (int j = 0; j < curLetters.length(); j++) {
            unit.append(curLetters.charAt(j));
            appendString(i + 1, digits, unit, reslist);
            unit.deleteCharAt(unit.length() - 1);
        }

    }

    //###################################################################################################
    public List<String> letterCombinations2(String digits) {

        List<String> list = new ArrayList<>();
        if (digits.length() == 0) {
            return list;
        }

        String[] digit = new String[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            switch (digits.charAt(i)) {
                case '2':
                    digit[i] = "abc";
                    break;
                case '3':
                    digit[i] = "def";
                    break;
                case '4':
                    digit[i] = "ghi";
                    break;
                case '5':
                    digit[i] = "jkl";
                    break;
                case '6':
                    digit[i] = "mno";
                    break;
                case '7':
                    digit[i] = "pqrs";
                    break;
                case '8':
                    digit[i] = "tuv";
                    break;
                case '9':
                    digit[i] = "wxyz";
                    break;
            }
        }
        list = getStringWithFor(digit, 0, list, "");
        return list;
    }
}
