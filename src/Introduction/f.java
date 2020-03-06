package Introduction;

public class f {
    //2^n 递归
    public static int f(int n){
        if (n==0){
            return 1;
        }
        return f(n-1)+f(n-1);
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            System.out.println(f(i));
        }
    }
}
