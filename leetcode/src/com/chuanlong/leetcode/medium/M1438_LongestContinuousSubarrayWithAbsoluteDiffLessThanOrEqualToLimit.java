package com.chuanlong.leetcode.medium;

import java.util.TreeMap;

public class M1438_LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public int longestSubarray(int[] nums, int limit) {
        int longest = Integer.MIN_VALUE;
        int i=0, j=1;
        int n = nums.length;
        // num -> cnt
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(nums[0], 1);
        while(i<n) {
            if(map.lastKey()-map.firstKey()<=limit) {
                longest = Math.max(longest, j-i);
                if(j>=n) break;
                int cnt = map.getOrDefault(nums[j], 0);
                map.put(nums[j], cnt+1);
                j++;
            } else {
                int removedKey = nums[i++];
                int cnt = map.get(removedKey);
                if(cnt == 1) map.remove(removedKey);
                else map.put(removedKey, cnt-1);
            }
        }
        return longest;
    }
}
