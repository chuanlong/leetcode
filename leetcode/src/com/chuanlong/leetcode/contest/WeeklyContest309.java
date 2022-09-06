package com.chuanlong.leetcode.contest;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

// W309 first 2 problems, 28:19 minutes, 1 error
public class WeeklyContest309 {

    // problem 1
    public boolean checkDistances(String s, int[] distance) {
        char[] chs = s.toCharArray();

        for(int i=0; i<chs.length; i++) {
            char ch = chs[i];
            int index = ch-'a';
            if(distance[index] >= 0 ) {
                distance[index] = 0 - (distance[index] + i + 1);
            } else {
                distance[index] = i + distance[index];
                if(distance[index] != 0) {
                    return false;
                }
            }
        }
        return true;
    }


    // problem 2
    public int numberOfWays(int startPos, int endPos, int k) {
        int min = Math.abs(startPos-endPos);
        int waste = k - Math.abs(startPos-endPos);
        if(waste < 0 || waste%2 != 0) {
            return 0;
        }
        return combo(min+waste/2, waste/2, new HashMap<>());
    }

    private int combo(int x, int y, Map<Pair<Integer, Integer>, Integer> map) {
        if(x == 0 || y == 0) return 1;
        Pair<Integer, Integer> pair;
        if(x<y) pair = new Pair<>(x,y);
        else pair = new Pair<>(y, x);
        if(map.containsKey(pair)) return map.get(pair);
        int value = (combo(x-1, y, map) + combo(x, y-1, map)) % 1000000007;
        if(!map.containsKey(pair)) map.put(pair, value);
        return value;
    }
}
