package com.chuanlong.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class M322_CoinChange {

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        return coinChange(coins, new HashMap<>(), amount);
    }


    private int coinChange(int[] coins, Map<Integer, Integer> map, int amount) {
        if(map.containsKey(amount)) return map.get(amount);
        if(amount == 0) return 0;
        int fewest = -1;
        for(int i=0; i<coins.length; i++) {
            if(amount-coins[i]<0) break;
            int cnt = coinChange(coins, map, amount-coins[i]);
            if(cnt != -1 && (fewest == -1 || (cnt+1<fewest))) fewest = cnt+1;
        }
        map.put(amount, fewest);
        return fewest;
    }

}
