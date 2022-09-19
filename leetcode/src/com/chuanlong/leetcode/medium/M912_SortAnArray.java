package com.chuanlong.leetcode.medium;

public class M912_SortAnArray {
    public int[] sortArray(int[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length-1);
        return nums;
    }

    private void sort(int[] nums, int s, int e) {
        if(s>=e) return;
        // int mid = partition(nums, i, j)
        int key = nums[s];
        int i=s, j=e;

        while(i<j) {
            while(i<j && nums[j]>=key) j--;
            if(i<j) nums[i] = nums[j];
            while(i<j && nums[i]<=key) i++;
            if(i<j) nums[j] = nums[i];
        }
        nums[i] = key;
        int m = i;
        sort(nums, s, m-1);
        sort(nums, m+1, e);
    }

    private void shuffle(int[] nums) {
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0 ; i < n; i++) {
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
