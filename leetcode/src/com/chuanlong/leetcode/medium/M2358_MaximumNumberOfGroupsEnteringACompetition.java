package com.chuanlong.leetcode.medium;

public class M2358_MaximumNumberOfGroupsEnteringACompetition {
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
