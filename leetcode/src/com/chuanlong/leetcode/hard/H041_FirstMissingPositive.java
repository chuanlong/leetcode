package com.chuanlong.leetcode.hard;

public class H041_FirstMissingPositive {

    // 24:14 minutes, 0 error
    public int firstMissingPositive(int[] nums) {
        boolean flag = false;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] <= 0) {
                nums[i] = 1;
            } else if (nums[i] == 1) {
                flag = true;
            }
        }

        if(!flag) return 1;

        int n = nums.length;
        for(int i=0; i<n; i++) {
            int x = Math.abs(nums[i]);
            if(x-1 < n && nums[x-1] > 0) {
                nums[x-1] = 0 - nums[x-1];
            }
        }

        for(int i=0; i<n; i++) {
            if(nums[i] > 0) {
                return i + 1;
            }
        }

        return n+1;
    }

}
