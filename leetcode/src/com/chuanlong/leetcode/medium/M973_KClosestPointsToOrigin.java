package com.chuanlong.leetcode.medium;

import java.util.PriorityQueue;

public class M973_KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        // [distance, x, y]
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0]-a[0]);
        for(int i=0; i<points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            if(queue.size() < k) {
                queue.offer(new int[]{x*x+y*y, x, y});
            } else {
                int[] top = queue.peek();
                if(top[0] > x*x+y*y) {
                    queue.poll();
                    queue.offer(new int[]{x*x+y*y, x, y});
                }
            }
        }
        int[][] result = new int[k][2];
        for(int i=0; i<k; i++) {
            int[] top = queue.poll();
            result[i][0] = top[1];
            result[i][1] = top[2];
        }
        return result;
    }

}
