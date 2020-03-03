package Chapter02;

public class IsPrime {

    //logn
    public static boolean isPrime(int num){
        for (int x=2;x*x<=num;x++){
            if (num%x==0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(21));
    }
}
