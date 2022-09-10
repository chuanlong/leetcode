package com.chuanlong.leetcode.contest;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class BiweeklyContest83 {

    public static void main(String[] args) {
        BiweeklyContest83 obj = new BiweeklyContest83();
        System.out.println("Test1, expect:Pair, output:" + obj.bestHand(new int[]{10,10,2,12,9}, new char[]{'a','b','c','a','d'}));

        System.out.println("Test2, expect:9, output:" + obj.zeroFilledSubarray(new int[]{0,0,0,2,0,0}));
    }

    public String bestHand(int[] ranks, char[] suits) {
        if(suits[0] == suits[1] && suits[1] == suits[2] && suits[2] == suits[3] && suits[3] == suits[4]) {
            return "Flush";
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<5; i++) {
            int count = map.getOrDefault(ranks[i], 0);
            map.put(ranks[i], count+1);
        }
        int max = 0;
        for(Integer key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        if(max >= 3) {
            return "Three of a Kind";
        } else if (max == 2) {
            return "Pair";
        }
        return "High Card";
    }

    public long zeroFilledSubarray(int[] nums) {
        // contiguous num, count
        Map<Integer, Integer> map = new HashMap<>();
        int contiguous0 = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                contiguous0++;
            } else {
                if(contiguous0 > 0) {
                    int count = map.getOrDefault(contiguous0, 0);
                    map.put(contiguous0, count+1);
                }
                contiguous0 = 0;
            }
        }
        if(contiguous0 > 0) {
            int count = map.getOrDefault(contiguous0, 0);
            map.put(contiguous0, count+1);
        }

        int max = 0;
        for(int key : map.keySet()) {
            max = Math.max(max, key);
        }

        long[] combinations = new long[max+1];
        combinations[0] = 0;
        for(int i=1; i<max+1; i++) {
            combinations[i] = combinations[i-1] + i;
        }

        long subarrays = 0;
        for(int key: map.keySet()) {
            subarrays += combinations[key] * map.get(key);
        }
        return subarrays;
    }


//    private int getCombintion(int k, Map<Integer, Integer> map) {
//        if(map.containsKey(k)) return map.get(k);
//        int v = getCombintion(k-1, map) + 1;
//
//    }

}
