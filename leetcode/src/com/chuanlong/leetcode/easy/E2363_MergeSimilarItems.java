package com.chuanlong.leetcode.easy;

import java.util.*;

public class E2363_MergeSimilarItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<items1.length; i++) {
            int value = map.getOrDefault(items1[i][0], 0);
            value += items1[i][1];
            map.put(items1[i][0], value);
        }
        for(int i=0; i<items2.length; i++){
            int value = map.getOrDefault(items2[i][0], 0);
            value += items2[i][1];
            map.put(items2[i][0], value);
        }
        Object[] keys= map.keySet().toArray();
        Arrays.sort(keys);
        for(int i=0; i<keys.length; i++){
            list.add(Arrays.asList((int)keys[i], map.get(keys[i])));
        }
        return list;
    }
}
