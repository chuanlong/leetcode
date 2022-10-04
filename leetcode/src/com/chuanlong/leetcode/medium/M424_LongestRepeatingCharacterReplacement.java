package com.chuanlong.leetcode.medium;

public class M424_LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int[] cnt = new int[26];
        int i=0,j=0;
        int n = s.length();
        char[] chs = s.toCharArray();
        int max = 1;
        while(i<n) {
            int maxCh = 0;
            int sum = 0;
            for(int l=0;l<26;l++) {
                if(cnt[l] > cnt[maxCh]) maxCh = l;
                sum += cnt[l];
            }

            if(sum-cnt[maxCh]<=k) {
                max = Math.max(max, j-i);
                if(j>=n) break;
                cnt[chs[j]-'A']++;
                j++;
            } else {
                // sum-cnt[maxCh]>k
                cnt[chs[i]-'A']--;
                i++;
            }
        }
        return max;
    }
}
