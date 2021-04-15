package com.chuanlong.leetcode.easy;

public class E1800_MaximumAscendingSubarraySum {

    public static void main(String[] args) {}

    public int maxAscendingSum(int[] nums) {
        int max = -1;
        int curStart = 0;
        int curSum = nums[0];
        for(int i=1; i<nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                curSum += nums[i];
            } else {
                max = max > curSum ? max : curSum;
                curStart = i;
                curSum = nums[i];
            }
        }
        return max > curSum ? max : curSum;
    }
}
