package com.cehngsheng.code;

/**
 * @author ssqswyf
 * @date 2021/9/26
 */
public class S1385 {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        int n1 = arr1.length;
        int n2 = arr2.length;
        int result = 0;
        boolean is = false;
        for (int i = 0; i < n1; i++) {
            is = false;
            for (int j = 0; j < n2; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d){
                    is = true;
                }
                break;
            }
            if (is == true) {
                continue;
            }
            result++;
        }
        return result;

    }
}
