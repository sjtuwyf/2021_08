package com.cehngsheng.code;

/**
 * @author ssqswyf
 * @date 2021/10/11
 */
public class S0747 {

    public static int dominantIndex(int[] nums) {
        int length = nums.length;
        if (length<2){
            return 0;
        }
        int maxValue = -1;
        int maxIndex = -1;
        int secondMaxValue = -1;
        int secondMaxIndex = -1;
        for (int i = 0; i < length; i++) {
            if (nums[i]>maxValue){
                secondMaxValue = maxValue;
                secondMaxIndex = maxIndex;
                maxValue = nums[i];
                maxIndex = i;
            } else if (nums[i]>secondMaxValue){
                secondMaxValue = nums[i];
                secondMaxIndex = i;
            }

        }
        if (maxValue>=2*secondMaxValue) {
            return maxIndex;
        }
        return -1;


    }

    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{3, 6, 1, 0}));
        System.out.println(dominantIndex(new int[]{1,2,3,4}));

    }
}
