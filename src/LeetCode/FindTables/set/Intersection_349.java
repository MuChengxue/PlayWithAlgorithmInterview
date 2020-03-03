package LeetCode.FindTables.set;

import java.util.HashSet;
import java.util.Set;

public class Intersection_349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> resSet=new HashSet<>();
        Set<Integer> set=new HashSet<Integer>();

        for (int num1 :nums1){
            set.add(num1);
        }
        for (int num2:nums2){
            if (set.contains(num2)){
                resSet.add(num2);
            }
        }

        int[] res=new int[resSet.size()];
        int i=0;
        for (int a:resSet){
            res[i++]=a;
        }

//        Iterator itr=resSet.iterator();
//        while (itr.hasNext()){
//            res[i++]= (int) itr.next();
//        }

        return res;

    }

    public static void main(String[] args) {

    }
}
