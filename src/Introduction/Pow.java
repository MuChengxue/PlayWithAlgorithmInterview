package Introduction;

public class Pow {

    //    log n
    public static double pow(double x,int n){
        if (n==0){
            return 1;
        }else if (n>0){
             double t=pow(x,n/2);
             if (n%2!=0){
                 return x*t*t;
             }
             return t*t;
        }else {
            return 1/pow(x,-n);
        }
    }

    public static void main(String[] args) {
        System.out.println(        pow(2,-3));
    }
}
