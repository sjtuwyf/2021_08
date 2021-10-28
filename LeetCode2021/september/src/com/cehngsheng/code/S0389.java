package com.cehngsheng.code;

/**
 * @author ssqswyf
 * @date 2021/10/2
 */
public class S0389 {
    public char findTheDifference(String s, String t) {
        int[] charNum1 = new int[26];
        int[] charNum2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charNum1[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            charNum2[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < charNum1.length; i++) {
            if (charNum1[i]!=charNum2[i]){
                return (char)('a'+i);
            }
        }
        return ' ';

    }
}
