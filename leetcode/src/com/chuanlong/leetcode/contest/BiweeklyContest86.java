package com.chuanlong.leetcode.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 10:50 minutes, 0 error
public class BiweeklyContest86 {

    // 2395. Find Subarrays With Equal Sum
    public boolean findSubarrays(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i=1; i<nums.length; i++) {
            int sum = nums[i] + nums[i-1];
            if(map.containsKey(sum)) {
                return true;
            } else {
                map.put(sum, true);
            }
        }
        return false;
    }


    // 2396. Strictly Palindromic Number
    public boolean isStrictlyPalindromic(int n) {
        for(int i=2; i<=n-2; i++) {
            List<Integer> list = new ArrayList<>();
            int x = n;
            while(x > 0) {
                list.add(0, x%i);
                x = x/i;
            }
            if(!isPalindromic(list)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromic(List<Integer> list) {
        for(int i=0; i<list.size(); i++) {
            if(list.get(i) != list.get(list.size()-1-i)) {
                return false;
            }
        }
        return true;
    }

}
