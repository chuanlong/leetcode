package com.chuanlong.leetcode.medium;

public class M1578_MinimumTimeToMakeRopeColorful {

    public int minCost(String colors, int[] neededTime) {
        char[] chs = colors.toCharArray();
        int n = chs.length;
        int i=0, j=1;
        int totalCost = 0;
        while(j<n) {
            if(chs[j] != chs[i]) {
                if(j-1 > i) totalCost += cost(neededTime, i, j-1);
                i=j;
                j=j+1;
            } else {
                j++;
            }
        }
        if(j-1>i) totalCost += cost(neededTime, i, j-1);
        return totalCost;
    }


    private int cost(int[] neededTime, int i, int j) {
        int max = neededTime[i];
        int sum = neededTime[i];
        for(int k=i+1; k<=j; k++) {
            max = Math.max(max, neededTime[k]);
            sum += neededTime[k];
        }
        return sum-max;
    }

}
