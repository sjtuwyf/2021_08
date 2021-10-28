package com.cehngsheng.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ssqswyf
 * @date 2021/10/22
 */
public class M0229 {

    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i:nums){
            if (map.containsKey(i)){
                map.put(i, map.get(i)+1);
            } else {
                map.put(i,1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Integer integer : map.keySet()) {
            if (map.get(integer)> nums.length/3){
                list.add(integer);
            }
        }
        return list;

    }
}
