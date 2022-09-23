package com.chuanlong.leetcode.easy;

public class E463_IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int bords = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    bords += isBord(grid, i-1, j);
                    bords += isBord(grid, i+1, j);
                    bords += isBord(grid, i, j-1);
                    bords += isBord(grid, i, j+1);
                }
            }
        }
        return bords;
    }

    private int isBord(int[][] grid, int x, int y) {
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length) return 1;
        if(grid[x][y] == 0) return 1;
        return 0;
    }

}
