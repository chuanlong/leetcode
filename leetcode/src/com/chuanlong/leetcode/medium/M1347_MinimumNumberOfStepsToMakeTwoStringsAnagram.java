package com.chuanlong.leetcode.medium;

import java.util.Arrays;

// 05:35 minutes
public class M1347_MinimumNumberOfStepsToMakeTwoStringsAnagram {

    public int minSteps(String s, String t) {
        int[] nums = new int[26];
        for(int i=0; i<nums.length; i++) {
            nums[i] = 0;
        }

        char[] chs1 = s.toCharArray();
        char[] chs2 = t.toCharArray();

        for(int i=0; i<chs1.length; i++) {
            nums[chs1[i]-'a']++;
        }

        for(int i=0; i<chs2.length; i++) {
            if(nums[chs2[i]-'a'] > 0) nums[chs2.length-'a']--;
        }

        return Arrays.stream(nums).sum();
    }
}
