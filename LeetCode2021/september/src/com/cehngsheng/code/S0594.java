package com.cehngsheng.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ssqswyf
 * @date 2021/9/27
 */
public class S0594 {
    public static int findLHS(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (counts.containsKey(nums[i])){
                counts.put(nums[i],counts.get(nums[i])+1);
            } else {
                counts.put(nums[i],1);
            }
            Object playerId;
            int p = counts.getOrDefault(nums[i]-1, 0);
            int q = counts.getOrDefault(nums[i]+1, 0);
            if (p+q>0){
                res = Math.max(res, Math.max(p, q)+ counts.get(nums[i]));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findLHS(new int[]{1,3,2,2,5,2,3,7}));
    }
}
