package com.leetcode;

/**
 * @Author ssqswyf
 * @Date 2021/9/1
 */
public class _0810 {
    public static void main(String[] args) {

    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (newColor == color) {
            return image;
        }
        recursion(image, sr, sc, newColor,color);
        return image;
    }
    public static void recursion(int[][] image, int sr, int sc, int newColor, int color) {
        if(sr<0||sr>=image.length||sc<0||sc>=image[sr].length||image[sr][sc]!=color){
            return;
        }
        image[sr][sc] = newColor;
        recursion(image, sr-1, sc, newColor, color);
        recursion(image, sr+1, sc, newColor, color);
        recursion(image, sr, sc-1, newColor, color);
        recursion(image, sr, sc+1, newColor, color);
        return;
    }
}
