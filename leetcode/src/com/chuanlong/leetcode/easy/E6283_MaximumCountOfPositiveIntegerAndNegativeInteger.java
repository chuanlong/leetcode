package com.chuanlong.leetcode.easy;

public class E6283_MaximumCountOfPositiveIntegerAndNegativeInteger {

    public int maximumCount(int[] nums) {
        int countNeg, countPos;

        int n = nums.length;
        int i=0, j=n-1;
        while(i<j) {
            int mid = i+(j-i)/2;
            if(nums[mid]>=0) j=mid-1;
            else if(i==mid){
                if(nums[j]>=0) j=i;
                else i=j;
            }
            else i=mid;
        }
        if(i==j && nums[i]<0) countNeg=i+1;
        else countNeg=0;

        i=0;
        j=n-1;
        while(i<j) {
            int mid = i+(j-i)/2;
            if(nums[mid]<=0) i=mid+1;
            else j=mid;
        }
        if(i==j && nums[i]>0) countPos = n-i;
        else countPos = 0;

        return Math.max(countNeg, countPos);
    }


}
