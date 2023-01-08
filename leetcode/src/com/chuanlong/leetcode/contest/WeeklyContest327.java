package com.chuanlong.leetcode.contest;

public class WeeklyContest327 {

    public static void main(String[] args) {

        WeeklyContest327 obj = new WeeklyContest327();

        System.out.println("Test1, expect:3, output:" + obj.maximumCount(new int[]{-2,-1,-1,1,2,3}));
        System.out.println("Test2, expect:3, output:" + obj.maximumCount(new int[]{-3,-2,-1,0,0,1,2}));
        System.out.println("Test3, expect:4, output:" + obj.maximumCount(new int[]{5,20,66,1314}));

    }

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


    public long maxKelements(int[] nums, int k) {

    }


}
