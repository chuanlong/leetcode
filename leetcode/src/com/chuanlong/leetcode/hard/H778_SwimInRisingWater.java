package com.chuanlong.leetcode.hard;

import java.util.PriorityQueue;

public class H778_SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        // [elevation, x, y]
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        queue.offer(new int[]{grid[0][0], 0, 0});
        int time = grid[n-1][n-1];
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            time = Math.max(time, point[0]);
            boolean done = pushQueue(queue, visited, grid, n, point[1]-1, point[2]);
            if(!done) done = pushQueue(queue, visited, grid, n, point[1]+1, point[2]);
            if(!done) done = pushQueue(queue, visited, grid, n, point[1], point[2]-1);
            if(!done) done = pushQueue(queue, visited, grid, n, point[1], point[2]+1);
            if(done) break;
        }
        return time;
    }

    // return isfound
    private boolean pushQueue(PriorityQueue<int[]> queue, boolean[][] visited, int[][] grid, int n, int x, int y) {
        if(x==n-1 && y==n-1) return true;
        if(x<0 || x>=n || y<0 || y>=n) return false;
        if(visited[x][y]) return false;
        visited[x][y] = true;
        queue.offer(new int[]{grid[x][y], x, y});
        return false;
    }
}
