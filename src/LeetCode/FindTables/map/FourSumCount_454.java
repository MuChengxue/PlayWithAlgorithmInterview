package LeetCode.FindTables.map;

import java.util.HashMap;
import java.util.Map;
public class FourSumCount_454 {

    //数据规模最大500个,可以考虑O(n^2)的算法，只用记录符合的结果的个数
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<A.length;i++){
            for (int j=0;j<B.length;j++){
                map.put(A[i]+B[j],map.getOrDefault(A[i]+B[j],0)+1);
            }
        }

        int match=0;
        int tmp=0;
        for (int i=0;i<C.length;i++){
            for (int j=0;j<D.length;j++){
                if ( map.containsKey(0-C[i]-D[j])){
                    match+=map.get(0-C[i]-D[j]);
                }
            }
        }

        return match;
    }
}
