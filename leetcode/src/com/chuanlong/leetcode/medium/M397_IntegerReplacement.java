package com.chuanlong.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class M397_IntegerReplacement {

    public int integerReplacement(int n) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 0);
        map.put(1L, 0);
        dfs((long)n, map);
        return (int)map.get((long)n);
    }

    private void dfs(long n, Map<Long, Integer> map) {
        if(map.containsKey(n)) return;
        if(n%2 == 0) {
            dfs(n/2, map);
            map.put(n, map.get(n/2)+1);
        } else {
            dfs(n+1, map);
            dfs(n-1, map);
            map.put(n, Math.min(map.get(n+1), map.get(n-1))+1);
        }
    }
}
