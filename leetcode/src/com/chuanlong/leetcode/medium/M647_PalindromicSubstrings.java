package com.chuanlong.leetcode.medium;

public class M647_PalindromicSubstrings {

    public int countSubstrings(String s) {
        int n = s.length();
        int sum = 0;
        char[] chs = s.toCharArray();
        for(int i=0; i<n; i++) {
            int b = i, e = i;
            while(b>=0 && e<n && chs[b] == chs[e]) {
                sum++;
                b--;
                e++;
            }
            b = i;
            e = i+1;
            while(b>=0 && e<n && chs[b] == chs[e]) {
                sum++;
                b--;
                e++;
            }
        }
        return sum;
    }
}
