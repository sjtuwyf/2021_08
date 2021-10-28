package com.cehngsheng.code;


import java.util.*;

/**
 * @author ssqswyf
 * @date 2021/10/12
 */
public class S1337 {
    public static int[] kWeakestRows(int[][] mat, int k) {
        int length = mat.length;
        List<int[]> ints = new ArrayList<>();
        int n = 0;
        int[] ints1 = new int[2];
        for (int i = 0; i < length; i++) {
            n=0;
            for (int j : mat[i]) {
                if (j==1){
                    n++;
                } else {
                    break;
                }
            }

            ints1[0]=i;
            ints1[1]=n;
            ints.add(ints1);

        }
        int tr0 = 0;
        int tr1 = 0;
        Collections.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]==o2[1]){
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });
        for (int[] anInt : ints) {
            System.out.println(anInt[0]);
        }
        int[] array = ints.stream().mapToInt(t -> t[0]).limit(k).toArray();
        return array;
    }

    public static void main(String[] args) {

    }
}
