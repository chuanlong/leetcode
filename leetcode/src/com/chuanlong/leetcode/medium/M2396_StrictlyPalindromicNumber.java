package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M2396_StrictlyPalindromicNumber {

    public boolean isStrictlyPalindromic(int n) {
        for(int i=2; i<=n-2; i++) {
            List<Integer> list = new ArrayList<>();
            int x = n;
            while(x > 0) {
                list.add(0, x%i);
                x = x/i;
            }
            if(!isPalindromic(list)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromic(List<Integer> list) {
        for(int i=0; i<list.size(); i++) {
            if(list.get(i) != list.get(list.size()-1-i)) {
                return false;
            }
        }
        return true;
    }
}
