package com.chuanlong.leetcode.medium;

public class M516_LongestPalindromicSubsequence {


    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        char[] chs1 = s.toCharArray();
        char[] chs2 = new StringBuilder(s).reverse().toString().toCharArray();
        int[][] dp = new int[n+1][n+1];

        for(int i=0; i<=n; i++) {
            for(int j=0; j<=n; j++) {
                if(i==0 || j== 0) {
                    dp[i][j] = 0;
                } else {
                    if(chs1[i-1] == chs2[j-1]) {
                        dp[i][j] = dp[i-1][j-1]+1;
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }

        return dp[n][n];
    }

}
