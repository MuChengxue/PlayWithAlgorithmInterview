package Chapter02;

public class TestDemo {

    public static void test01(){
        for (int i=10;i<=26;i++){
            int n= (int) Math.pow(2,i);
            int[] arr=TesterUtil.generateOrderedArray(n);

            float start=System.nanoTime();
            System.out.println(MyAlgorithm.binarySearch(arr,2));;
            float time=System.nanoTime()-start;

            System.out.println("data size 2^"+i+":="+n+"\t"+"time cost:"+time/1000000+"ms");
        }
    }

    public static void test02(){
        int n=10000000;
        int [] data=TesterUtil.generateOrderedArray(n);
        float start=System.nanoTime();
        for (int i=0;i<n;i++){
            if(i!=MyAlgorithm.binarySearch(data,i))
                System.out.println("Error");
        }
        float time=System.nanoTime()-start;
        System.out.println(time/1000000+"ms");
    }

    public static void test03(){
        int n=10000000;
        int [] data=TesterUtil.generateOrderedArray(n);
        float start=System.nanoTime();
        for (int i=0;i<n;i++){
            if(i!=BinarySearch.binarySearch2(data,i))
                System.out.println("Error");
        }
        float time=System.nanoTime()-start;
        System.out.println(time/1000000+"ms");
    }

    public static void main(String[] args) {
        test03();
    }
}
