package Chapter02;

public class Reverse {

    //n
    public static char[] reverse(String string){
        char[] str =string.toCharArray();
        int length =str.length;

        for (int i=0;i<length/2;i++){
            swap(str,i,length-1-i);
        }
        return str;

    }

    public void reverseString(char[] s) {
        int length =s.length;

        for (int i=0;i<length/2;i++){
            swap(s,i,length-1-i);
        }
    }

    private static void swap(char[] chars,int a, int b) {
        char temp=chars[a];
        chars[a]=chars[b];
        chars[b]=temp;
    }

    public static String intToString(int num){
        String s="";
        while (num!=0){
            s+='0'+num%10;
            num/=10;
        }

        return s;
    }

    public static void main(String[] args) {
        String s="abcd";
        System.out.println(reverse(s));

        System.out.println(intToString(2));
        System.out.println(Integer.toString(2));

    }
}
