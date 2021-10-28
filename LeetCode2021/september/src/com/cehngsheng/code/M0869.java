package com.cehngsheng.code;

/**
 * @author ssqswyf
 * @date 2021/10/28
 */
public class M0869 {
    public boolean reorderedPowerOf2(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        int[] intsn = new int[10];
        for (int i=0;i<len;i++) {
            intsn[s.charAt(i)-'0']++;
        }


        return true;
    }
}
