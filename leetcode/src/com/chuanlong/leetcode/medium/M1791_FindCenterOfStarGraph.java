package com.chuanlong.leetcode.medium;

public class M1791_FindCenterOfStarGraph {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        }else{
            return edges[0][1];
        }
    }
}
