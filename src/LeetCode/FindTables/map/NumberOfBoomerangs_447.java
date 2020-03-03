package LeetCode.FindTables.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NumberOfBoomerangs_447 {
    public int numberOfBoomerangs(int[][] points) {

        int res=0;
        for (int i=0;i<points.length;i++){
            Map<Integer,Integer> map=new HashMap<>();
            for (int j=0;j<points.length;j++){
                if (j!=i){
                    int dis=calDis(points[i],points[j]);
                    map.put(dis,map.getOrDefault(dis,0)+1);
                }
            }
            Iterator itr=map.keySet().iterator();
            while (itr.hasNext()){
                int cnt=map.get(itr.next());
                res+=cnt*(cnt-1);
            }

        }

        return res;
    }

    private int calDis(int[] i,int[] j){
        return (int) (Math.pow(i[0]-j[0],2)+Math.pow(i[1]-j[1],2));
    }

    public static void main(String[] args) {
    }
}
