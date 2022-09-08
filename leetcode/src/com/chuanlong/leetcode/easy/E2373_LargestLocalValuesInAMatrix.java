package com.chuanlong.leetcode.easy;

public class E2373_LargestLocalValuesInAMatrix {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] max = new int[n-2][n-2];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++){
                check(i-2, j-2, grid[i][j], max);
                check(i-1, j-2, grid[i][j], max);
                check(i, j-2, grid[i][j], max);

                check(i-2, j-1, grid[i][j], max);
                check(i-1, j-1, grid[i][j], max);
                check(i, j-1, grid[i][j], max);

                check(i-2, j, grid[i][j], max);
                check(i-1, j, grid[i][j], max);
                check(i, j, grid[i][j], max);
            }
        }
        return max;
    }

    private void check(int i, int j, int value, int[][] max) {
        int m = max.length;
        if(i>=0 && i<m && j>=0 && j<m) max[i][j] = Math.max(max[i][j], value);
    }
}
