package org.example;

import java.util.Arrays;

/**
 * @Author ssqswyf
 * @Date 2021/8/16
 */
public class Test334 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(increasingTriplet(nums));
    }
    public static boolean increasingTriplet(int[] nums) {

        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int[] lMin = new int[n];
        int[] rMax = new int[n];
        int min = nums[0];
        int max = nums[n-1];
        for (int i = 0; i < n; ++i) {
            if (nums[i] < min){
                min = nums[i];
            }
            lMin[i] = min;
        }
        for (int i = n-1; i > -1; --i) {
            if (nums[i] > max) {
                max = nums[i];
            }
            rMax[i] = max;
        }
        System.out.println(Arrays.toString(lMin));
        System.out.println(Arrays.toString(rMax));
        for (int i = 1; i < n-1; ++i) {
            if (lMin[i-1] < nums[i] && nums[i] < rMax[i+1]) {
                return true;
            }
        }
        return false;

    }
}
