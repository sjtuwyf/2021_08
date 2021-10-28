package com.cehngsheng.code;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ssqswyf
 * @date 2021/10/17
 */
public class S1748 {
    public static int sumOfUnique(int[] nums) {
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!a.contains(nums[i])) {
                a.add(nums[i]);
                b.add(nums[i]);
            } else {
                b.remove(nums[i]);
            }
        }
        int sum = 0;
        for (Integer integer : b) {
            sum+=integer;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOfUnique(new int[]{1, 2, 3, 2}));
    }
}
