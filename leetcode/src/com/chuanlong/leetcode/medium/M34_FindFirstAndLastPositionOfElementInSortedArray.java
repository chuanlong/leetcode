package com.chuanlong.leetcode.medium;

public class M34_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int s=0, e=nums.length-1;

        while(s<e) {
            int m = (s+e)/2;
            if(nums[m] == target) {
                e = m;
            } else if(nums[m] < target){
                s = m+1;
            } else {
                e = m-1;
            }
        }
        int left;
        if(s>=0 && s<nums.length && nums[s] == target) left = s;
        else return new int[]{-1, -1};

        s = left;
        e = nums.length-1;
        while(s<e) {
            int m = (s+e)/2;
            if(nums[m] == target) {
                if(m+1 == nums.length || nums[m+1] != target) {
                    s = m;
                    e = m;
                } else {
                    s = m+1;
                }
            } else if(nums[m] < target) {
                s = m+1;
            } else {
                e = m-1;
            }
        }
        int right = s;

        return new int[]{left, right};
    }
}
