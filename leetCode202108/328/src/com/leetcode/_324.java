package com.leetcode;

import java.util.Arrays;

/**
 * @Author ssqswyf
 * @Date 2021/8/26
 */
public class _324 {
    public static void main(String[] args) {

        int[] ints = new int[]{1,2,4,6,7};
        wiggleSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void wiggleSort(int[] nums) {

        int[] ints = nums.clone();
        Arrays.sort(ints);
        int num = nums.length;
        for (int i = 1; i < num; i+=2) {
            nums[i]= ints[--num];
        }
        for (int i = 0; i < num; i+=2) {
            nums[i]=ints[--num];
        }
    }
}
