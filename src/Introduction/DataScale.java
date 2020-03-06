package Introduction;

public class DataScale {
    public static void main(String[] args) {
        for (int i=1;i<10;i++){
            int n= (int) Math.pow(10,i);
//            System.out.println(n);
            long start=System.currentTimeMillis();
            int sum=0;
            for (int j=0;j<n;j++){
                sum+=j;
            }
            long time=(System.currentTimeMillis()-start);
            System.out.println("10^"+i+":"+time+"ms"+"  "+sum);
        }
    }
}
