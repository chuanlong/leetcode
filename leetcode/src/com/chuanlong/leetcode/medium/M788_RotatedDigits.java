package com.chuanlong.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class M788_RotatedDigits {
    public int rotatedDigits(int n) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(3);
        set1.add(4);
        set1.add(7);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(5);
        set2.add(6);
        set2.add(9);

        int cnt = 0;
        for(int i=1; i<=n; i++) {
            if(isGood(set1, set2, i)) cnt++;
        }
        return cnt;
    }

    private boolean isGood(Set<Integer> set1, Set<Integer> set2, int x) {
        int cnt = 0;
        while(x > 0) {
            int digit = x%10;
            if(set1.contains(digit)) return false;
            if(set2.contains(digit)) cnt++;
            x = x/10;
        }
        if(cnt >= 1) return true;
        else return false;
    }
}
