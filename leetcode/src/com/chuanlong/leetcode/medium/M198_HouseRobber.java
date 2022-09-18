package com.chuanlong.leetcode.medium;

public class M198_HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] a = new int[n];
        int[] b = new int[n];
        a[0] = 0;
        b[0] = nums[0];
        for(int i=1; i<n; i++) {
            a[i] = Math.max(a[i-1], b[i-1]);
            b[i] = a[i-1] + nums[i];
        }
        return Math.max(a[n-1], b[n-1]);
    }
}
