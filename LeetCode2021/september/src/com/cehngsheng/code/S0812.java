package com.cehngsheng.code;

/**
 * @Author ssqswyf
 * @Date 2021/9/7
 */
public class S0812 {


    public double largestTriangleArea(int[][] points) {
        int length = points.length;
        double ans = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    ans = Math.max(ans, area(points[i], points[j], points[k]));
                }
            }
        }
        return ans;
    }

    private double area(int[] point0, int[] point1, int[] point2) {
        return 0.5 * Math.abs(point0[0] * point1[1] + point1[0] * point2[1] + point2[0] * point0[1]
                - point0[1] * point1[0] - point1[1] * point2[0] - point2[1] * point0[0]);
    }

}
