package com.chuanlong.leetcode.medium;

public class M1044_MaxConsecutiveOnes3 {

    public int longestOnes(int[] nums, int k) {
        int longest = 0;
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                if(count < k) {
                    count++;
                } else {
                    break;
                }
            }
            longest++;
        }
        int max = longest;
        int index = 0;
        while(index + longest < nums.length) {
            if(nums[index] == 1) {
                longest--;
            } else {
                while(index+1+longest < nums.length && nums[index+1+longest] == 1) {
                    longest++;
                }
            }
            index++;
            max = max > longest ? max : longest;
        }
        return max;
    }


}
