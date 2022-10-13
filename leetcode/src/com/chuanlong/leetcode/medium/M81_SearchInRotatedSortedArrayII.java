package com.chuanlong.leetcode.medium;

public class M81_SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }

    private boolean search(int[] nums, int i, int j, int target) {
        if(i>j) return false;
        if(i==j) return nums[i] == target;

        int m = i + (j-i)/2;
        if(nums[i] == target) return true;
        if(nums[j] == target) return true;
        else if (nums[i] < target) {
            // int 1st array
            if(nums[m] == nums[i]) return search(nums, i+1, j, target);
            else if (nums[m] < nums[i]) {
                return search(nums, i+1, m-1, target);
            } else {
                // nums[m] > nums[i]
                if(nums[m] == target) return true;
                else if (nums[m] < target) return search(nums, m+1, j, target);
                else return binarySearch(nums, i+1, m-1, target);
            }

        } else {
            // nums[i] > target, in 2nd array
            if(nums[m] == nums[j]) return search(nums, i, j-1, target);
            else if (nums[m] > nums[j]) return search(nums, m+1, j-1, target);
            else {
                // nums[m] < nums[j]
                if(nums[m] == target) return true;
                else if (nums[m] < target) return binarySearch(nums, m+1, j-1, target);
                else return search(nums, i, m-1, target);
            }
        }
    }

    private boolean binarySearch(int[] nums, int i, int j, int target) {
        if(i>j) return false;
        int m=i+(j-i)/2;
        if(nums[m] == target) return true;
        if(nums[m] < target) return binarySearch(nums, m+1, j, target);
        else return binarySearch(nums, i, m-1, target);
    }
}
