package com.leetcode;

/**
 * @Author ssqswyf
 * @Date 2021/8/23
 */
public class _242 {

    public static void main(String[] args) {

    }

    public boolean isAnagram(String s, String t) {
        int[] sChar = new int[26];
        int[] tChar = new int[26];
        int n = 0;
        for(int i =0;i<s.length();++i) {
            n= s.charAt(i)-'a';
            sChar[n]++;
        }
        for(int i =0;i<t.length();++i) {
            n= t.charAt(i)-'a';
            tChar[n]++;
        }

        for (int i = 0;i<sChar.length;++i){
            if(sChar[i]!=tChar[i]){
                return false;
            }
        }
        return true;

    }
}
