package com.chuanlong.leetcode.medium;

import com.sun.org.apache.xml.internal.utils.StringComparable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class M1143_LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] grid = new int[m+1][n+1];
        char[] chs1 = text1.toCharArray();
        char[] chs2 = text2.toCharArray();

        for(int i=0; i<m+1; i++) {
            for(int j=0; j<n+1; j++) {
                if(i==0 || j==0) {
                    grid[i][j] = 0;
                } else if(chs1[i-1] == chs2[j-1]) {
                    grid[i][j] = grid[i-1][j-1] + 1;
                } else {
                    grid[i][j] = Math.max(grid[i-1][j], grid[i][j-1]);
                }
            }
        }

        return grid[m][n];
    }

    // TLE
    public int longestCommonSubsequence1(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] grid = new int[m+1][n+1];
        char[] chs1 = text1.toCharArray();
        char[] chs2 = text2.toCharArray();

        for(int i=0; i<m+1; i++) {
            for(int j=0; j<n+1; j++) {
                if(i==0 || j==0) {
                    grid[i][j] = 0;
                } else if(chs1[i-1] == chs2[j-1]) {
                    grid[i][j] = grid[i-1][j-1] + 1;
                } else {
                    grid[i][j] = Math.max(grid[i-1][j], grid[i][j-1]);
                }
            }
        }
        return grid[m][n];
    }



}
