package com.cehngsheng.code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ssqswyf
 * @date 2021/10/1
 */
public class S1436 {
    public static String destCity(List<List<String>> paths) {
        Map<String,Integer> map = new HashMap<>();
        for (List<String> path : paths) {
            map.put(path.get(0), 1);
            if (!map.containsKey(path.get(1))) {
                map.put(path.get(1), 0);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(0)){
                return entry.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
