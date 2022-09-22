package com.chuanlong.leetcode.medium;

public class M1570_DotProductOfTwoSparseVectors {
    class SparseVector {
        private int[] nums;
        SparseVector(int[] nums) {
            this.nums = nums;
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            int dot = 0;
            for(int i=0; i<nums.length; i++) {
                dot += nums[i] * vec.nums[i];
            }
            return dot;
        }
    }
}
