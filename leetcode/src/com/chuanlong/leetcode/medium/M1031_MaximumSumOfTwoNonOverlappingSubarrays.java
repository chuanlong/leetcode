package com.chuanlong.leetcode.medium;

public class M1031_MaximumSumOfTwoNonOverlappingSubarrays {

    public static void main(String[] args) {
        M1031_MaximumSumOfTwoNonOverlappingSubarrays obj = new M1031_MaximumSumOfTwoNonOverlappingSubarrays();

        System.out.println("Test1, expect: 20, output:" + obj.maxSumTwoNoOverlap(new int[]{0,6,5,2,2,5,1,9,4}, 1, 2));
        System.out.println("Test2, expect: 29, output:" + obj.maxSumTwoNoOverlap(new int[]{3,8,1,3,2,1,8,9,0}, 3, 2));
        System.out.println("Test3, expect: 31, output:" + obj.maxSumTwoNoOverlap(new int[]{2,1,5,6,0,9,5,0,3,8}, 4, 3));
    }

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        if(nums.length == firstLen+secondLen) {
            int sum = 0;
            for(int i=0; i<nums.length; i++) {
                sum+= nums[i];
            }
            return sum;
        }
        int max1 = maxSumTwoNoOverlap1(nums, firstLen, secondLen);
        int max2 = maxSumTwoNoOverlap1(nums, secondLen, firstLen);
        return Math.max(max1, max2);
    }


    public int maxSumTwoNoOverlap1(int[] nums, int firstLen, int secondLen) {
        int n = nums.length-firstLen-secondLen+1;
        int[] x = new int[n];
        int sum = 0;
        for(int i=0; i<firstLen; i++) {
            sum+= nums[i];
        }
        x[0] = sum;
        for(int i=1; i<n; i++) {
            sum = sum + nums[firstLen+i-1] - nums[i-1];
            x[i] = Math.max(x[i-1], sum);
        }

        int[] y = new int[n];
        sum = 0;
        for(int i=nums.length-1; i>nums.length-1-secondLen; i--) {
            sum += nums[i];
        }
        y[0] = sum;
        for(int i=1; i<n; i++) {
            sum = sum - nums[nums.length-i] + nums[nums.length-i-secondLen];
            y[i] = Math.max(y[i-1], sum);
        }

        sum = x[0]+y[n-1];
        for(int i=1; i<n; i++){
            sum = Math.max(sum, x[i] + y[n-1-i]);
        }
        return sum;
    }


}
