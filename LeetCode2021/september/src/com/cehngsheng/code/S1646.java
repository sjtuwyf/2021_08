package com.cehngsheng.code;

import java.util.Arrays;

/**
 * @author ssqswyf
 * @date 2021/9/11
 */
public class S1646 {
    public static void main(String[] args) {
        System.out.println(new S1646().getMaximumGenerated(15));
    }
    public int getMaximumGenerated(int n) {
        if (n < 2) {
            return n;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            if (i % 2 == 0) {
                nums[i] = nums[i/2];
            } else {
                nums[i] = nums[i/2]+nums[i/2 +1];
            }
        }
        return Arrays.stream(nums).max().getAsInt();

    }
}
