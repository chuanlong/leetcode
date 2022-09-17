package com.chuanlong.leetcode.unassign;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        LongestCommonSubstring obj = new LongestCommonSubstring();

        System.out.println("Test1, expect:3, output:" + obj.longestCommonString("abcdefg", "cde"));
        System.out.println("Test2, expect:2, output:" + obj.longestCommonString("abcdefg", "acdfg"));
        System.out.println("Test3, expect:10, output:" + obj.longestCommonString("OldSite:GeeksforGeeks.org", "NewSite:GeeksQuiz.com"));

    }

    public int longestCommonString(String text1, String text2) {
        int m=text1.length(), n=text2.length();
        int[][] grid = new int[m+1][n+1];
        char[] chs1 = text1.toCharArray();
        char[] chs2 = text2.toCharArray();

        int max = 0;
        for(int i=0; i<m+1; i++) {
            for(int j=0; j<n+1; j++) {
                if (i == 0 || j == 0) {
                    grid[i][j] = 0;
                } else if (chs1[i - 1] == chs2[j - 1]) {
                    grid[i][j] = grid[i - 1][j - 1] + 1;
                    max = Math.max(max, grid[i][j]);
                } else {
                    grid[i][j] = 0;
                }
            }
        }
        return max;
    }
}
