package com.chuanlong.leetcode.easy;

public class E2367_NumberOfArithmeticTriplets {
    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        for(int j=1; j<nums.length-1; j++) {
            for(int i=j-1, k=j+1; i>=0 && k<nums.length; ) {
                int diff1 = nums[j]-nums[i];
                int diff2 = nums[k]-nums[j];
                if(diff1 > diff || diff2 > diff) break;
                if(diff1 == diff && diff2 == diff) {
                    count++;
                    i--;
                    k++;
                } else if(diff1 < diff2) {
                    i--;
                } else {
                    // diff1 > diff2
                    k++;
                }
            }
        }
        return count;
    }
}
