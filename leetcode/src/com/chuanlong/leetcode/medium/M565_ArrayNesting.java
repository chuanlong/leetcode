package com.chuanlong.leetcode.medium;

public class M565_ArrayNesting {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int max = 1;
        for(int i=0; i<n; i++) {
            int len = 0;
            int k = i;
            while(!visited[k]) {
                visited[k] = true;
                k = nums[k];
                len++;
            }
            max = Math.max(max, len);
        }
        return max;
    }
}
