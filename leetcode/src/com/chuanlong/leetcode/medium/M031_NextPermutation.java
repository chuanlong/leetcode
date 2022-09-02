package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.util.Util;

import java.util.ArrayList;

public class M031_NextPermutation {

    /**
     * https://leetcode.com/problems/next-permutation/
     */
    public static void main(String[] args) {

        M031_NextPermutation obj = new M031_NextPermutation();

        System.out.println("Test1, expect:2, actual:" + obj.find(new int[]{2, 4, 3, 1}, 1, 3, 2));
        System.out.println("Test2, expect:3, actual:" + obj.find(new int[]{2, 1, 4, 3}, 2, 3, 1));
        System.out.println("Test2, expect:3, actual:" + obj.find(new int[]{1, 2, 3, 4}, 3, 3, 3));

        int[] nums1 = new int[]{1, 2, 3};
        obj.nextPermutation(nums1);
        System.out.println("Test3, expect:[1,3,2], actual:" + Util.Array2String(nums1));

        int[] nums2 = new int[]{1, 5, 1};
        obj.nextPermutation(nums2);
        System.out.println("Test4, expect:[5,1,1], actual:" + Util.Array2String(nums2));


        int[] nums3 = new int[]{5, 1, 1};
        obj.nextPermutation(nums3);
        System.out.println("Test4, expect:[1,1,5], actual:" + Util.Array2String(nums3));
    }

    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;

        int i=nums.length-1;
        while(i-1 >= 0 && nums[i-1] >= nums[i]) {
            i--;
        }

        if(i == 0) {
            sortAsc(nums, 0, nums.length-1);
        } else {
            int j = find(nums, i, nums.length-1, nums[i-1]);
            int tmp = nums[j];
            nums[j] = nums[i-1];
            nums[i-1] = tmp;
            sortAsc(nums, i, nums.length-1);
        }
    }

    private int find(int[] nums, int i, int j, int value) {
        if(i==j) return i;

        int mid = (i+j)/2;
        if(nums[mid] > value) {
            if (nums[mid+1] <= value) {
                return mid;
            } else {
                return find(nums, mid+1, j, value);
            }
        } else {
            return find(nums, i, mid-1, value);
        }
    }



    private void sortAsc(int[] nums, int i, int j) {
        // it's desc order
        while (i<j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }


}
