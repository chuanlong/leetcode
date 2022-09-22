package com.chuanlong.leetcode.medium;

public class M739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] days = new int[n];
        days[n-1] = 0;
        for(int i=n-2; i>=0; i--) {
            days[i] = getDays(days, temperatures, i);
        }
        return days;
    }

    private int getDays(int[] days, int[] tems, int i) {
        if(tems[i] < tems[i+1]) return 1;
        int index = i+1;
        while(tems[i] >= tems[index]) {
            if(days[index] == 0) return 0;
            index = index + days[index];
        }
        return index - i;
    }
}
