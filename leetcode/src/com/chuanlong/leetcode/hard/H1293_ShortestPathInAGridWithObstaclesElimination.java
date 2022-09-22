package com.chuanlong.leetcode.hard;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class H1293_ShortestPathInAGridWithObstaclesElimination {


    // ACCEPT
    public int shortestPath(int[][] grid, int k) {
        if(grid.length == 1 && grid[0].length == 1) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] visited = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) visited[i][j] = -1;
        }


        // [x, y, k]
        Queue<int[]> queue = new LinkedBlockingQueue<>();
        queue.offer(new int[]{0, 0, k});
        visited[0][0] = k;
        int step = 0;
        while(queue.size()>0) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] point = queue.poll();
                boolean reached = false;
                if(!reached) reached = queue(queue, grid, visited, point[0]-1, point[1], point[2]);
                if(!reached) reached = queue(queue, grid, visited, point[0]+1, point[1], point[2]);
                if(!reached) reached = queue(queue, grid, visited, point[0], point[1]-1, point[2]);
                if(!reached) reached = queue(queue, grid, visited, point[0], point[1]+1, point[2]);
                if(reached) return step+1;
            }
            step++;
        }

        return -1;
    }

    private boolean queue(Queue<int[]> queue, int[][] grid, int[][] visited, int x, int y, int k) {
        if(x == grid.length-1 && y == grid[0].length-1) return true;
        if(k<0) return false;
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length) return false;

        if(grid[x][y] == 1) {
            if(visited[x][y] < k-1) {
                queue.offer(new int[]{x, y, k-1});
                visited[x][y] = k-1;
            }
        } else {
            if(visited[x][y] < k) {
                queue.offer(new int[]{x, y, k});
                visited[x][y] = k;
            }
        }
        return false;
    }



    // TLE
    public int shortestPath1(int[][] grid, int k) {
        min = Integer.MAX_VALUE;
        backtrack1(grid, new boolean[grid.length][grid[0].length], k, 0, 0, 0);
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }

    int min = Integer.MAX_VALUE;
    private void backtrack1(int[][] grid, boolean[][] visited, int k, int step, int x, int y) {
        if(k<0) return;
        if(step>=min) return;
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length) return;
        if(visited[x][y]) return;
        if(x == grid.length-1 && y==grid[0].length-1) {
            min = Math.min(min, step);
            return;
        }

        if(grid[x][y] == 1) {
            visited[x][y] = true;
            backtrack1(grid, visited, k-1, step+1, x-1, y);
            backtrack1(grid, visited, k-1, step+1, x+1, y);
            backtrack1(grid, visited, k-1, step+1, x, y-1);
            backtrack1(grid, visited, k-1, step+1, x, y+1);
            visited[x][y] = false;
        } else {
            visited[x][y] = true;
            backtrack1(grid, visited, k, step+1, x-1, y);
            backtrack1(grid, visited, k, step+1, x+1, y);
            backtrack1(grid, visited, k, step+1, x, y-1);
            backtrack1(grid, visited, k, step+1, x, y+1);
            visited[x][y] = false;
        }
    }
}
