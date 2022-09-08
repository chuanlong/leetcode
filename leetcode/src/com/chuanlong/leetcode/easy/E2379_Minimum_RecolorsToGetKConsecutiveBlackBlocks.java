package com.chuanlong.leetcode.easy;

public class E2379_Minimum_RecolorsToGetKConsecutiveBlackBlocks {

    public int minimumRecolors(String blocks, int k) {
        char[] chs = blocks.toCharArray();
        int sumBlacks = 0;
        int i=0, j=0;
        for(; j<k; j++) {
            if(chs[j] == 'B') sumBlacks++;
        }

        int min = k-sumBlacks;
        while(min > 0 && j<chs.length) {
            if(chs[i++] == 'B') sumBlacks--;
            if(chs[j++] == 'B') sumBlacks++;
            min = Math.min(k-sumBlacks, min);
        }

        return min;
    }
}
