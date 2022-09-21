package com.chuanlong.leetcode.medium;

public class M875_KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<piles.length; i++) {
            max = Math.max(max, piles[i]);
            sum += piles[i];
        }
        int min = Integer.max(1, sum/h);
        // min<=k<=max
        return findK(piles, h, min, max);
    }

    private int findK(int[] piles, int h, int s, int e) {
        if(s > e) return -1;
        if(s == e) return s;
        int mid = (s+e)/2;

        int hours = getHours(piles, mid);
        if(hours <= h) {
            if(s == mid) {
                return s;
            } else {
                return findK(piles, h, s, mid);
            }
        } else {
            // hours > h
            return findK(piles, h, mid+1, e);
        }
    }

    private int getHours(int[] piles, int k) {
        int hours = 0;
        for(int i=0; i<piles.length; i++) {
            hours += piles[i]/k + (piles[i]%k>0 ? 1 : 0);
        }
        return hours;
    }
}
