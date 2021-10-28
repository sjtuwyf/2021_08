package com.cehngsheng.code;

/**
 * @Author ssqswyf
 * @Date 2021/9/9
 */
public class S1437 {
    public static void main(String[] args) {

    }

    public boolean kLengthApart(int[] nums, int k) {
        int length = nums.length;
        int a = -1;
        int b = -1;
        for (int i = 0; i < length; i++) {
            if(nums[i] == 1) {
                b = a;
                a = i;
            }
            if (b != -1 && a-b <= k) {
                return false;
            }
        }
        return true;
    }
}
