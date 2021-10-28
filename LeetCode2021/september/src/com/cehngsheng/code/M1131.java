package com.cehngsheng.code;

/**
 * @author ssqswyf
 * @date 2021/10/8
 */
public class M1131 {
    public static int maxAbsValExpr(int[] arr1, int[] arr2) {
        int length = arr1.length;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int i1 = Math.abs(arr1[i] - arr1[j]) + Math.abs(arr2[i] - arr2[j]) + Math.abs(i - j);
                result = i1>result?i1 : result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int i = maxAbsValExpr(new int[]{1, 2, 3, 4}, new int[]{-1, 4, 5, 6});
        System.out.println(i);
    }
}
