package com.chuanlong.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class M2406_DivideIntervalsIntoMinimumNumberOfGroups {

    // 50:57, 2 errors, discussion.
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) {
                return a[1]-b[1];
            } else {
                return a[0]-b[0];
            }
        });

        Queue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<intervals.length; i++) {
            int x = intervals[i][0];
            int y = intervals[i][1];
            if(!queue.isEmpty() && queue.peek() < x) {
                queue.poll();
            }
            queue.add(y);
        }
        return queue.size();
    }
}
