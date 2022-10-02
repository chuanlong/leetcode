package com.chuanlong.leetcode.medium;

public class M1155_NumberOfDiceRollsWithTargetSum {

    int MOD = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] mem = new Integer[n+1][target+1];
        return num(mem, 0, n, k, 0, target);
    }

    private int num(Integer[][] mem, int index, int n, int k, int sum, int target) {
        if(index == n) {
            if(sum == target) return 1;
            else return 0;
        }

        if(mem[index][sum] != null) return mem[index][sum];

        int pos = 0;
        for(int i=1; i<=k && sum+i<=target; i++) {
            pos = (pos + num(mem, index+1, n, k, sum+i, target)) % MOD;
        }
        mem[index][sum] = pos;
        return pos;
    }

}
