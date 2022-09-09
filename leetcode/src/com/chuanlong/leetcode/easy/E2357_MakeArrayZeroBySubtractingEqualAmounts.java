package com.chuanlong.leetcode.easy;

import java.util.Arrays;

public class E2357_MakeArrayZeroBySubtractingEqualAmounts {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int operations = 0;
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]-sum > 0) {
                operations++;
                sum = nums[i];
            }
        }
        return operations;
    }
}
