package com.chuanlong.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class E2389_LongestSubsequenceWithLimitedSum {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] queriesClone = queries.clone();
        Arrays.sort(queriesClone);
        int[] answers = new int[queriesClone.length];
        int sum = 0;
        int i=0, j=0;
        while(i<nums.length && j<queriesClone.length) {
            sum += nums[i++];
            while(j<queriesClone.length && queriesClone[j] < sum) {
                answers[j++] = i-1;
            }
        }
        while(j<queriesClone.length) {
            answers[j++] = nums.length;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int k=0; k<queries.length; k++) {
            map.put(queriesClone[k], answers[k]);
        }

        int[] newAnswer = new int[queries.length];
        for(int k=0; k<queries.length; k++) {
            newAnswer[k] = map.get(queries[k]);
        }
        return newAnswer;
    }
}
