package com.chuanlong.leetcode.easy;

import com.chuanlong.leetcode.util.Util;

import java.util.HashMap;
import java.util.Map;

public class E496_NextGreaterElementI {

    public static void main(String[] args) {
        E496_NextGreaterElementI obj = new E496_NextGreaterElementI();

        System.out.println("Test1, expect:[-1,3,-1], output:" + Util.Array2String(obj.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] greater = new int[nums2.length];
        Map<Integer, Integer> indexes = new HashMap<>();
        for(int i=0; i<greater.length; i++) {
            greater[i] = -1;
            indexes.put(nums2[i], i);
        }

        int[] ans = new int[nums1.length];
        for(int i=0; i<nums1.length; i++) {
            int x = indexes.get(nums1[i]);
            int y = nextGreaterIndex(nums2, greater, x);
            if(y == x) ans[i] = -1;
            else ans[i] = nums2[y];
        }
        return ans;
    }


    private int nextGreaterIndex(int[] nums2, int[] greater, int i) {
        if(greater[i] != -1) return greater[i];
        int j=i+1;
        while(j<nums2.length) {
            if(nums2[j]>nums2[i]) {
                greater[i] = j;
                return j;
            }

            int next = nextGreaterIndex(nums2, greater, j);
            if(next == j) {
                greater[i] = i;
                return i;
            }

            j=next;
        }
        greater[i] = i;
        return i;
    }
}
