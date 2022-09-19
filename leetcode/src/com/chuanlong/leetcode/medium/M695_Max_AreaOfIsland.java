package com.chuanlong.leetcode.medium;

public class M695_Max_AreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        max = 0;
        sum = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, i, j);
                    max = Math.max(max, sum);
                    sum = 0;
                }
            }
        }
        return max;
    }

    private int max;
    private int sum;
    private void dfs(int[][] grid, int x, int y) {
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length) return;
        if(grid[x][y] == 0) return;

        sum++;
        grid[x][y] = 0;
        dfs(grid, x-1, y);
        dfs(grid, x+1, y);
        dfs(grid, x, y-1);
        dfs(grid, x, y+1);
    }
}
