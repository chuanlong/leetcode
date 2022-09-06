package com.chuanlong.leetcode.contest;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

// W309 first 2 problems, 28:19 minutes, 1 error
public class W309_M2400NumberOfWaysToReachAPositionAfterExactlyKSteps {

    public static void main(String[] args) {
        W309_M2400NumberOfWaysToReachAPositionAfterExactlyKSteps obj = new W309_M2400NumberOfWaysToReachAPositionAfterExactlyKSteps();
        System.out.println("Test1, expect:3, output:" + obj.numberOfWays(1, 2, 3));
        System.out.println("Test2, expect:0, output:" + obj.numberOfWays(2, 5, 10));
    }

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
