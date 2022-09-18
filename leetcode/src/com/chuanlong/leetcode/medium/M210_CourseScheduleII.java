package com.chuanlong.leetcode.medium;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class M210_CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[] cnt = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<prerequisites.length; i++) {
            // u -> v
            int u = prerequisites[i][0], v = prerequisites[i][1];
            cnt[u]++;
            if(!map.containsKey(v)) map.put(v, new ArrayList<>());
            map.get(v).add(u);
        }

        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        for(int i=0; i<n; i++) {
            if(cnt[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()) {
            int x = queue.poll();
            list.add(x);

            for(Integer next : map.getOrDefault(x, new ArrayList<>())) {
                if(cnt[next] == 1) {
                    cnt[next] = 0;
                    queue.add(next);

                } else if(cnt[next] > 1){
                    cnt[next]--;
                }
            }
        }

        if(list.size() == n) {
            int[] result = new int[n];
            for(int i=0; i<n; i++) {
                result[i] = list.get(i);
            }
            return result;
        } else {
            return new int[0];
        }
    }
}
