package com.chuanlong.leetcode.medium;

public class M2419_LongestSubarrayWithMaximumBitwiseAND {
    public int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxCnt = 0;
        int cnt = 0;
        boolean flag = false;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
                maxCnt = 1;
                cnt = 1;
                flag = true;
            } else if (nums[i] == max) {
                if(flag) {
                    cnt++;
                } else {
                    cnt = 1;
                    flag = true;
                }
            } else {
                if(flag) {
                    maxCnt = Math.max(maxCnt, cnt);
                    cnt = 0;
                    flag = false;
                }
            }
        }
        if(flag) maxCnt = Math.max(maxCnt, cnt);
        return maxCnt;
    }
}
