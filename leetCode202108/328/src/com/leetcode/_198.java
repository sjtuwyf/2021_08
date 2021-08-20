package com.leetcode;

import java.util.Arrays;

/**
 * @Author ssqswyf
 * @Date 2021/8/18
 */
public class _198 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 1, 1, 2}));

    }
    public static int rob(int[] nums) {
        int length = nums.length;
        int[] nums1 = new int[length];
        int[] nums2 = new int[length];

        nums1[0] = nums[0];
        nums2[0] = 0;

        for (int i = 1; i < length; ++i) {
            nums1[i] = nums2[i-1] + nums[i];
            nums2[i] = Math.max(nums1[i-1],nums2[i-1]);
        }
//        for (int i : nums1) {
//            System.out.println(i);
//        }
        System.out.println(Arrays.toString(nums));
        System.out.println("===");
        System.out.println(Arrays.toString(nums1));
        System.out.println("===");

//        for (int i : nums2) {
//            System.out.println(i);
//        }
        System.out.println(Arrays.toString(nums2));
        System.out.println("===");
        return Math.max(nums1[length-1],nums2[length-1]);

    }
}
