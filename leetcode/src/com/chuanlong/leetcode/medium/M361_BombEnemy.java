package com.chuanlong.leetcode.medium;

public class M361_BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];

        // up
        for(int j=0; j<n; j++) {
            int cnt = 0;
            for(int i=0; i<m; i++) {
                if(grid[i][j] == 'W') cnt = 0;
                else if (grid[i][j] == 'E') cnt++;
                else if(grid[i][j] == '0') up[i][j] = cnt;
            }
        }

        // down
        for(int j=0; j<n; j++) {
            int cnt = 0;
            for(int i=m-1; i>=0; i--) {
                if(grid[i][j] == 'W') cnt = 0;
                else if (grid[i][j] == 'E') cnt++;
                else if(grid[i][j] == '0') down[i][j] = cnt;
            }
        }

        // left
        for(int i=0; i<m; i++) {
            int cnt = 0;
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 'W') cnt = 0;
                else if (grid[i][j] == 'E') cnt++;
                else if(grid[i][j] == '0') left[i][j] = cnt;
            }
        }

        // right
        for(int i=0; i<m; i++) {
            int cnt = 0;
            for(int j=n-1; j>=0; j--) {
                if(grid[i][j] == 'W') cnt = 0;
                else if (grid[i][j] == 'E') cnt++;
                else if(grid[i][j] == '0') right[i][j] = cnt;
            }
        }

        int max = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) max = Math.max(max, up[i][j]+down[i][j]+left[i][j]+right[i][j]);
        }
        return max;
    }
}
