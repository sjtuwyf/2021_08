package com.cehngsheng.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ssqswyf
 * @date 2021/10/5
 */
public class M1769 {

    public static int[] minOperations(String boxes) {
        ArrayList<Integer> integers = new ArrayList<>();
        int length = boxes.length();
        for (int i = 0; i < length; i++) {
            if (boxes.charAt(i) == '1') {
                integers.add(i);
            }
        }
        int[] ints = new int[length];
        int n = 0;
        for (int i = 0; i < ints.length; i++) {
            n = 0;
            for (int j = 0; j < integers.size(); j++) {
                n += Math.abs(integers.get(j) - i);
            }
            ints[i] = n;
        }
        return ints;

    }

    public static void main(String[] args) {
        int[] ints = minOperations("110");
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
