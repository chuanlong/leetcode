package com.chuanlong.leetcode.medium;

import java.util.PriorityQueue;

public class M1102_PathWithMaximumMinimumValue {

    public int maximumMinimumPath(int[][] grid) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0]) {
                if(a[1] == b[1]) {
                    return b[2] - a[2];
                } else return b[1]-a[1];
            }
            else return b[0]-a[0];
        });
        int m = grid.length, n = grid[0].length;
        queue.add(new int[]{grid[0][0], 0, 0});
        int score = Math.min(grid[0][0], grid[m-1][n-1]);
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            score = Math.min(score, point[0]);
            if((point[1]+1==m-1 && point[2]==n-1) || (point[1]==m-1 && point[2]+1==n-1)) break;
            pushQueue(queue, visited, grid, point[1]-1, point[2]);
            pushQueue(queue, visited, grid, point[1]+1, point[2]);
            pushQueue(queue, visited, grid, point[1], point[2]-1);
            pushQueue(queue, visited, grid, point[1], point[2]+1);
        }
        return score;
    }

    private void pushQueue(PriorityQueue<int[]> queue, boolean[][] visited, int[][] grid, int x, int y) {
        if(x<0 || x>= grid.length || y<0 || y>=grid[0].length) return;
        if(visited[x][y]) return;
        queue.add(new int[]{grid[x][y], x, y});
        visited[x][y] = true;
    }
}
