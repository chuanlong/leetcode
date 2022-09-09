package com.chuanlong.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class M2365_TaskSchedulerII {

    public long taskSchedulerII(int[] tasks, int space) {
        long days = 0;
        Map<Integer, Long> map = new HashMap<>();
        for(int i=0; i< tasks.length; i++) {
            days++;
            int type = tasks[i];
            if(map.containsKey(type)) {
                days = Math.max(days, map.get(type)+space+1);
            }
            map.put(type, days);
        }
        return days;
    }
}
