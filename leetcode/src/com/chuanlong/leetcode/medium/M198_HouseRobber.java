package com.chuanlong.leetcode.medium;

public class M198_HouseRobber {

    public boolean isValidSudoku(char[][] board) {

        // row
        for(int i=0; i<9; i++) {
            boolean[] visited = new boolean[9];
            for(int j=0; j<9; j++) {
                char ch = board[i][j];
                if(ch >= '1' && ch <= '9') {
                    if(visited[ch-'1']) return false;
                    visited[ch-'1'] = true;
                }
            }
        }

        // column
        for(int j=0; j<9; j++) {
            boolean[] visited = new boolean[9];
            for(int i=0; i<9; i++) {
                char ch = board[i][j];
                if(ch >= '1' && ch <= '9') {
                    if(visited[ch-'1']) return false;
                    visited[ch-'1'] = true;
                }
            }
        }

        for(int i=0; i<9; i=i+3) {
            for(int j=0; j<9; j=j+3) {
                boolean[] visited = new boolean[9];
                for(int x=i; x<i+3; x++) {
                    for(int y=j; y<j+3; y++) {
                        char ch = board[x][y];
                        if(ch >= '1' && ch <= '9') {
                            if(visited[ch-'1']) return false;
                            visited[ch-'1'] = true;
                        }
                    }
                }
            }
        }


        return true;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] a = new int[n];
        int[] b = new int[n];
        a[0] = 0;
        b[0] = nums[0];
        for(int i=1; i<n; i++) {
            a[i] = Math.max(a[i-1], b[i-1]);
            b[i] = a[i-1] + nums[i];
        }
        return Math.max(a[n-1], b[n-1]);
    }
}
