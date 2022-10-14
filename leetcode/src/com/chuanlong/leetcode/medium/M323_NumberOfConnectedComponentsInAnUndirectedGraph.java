package com.chuanlong.leetcode.medium;

public class M323_NumberOfConnectedComponentsInAnUndirectedGraph {

    public int countComponents(int n, int[][] edges) {
        int cnt = n;
        int[] parents = new int[n];
        for(int i=0; i<n; i++) parents[i] = i;
        for(int i=0; i<edges.length; i++) {
            int[] edge = edges[i];
            int parent1 = findParent(parents, edge[0]);
            int parent2 = findParent(parents, edge[1]);
            if(parent1 != parent2) {
                parents[parent1] = parent2;
                cnt--;
            }
        }
        return cnt;
    }

    private int findParent(int[] parents, int q) {
        int p = parents[q];
        while(p != q) {
            q = p;
            p = parents[q];
        }
        return p;
    }


}
