package com.chuanlong.leetcode.medium;

public class M6193_MaximumSumOfAnHourglass {
    public int maxSum(int[][] grid) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<grid.length-2; i++) {
            for(int j=0; j<grid[0].length-2; j++) {
                max = Math.max(max, sumHourglass(grid, i, j));
            }
        }
        return max;
    }

    private int sumHourglass(int[][] grid, int x, int y) {
        return grid[x][y]+grid[x][y+1]+grid[x][y+2]+grid[x+1][y+1]+grid[x+2][y]+grid[x+2][y+1]+grid[x+2][y+2];
    }
}
