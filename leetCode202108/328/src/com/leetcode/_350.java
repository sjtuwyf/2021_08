package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ssqswyf
 * @Date 2021/8/18
 */
public class _350 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2,1};
        int[] nums2 = new int[]{1,1};
        int[] ints = intersect(nums1, nums2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i],1);
            } else {
                map.put(nums1[i],map.get(nums1[i])+1);
            }
        }
        System.out.println(map);
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                if (map.get(nums2[i]) == 1) {
                    integerList.add(nums2[i]);
                    map.remove(nums2[i]);
                } else {
                    integerList.add(nums2[i]);
                    map.put(nums2[i],map.get(nums2[i])-1 );
                }
            }
        }
        System.out.println(map);
        for (int i = 0; i < integerList.size(); i++) {
            System.out.println(integerList.get(i));
        }
        int[] array = integerList.stream().mapToInt(i -> i).toArray();
        return array;
    }
}
