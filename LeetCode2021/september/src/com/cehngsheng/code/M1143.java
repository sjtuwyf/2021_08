package com.cehngsheng.code;

/**
 * @author ssqswyf
 * @date 2021/9/25
 */
public class M1143 {

    public static int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();

        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 0; i < length2 + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < length1 + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < length1 + 1; i++) {
            for (int j = 1; j < length2 + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[length1][length2];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
}
