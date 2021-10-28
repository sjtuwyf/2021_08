package com.cehngsheng.code;

import java.util.Arrays;

/**
 * @author ssqswyf
 * @date 2021/9/20
 */
public class M0673 {

    public static void main(String[] args) {
//        System.out.println(findNumberOfLISContinuity(new int[]{1,3,5,4,7}));
        System.out.println(findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
    }


    public static int findNumberOfLIS(int[] nums) {
        int length = nums.length;
        int[][] helpers = new int[length][2];
        //以nums[i]结尾最长链的个数
        helpers[0][0] = 1;
        //以nums[i]结尾最长链的长度
        helpers[0][1] = 1;

        for (int i = 1; i < length; i++) {
            helpers[i][0] = 1;
            helpers[i][1] = 1;
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]) {
                    if (helpers[j][1] + 1 > helpers[i][1]) {
                        helpers[i][0] = helpers[j][0];
                        helpers[i][1] = helpers[j][1] + 1;

                    } else if (helpers[j][1] + 1 == helpers[i][1]) {
                        helpers[i][0] += helpers[j][0];

                    } else {

                    }

                }
            }
        }
        for (int[] ints : helpers) {
            System.out.println(Arrays.toString(ints));
        }

        int maxLength = 0;
        int maxNum = 0;
        for (int i = 0; i < length; i++) {
            if (helpers[i][1] > maxLength) {
                maxLength = helpers[i][1];
                maxNum = helpers[i][0];
            }else if(helpers[i][1] ==maxLength ){
                maxNum+= helpers[i][0];
            } else {

            }
        }
        return maxNum;

    }

    public static int findNumberOfLISContinuity(int[] nums) {
        int length = nums.length;
        int[][] helper = new int[length][5];
        //包含尾部是否最长链
        helper[0][0] = 1;
        //尾部链长
        helper[0][1] = 1;
        //最长链个数
        helper[0][2] = 1;
        //最长链长度
        helper[0][3] = 1;

        for (int i = 1; i < length; i++) {

            if (nums[i] > nums[i-1]) {



                helper[i][1] = helper[i-1][1] + 1;
                if (helper[i][1] < helper[i-1][3]) {
                    helper[i][0] = 0;
                    helper[i][2] = helper[i-1][2];
                    helper[i][3] = helper[i-1][3];

                } else if (helper[i][1] == helper[i-1][3]) {
                    helper[i][0] = 1;
                    helper[i][2] = helper[i-1][2] + 1;
                    helper[i][3] = helper[i-1][3];
                } else {
                    helper[i][0] = 1;
                    helper[i][2] = 1;
                    helper[i][3] = helper[i][1];
                }

            }
            else {
                helper[i][1] = 1;
                if (helper[i][1] < helper[i-1][3]) {
                    helper[i][0] = 0;
                    helper[i][2] = helper[i-1][2];
                    helper[i][3] = helper[i-1][3];

                } else if (helper[i][1] == helper[i-1][3]) {
                    helper[i][0] = 1;
                    helper[i][2] = helper[i-1][2] + 1;
                    helper[i][3] = helper[i-1][3];
                } else {
                    helper[i][0] = 1;
                    helper[i][2] = 1;
                    helper[i][3] = helper[i][1];
                }
            }
        }
        for (int[] ints : helper) {
            System.out.println(Arrays.toString(ints));
        }

        return helper[length-1][2];


        }


    }
