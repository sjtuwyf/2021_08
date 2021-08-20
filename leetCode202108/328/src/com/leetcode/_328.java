package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ssqswyf
 * @Date 2021/8/17
 */
public class _328 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("leetcode"));
    }

    public static int firstUniqChar(String s) {

        Map<Character,Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.keySet().contains(c)) {
                map.put(c, -1);
            }
            else {
                map.put(c, i);
            }
        }

        int min = -1;
        for (Integer value : map.values()) {
            if (value > -1){
                if (min == -1){
                    min = value;
                } else {
                    min = Math.min(min, value);
                }

            }
        }
        return min;
    }
}
