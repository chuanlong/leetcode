package com.chuanlong.leetcode.medium;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class M1730_ShortestPathToGetFood {

    public int getFood(char[][] grid) {
        int m=grid.length, n=grid[0].length;
        int[] start = null;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] =='*') {
                    start = new int[]{i, j};
                    break;
                }
            }
            if(start != null) break;
        }

        Queue<int[]> queue = new LinkedBlockingQueue();
        boolean[][] visited = new boolean[m][n];
        queue.add(start);
        visited[start[0]][start[1]] = true;
        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] point = queue.poll();
                if(check(grid, queue, visited, point[0]-1, point[1])) return step+1;
                if(check(grid, queue, visited, point[0]+1, point[1])) return step+1;
                if(check(grid, queue, visited, point[0], point[1]-1)) return step+1;
                if(check(grid, queue, visited, point[0], point[1]+1)) return step+1;
            }
            step++;
        }
        return -1;
    }

    private boolean check(char[][] grid, Queue<int[]> queue, boolean[][] visited, int x, int y) {
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length) return false;
        if(visited[x][y]) return false;
        if(grid[x][y] == '#') return true;
        if(grid[x][y] == 'O') {
            queue.add(new int[]{x,y});
        }
        visited[x][y] = true;
        return false;
    }

}
