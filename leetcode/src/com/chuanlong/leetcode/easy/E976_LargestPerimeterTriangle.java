package com.chuanlong.leetcode.easy;

import java.util.Arrays;

public class E976_LargestPerimeterTriangle {

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i=nums.length-3; i>=0; i--) {
            if(nums[i+2] < nums[i] + nums[i+1]) return nums[i]+nums[i+1]+nums[i+2];
        }
        return 0;
    }

}
