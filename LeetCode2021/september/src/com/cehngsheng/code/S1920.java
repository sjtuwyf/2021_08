package com.cehngsheng.code;

import java.util.Arrays;

/**
 * @author ssqswyf
 * @date 2021/9/11
 */
public class S1920 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new S1920().buildArray(new int[]{0, 2, 1, 5, 3, 4})));
    }

    public int[] buildArray(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
