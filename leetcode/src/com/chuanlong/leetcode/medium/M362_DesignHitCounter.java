package com.chuanlong.leetcode.medium;

import java.util.TreeMap;

public class M362_DesignHitCounter {
    class HitCounter {
        // <timestam,sumCnt>
        private TreeMap<Integer, Integer> map;
        private int totalCnt;

        public HitCounter() {
            map = new TreeMap<>();
            totalCnt = 0;
        }

        public void hit(int timestamp) {
            map.put(timestamp, ++totalCnt);
        }

        public int getHits(int timestamp) {
            // hit in last 300 seconds
            if(map.size() == 0) return 0;
            Integer startTimestamp = map.floorKey(timestamp-300);
            Integer lastTimestamp = map.lastKey();
            return map.get(lastTimestamp) - ((startTimestamp == null) ? 0 : map.get(startTimestamp));
        }
    }
}
