package com.chuanlong.leetcode.hard;

public class M2414_LengthOfTheLongestAlphabeticalContinuousSubstring {
    public int longestContinuousSubstring(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length;

        int[] a = new int[n];
        int[] b = new int[n];

        a[0] = 0;
        b[0] = 1;
        for(int i=1; i<n; i++) {
            a[i] = Math.max(a[i-1], b[i-1]);
            if(chs[i]-chs[i-1] == 1) {
                b[i] = b[i-1]+1;
            } else {
                b[i] = 1;
            }
        }

        return Math.max(a[n-1], b[n-1]);
    }
}
