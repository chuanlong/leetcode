package com.chuanlong.leetcode.medium;

public class M2405_OptimalPartitionOfString {
    public int partitionString(String s) {
        int partition = 1;
        int[] counts = new int[26];
        cleanup(counts);
        char[] chs = s.toCharArray();
        for(int i=0; i<chs.length; i++) {
            if(counts[chs[i]-'a'] > 0) {
                partition++;
                cleanup(counts);
            }
            counts[chs[i]-'a'] = 1;
        }
        return partition;
    }

    private void cleanup(int[] counts) {
        for(int i=0; i<counts.length; i++) {
            counts[i] = 0;
        }
    }
}
