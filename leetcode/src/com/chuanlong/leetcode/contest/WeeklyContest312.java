package com.chuanlong.leetcode.contest;

import java.util.ArrayList;
import java.util.List;

public class WeeklyContest312 {
    public String[] sortPeople(String[] names, int[] heights) {
        sort(names, heights, 0, heights.length-1);
        return names;
    }

    // sort descending
    private void sort(String[] names, int[] heights, int s, int e) {
        if(s>=e) return;

        int key = heights[s];
        String name = names[s];
        int i=s, j=e;
        while(i<j) {
            while(i<j && heights[j] <= key) j--;
            if(i<j) {
                heights[i] = heights[j];
                names[i] = names[j];
                i++;
            }
            while(i<j && heights[i] >= key) i++;
            if(i<j) {
                heights[j] = heights[i];
                names[j] = names[i];
                j--;
            }
        }
        heights[i] = key;
        names[i] = name;
        sort(names, heights, s, i-1);
        sort(names, heights, i+1, e);
    }


    public int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxCnt = 0;
        int cnt = 0;
        boolean flag = false;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
                maxCnt = 1;
                cnt = 1;
                flag = true;
            } else if (nums[i] == max) {
                if(flag) {
                    cnt++;
                } else {
                    cnt = 1;
                    flag = true;
                }
            } else {
                if(flag) {
                    maxCnt = Math.max(maxCnt, cnt);
                    cnt = 0;
                    flag = false;
                }
            }
        }
        if(flag) maxCnt = Math.max(maxCnt, cnt);
        return maxCnt;
    }

    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> goods = new ArrayList<>();
        int n = nums.length;
        if(k==1) {
            for(int i=k; i<n-k; i++) goods.add(i);
        } else {
            int i=0, j=1, p=0, q=0;
            while(i<n-k) {
                if(j<i+1)j=i+1;
                while(j<n && nums[j]<=nums[j-1] && j-i+1<k) j++;
                if(j<n && nums[j]<=nums[j-1] && j-i+1==k) {
                    p = j+2;
                    if(q<p+1) q=p+1;
                    while(q<n && nums[q]>=nums[q-1] && q-p+1<k) q++;
                    if (q<n && nums[q]>=nums[q-1] && q-p+1==k) {
                        goods.add(j+1);
                    }
                    i++;
                } else {
                    i=j;
                }
            }
        }
        return goods;
    }

}
