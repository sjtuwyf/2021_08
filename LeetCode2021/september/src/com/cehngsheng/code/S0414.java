package com.cehngsheng.code;

import java.util.HashSet;

/**
 * @author ssqswyf
 * @date 2021/10/6
 */
public class S0414 {

    public static int thirdMax(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = Integer.MIN_VALUE;
        if (set.size() < 3) {
            for (Integer integer : set) {
                max = integer > max ? integer : max;
            }
            return max;
        }
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        for (Integer integer : set) {
            if (integer > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = integer;
            } else if (integer > secondMax) {
                thirdMax = secondMax;
                secondMax = integer;
            } else if (integer > thirdMax) {
                thirdMax = integer;
            } else {

            }
        }
        return thirdMax;

    }

    public static void main(String[] args) {
        int i = thirdMax(new int[]{3, 2, 1});
        System.out.println(i);
    }
}
