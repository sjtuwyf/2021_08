package com.leetcode;

import java.util.HashMap;

/**
 * @Author ssqswyf
 * @Date 2021/8/29
 */
public class _0102 {
    public static void main(String[] args) {
        System.out.println(new _0102().CheckPermutation("abb", "cba"));

    }
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()){
            return false;
        }
        HashMap<Character,Integer> count = new HashMap<>();
        for (int i = 0;i < s1.length();i++) {
            if (!count.containsKey(s1.charAt(i))){
                count.put(s1.charAt(i), 1);
            } else {
                Integer integer = count.get(s1.charAt(i)) + 1;
                count.put(s1.charAt(i),integer);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (!count.containsKey(s2.charAt(i))) {
                return false;
            } else {
                if (count.get(s2.charAt(i))!=1){
                    Integer integer = count.get(s2.charAt(i)) - 1;
                    count.put(s2.charAt(i),integer );
                } else {
                    count.remove(s2.charAt(i));
                }
            }

        }

        return count.isEmpty();

    }


}
