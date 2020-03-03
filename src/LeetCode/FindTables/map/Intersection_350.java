package LeetCode.FindTables.map;

import java.util.*;

public class Intersection_350 {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        List<Integer> resList = new ArrayList<>();

        for (int num1 : nums1) {
            map1.put(num1, map1.getOrDefault(num1, 0) + 1);
        }

        for (int num2 : nums2) {
            map2.put(num2, map2.getOrDefault(num2, 0) + 1);
        }

        for (int num : map2.keySet()) {
            if (map1.containsKey(num) && map1.get(num).intValue() <= map2.get(num).intValue()) {
                for (int i = 0; i < map1.get(num); i++) {
                    resList.add(num);
                }
            } else if (map1.containsKey(num) && map1.get(num).intValue() > map2.get(num).intValue()) {
                for (int i = 0; i < map2.get(num); i++) {
                    resList.add(num);
                }
            }
        }

        int[] res = new int[resList.size()];
        int i = 0;
        for (int a : resList) {
            res[i++] = a;
        }

//        Iterator itr=resSet.iterator();
//        while (itr.hasNext()){
//            res[i++]= (int) itr.next();
//        }

        return res;

    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        List<Integer> resList = new ArrayList<>();

        for (int num1 : nums1) {
            map1.put(num1, map1.getOrDefault(num1, 0) + 1);
        }
        for (int num2 : nums2) {
            if (map1.containsKey(num2) && map1.get(num2) > 0) {
                resList.add(num2);
                map1.put(num2, map1.get(num2) - 1);
            }
        }

        int[] res = new int[resList.size()];
        int i = 0;
        for (int num : resList) {
            res[i++] = num;
        }
        return res;
    }

    public int[] intersection3(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int k=0;
        for (int i=0,j=0;i<nums1.length&&j<nums2.length;){
            if (nums1[i]<nums2[j]){
                i++;
            }else if (nums1[i]>nums2[j]){
                j++;
            }else {
                nums1[k++]=nums1[i++];
                j++;
            }
        }

        return Arrays.copyOfRange(nums1,0,k);
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        for (int num : new Intersection_350().intersection(nums1, nums2)) {
            System.out.println(num);
        }
    }
}
