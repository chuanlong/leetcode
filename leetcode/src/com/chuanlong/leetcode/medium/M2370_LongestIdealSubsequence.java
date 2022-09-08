package com.chuanlong.leetcode.medium;

public class M2370_LongestIdealSubsequence {

    public int longestIdealString(String s, int k) {
        int[] longest = new int[26];
        for(int i=0; i<26; i++) {
            longest[i] = 0;
        }

        char[] chs = s.toCharArray();
        for(int i=0; i<chs.length; i++) {
            char ch = chs[i];
            int longestCh = longest[ch - 'a'];
            for(int j=0; j<26; j++) {
                char chx = ((char)('a'+j));
                int distance = Math.abs(chx - ch);
                if(distance != 0 && distance<=k) {
                    longestCh = Math.max(longestCh, longest[j]);
                }
            }
            longest[ch-'a'] = longestCh+1;
        }

        int max = 0;
        for(int i=0; i<26; i++) {
            max = Math.max(longest[i], max);
        }
        return max;
    }

}
