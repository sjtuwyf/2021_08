package com.cehngsheng.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ssqswyf
 * @date 2021/9/22
 */
public class M0137 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 2, 2}));
    }
    public static int singleNumber(int[] nums) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (!set1.contains(nums[i])) {
                set1.add(nums[i]);
            } else {
                set2.add(nums[i]);
            }
        }
        for (Integer integer : set2) {
            set1.remove(integer);
        }
        for (Integer integer : set1) {
            return integer;
        }
        return 0;
    }
}
