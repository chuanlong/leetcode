package com.chuanlong.leetcode.hard;

public class H72_EditDistance {
    public int minDistance(String word1, String word2) {
        char[] chs1 = word1.toCharArray();
        char[] chs2 = word2.toCharArray();
        int[][] mem = new int[chs1.length+1][chs2.length+1];

        return dp(mem, chs1, chs2, chs1.length, chs2.length);
    }

    private int dp(int[][] mem, char[] chs1, char[] chs2, int i, int j) {
        if(i==0) return j;
        if(j==0) return i;
        if(mem[i][j] > 0) return mem[i][j];

        if(chs1[i-1] == chs2[j-1]) return dp(mem, chs1, chs2, i-1, j-1);

        int p1 = dp(mem, chs1, chs2, i-1, j)+1;
        int p2 = dp(mem, chs1, chs2, i, j-1)+1;
        int p3 = dp(mem, chs1, chs2, i-1, j-1)+1;

        mem[i][j] = Math.min(p1, Math.min(p2, p3));
        return mem[i][j];
    }
}
