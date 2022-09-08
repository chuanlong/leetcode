package com.chuanlong.leetcode.medium;

public class M2374_NodeWithHighestEdgeScore {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] scores = new long[n];
        for(int i=0; i<n; i++) {
            scores[i] = 0;
        }

        for(int i=0; i<n; i++) {
            scores[edges[i]] = scores[edges[i]] + i;
        }

        int maxIndex = 0;
        long maxScore = scores[0];
        for(int i=1; i<n; i++) {
            if(scores[i] > maxScore) {
                maxScore = scores[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
