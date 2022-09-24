package com.chuanlong.leetcode.medium;

import java.util.Arrays;

public class M2410_MaximumMatchingOfPlayersWithTrainers {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int cnt = 0;
        int i=0, j=0;
        while(i<players.length && j<trainers.length) {
            if (players[i]<=trainers[j]) {
                cnt++;
                i++;
            }
            j++;
        }
        return cnt;
    }
}
