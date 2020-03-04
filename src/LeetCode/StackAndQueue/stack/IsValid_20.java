package LeetCode.StackAndQueue.stack;

import java.util.Stack;

public class IsValid_20 {
    public boolean isValid(String s) {
        if (s.length()%2!=0||s==null)
            return false;
        Stack stack=new Stack();

        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else {
                if (stack.isEmpty())
                    return false;

                char c= (char) stack.pop();
                char match='\0';

                if (s.charAt(i)==')'){
                    match='(';
                }else if (s.charAt(i)=='}'){
                    match='{';
                }else if (s.charAt(i)==']'){
                    match='[';
                }

                if (c!=match) {
                    return false;
                }
            }

        }
        if (!stack.isEmpty())
            return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(2%2);
    }

}
