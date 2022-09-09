package com.chuanlong.leetcode.contest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WeeklyContest304 {

    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int operations = 0;
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]-sum > 0) {
                operations++;
                sum = nums[i];
            }
        }
        return operations;
    }

    public int maximumGroups(int[] grades) {
        int n = grades.length;
        // o(n) = o(n-1) + n
        int k = 1;
        int ok = 1;
        while(true) {
            if(ok <= n && n < (ok+k+1)) {
                return k;
            }
            ok = ok+k+1;
            k++;
        }
    }

}
