package com.chuanlong.leetcode.easy;

public class E2229_CheckIfAnArrayIsConsecutive {
    public boolean isConsecutive(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int min = nums[0];
        for(int i=1; i<nums.length; i++) min = Math.min(min, nums[i]);
        for(int i=0; i<nums.length; i++) {
            if(nums[i]-min>=nums.length || visited[nums[i]-min]) return false;
            visited[nums[i]-min] = true;
        }
        return true;
    }
}
