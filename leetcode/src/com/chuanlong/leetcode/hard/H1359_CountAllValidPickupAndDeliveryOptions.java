package com.chuanlong.leetcode.hard;

public class H1359_CountAllValidPickupAndDeliveryOptions {
    public int countOrders(int n) {
        int MOD = 1000000007;
        long[] x = new long[n+1];
        x[0] = 0;
        x[1] = 1;

        for(int i=2; i<=n; i++) {
            x[i] = (x[i-1] * ( i * (2*i-1))) % MOD;
        }
        return (int)x[n];
    }
}
