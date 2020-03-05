package LeetCode.StackAndQueue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class LambdaTest {
    public static void main(String[] args) {
        Queue queue = new PriorityQueue();
        Integer[] arr = new Integer[]{1, 5, 3, 3, 4};
//        Arrays.sort(arr,(Integer a,Integer b)->(-1));
//        Arrays.sort(arr,(Integer a,Integer b)->(0));
//        Arrays.sort(arr,(Integer a,Integer b)->(1));
        Arrays.sort(arr, (Integer a, Integer b) -> (b - a));


        for (int a : arr) {
            System.out.println(a);
        }
//        new Thread(() -> System.out.println("Hello world !")).start();

        // 使用 lambda expression
//        Runnable race1 = () -> System.out.println("Hello world !");
        // 直接调用 run 方法(没开新线程哦!)
//        race1.run();
    }


}

