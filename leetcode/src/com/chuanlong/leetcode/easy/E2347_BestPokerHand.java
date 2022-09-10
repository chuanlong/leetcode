package com.chuanlong.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class E2347_BestPokerHand {
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
}
