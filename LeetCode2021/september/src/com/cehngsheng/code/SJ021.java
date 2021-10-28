package com.cehngsheng.code;

import java.util.Arrays;

/**
 * @author ssqswyf
 * @date 2021/9/23
 */
public class SJ021 {

    public static int[] exchange(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int header = 0;
        int tail = length-1;

        for (int num : nums) {
            if (num % 2 == 1) {
                result[header] = num;
                header++;
            }
            else {
                result[tail] = num;
                tail--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(exchange(new int[]{1, 2, 3, 4})));
    }
}
