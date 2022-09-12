package com.chuanlong.leetcode.medium;

import java.util.TreeMap;

public class M1010_PairsOfSongsWithTotalDurationsDivisibleBy60 {

    // 16:47, 2 errors because WA, negative num, use long instead of int.
    public int numPairsDivisibleBy60(int[] time) {
        TreeMap<Integer, Long> map = new TreeMap<>();
        for(int i=0; i<time.length; i++) {
            long count = map.getOrDefault(time[i], 0L);
            map.put(time[i], count+1);
        }

        long sum = 0;
        int max = map.lastKey();
        int sixty = 60;
        for(int x : map.keySet()) {
            long xValue = map.get(x);
            for(int i=0; sixty*i-x <= max; i++) {
                int y = sixty*i-x;
                if(y>x && map.containsKey(y)) {
                    sum += xValue * map.get(y);
                }
            }
            if(x*2%60 == 0) {
                sum += xValue * (xValue-1) / 2;
            }
        }
        return (int)sum;
    }


}
