package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.util.Util;

public class M503_NextGreaterElementII {

    public static void main(String[] args) {
        M503_NextGreaterElementII obj = new M503_NextGreaterElementII();

        System.out.println("Test1, expect:[2,-1,2], output:" + Util.Array2String(obj.nextGreaterElements(new int[]{1,2,1})));
        System.out.println("Test2, expect:[-1,-1,-1,-1,-1], output:" + Util.Array2String(obj.nextGreaterElements(new int[]{1,1,1,1,1})));
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nexts = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            nexts[i] = -1;
            max = Math.max(max, nums[i]);
        }

        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            int j = nextGreaterIndex(nums, nexts, i, max);
            if(j==i) result[i] = -1;
            else result[i] = nums[j];
        }
        return result;
    }

    private int nextGreaterIndex(int[] nums, int[] nexts, int i, int max) {
        if(nums[i] == max) return i;
        if(nexts[i] != -1) return nexts[i];
        int j = (i+1) % nums.length;
        while(nums[j]<=nums[i]) {
            if(j==i) {
                nexts[i] = i;
                return i;
            }
            int next = nextGreaterIndex(nums, nexts, j, max);
            if(next == j) {
                nexts[i] = i;
                return i;
            } else {
                j=next;
            }
        }
        nexts[i] = j;
        return j;
    }

}
