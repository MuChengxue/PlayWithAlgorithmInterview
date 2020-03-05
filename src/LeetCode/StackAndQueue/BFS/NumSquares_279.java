package LeetCode.StackAndQueue.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class NumSquares_279 {
    public static void main(String[] args) {
        boolean[] v = new boolean[2];
        for (boolean b : v) {
            System.out.println(b);//false
        }
    }

    //7168  超出时间限制：会将重复冗余的元素推入queue
    public int numSquares(int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{n, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int num = cur[0];
            int step = cur[1];

            if (num == 0)
                return step;
            for (int i = 1; num - i * i >= 0; i++)
                queue.offer(new int[]{num - i * i, step + 1});
        }

        return -1;
    }

    //##############################################################################################################
    public int numSquares2(int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{n, 0});

        boolean[] visited = new boolean[n + 1];
        visited[n] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int num = cur[0];
            int step = cur[1];


            for (int i = 1; ; i++) {
                int a = num - i * i;
                if (a < 0)
                    break;
                if (a == 0)
                    return step + 1;
                if (!visited[a]) {
                    queue.offer(new int[]{a, step + 1});
                    visited[a] = true;
                }
            }
        }

        return -1;
    }

    //#############################################################################################################
    public int numSquares3(int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(n, 0));

        boolean[] visited = new boolean[n + 1];
        visited[n] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int num = cur.val;
            int step = cur.step;


            for (int i = 1; ; i++) {
                int a = num - i * i;
                if (a < 0)
                    break;
                if (a == 0)
                    return step + 1;
                if (!visited[a]) {
                    queue.offer(new Node(a, step + 1));
                    visited[a] = true;
                }
            }
        }

        return -1;
    }

    class Node {
        int val;
        int step;

        public Node(int val, int step) {
            this.val = val;
            this.step = step;
        }
    }
}
