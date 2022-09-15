package com.chuanlong.leetcode.hard;


import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class H854_KSimilarStrings {

    public static void main(String[] args) {
        H854_KSimilarStrings obj = new H854_KSimilarStrings();

        System.out.println("Test1, expect:1, output:" + obj.kSimilarity2("ab", "ba"));
    }

    public int kSimilarity2(String s1, String s2) {
        Map<Pair<String, String>, Integer> maps = new HashMap<>();
        return kSimilarity2(s1, s2, maps);
    }

    private int kSimilarity2(String s1, String s2, Map<Pair<String, String>, Integer> maps) {
        if(s1.equals(s2)) return 0;
        if(s1.charAt(0) == s2.charAt(0)) return kSimilarity2(s1.substring(1), s2.substring(1), maps);

        Pair<String, String> pair = getKey(s1, s2);
        if(maps.containsKey(pair)) return maps.get(pair);

        int min = Integer.MAX_VALUE;
        char ch = s1.charAt(0);
        char[] chs = s2.toCharArray();
        for(int i=1; i<chs.length; i++) {
            if(ch == chs[i]) {
                String ss1 = s1.substring(1);
                String ss2 = s2.substring(1, i)+s2.charAt(0)+s2.substring(i+1);
                int k = kSimilarity2(ss1, ss2, maps);
                updateMaps(ss1, ss2, k, maps);
                min = Math.min(min, k+1);
            }
        }

        return min;
    }

    private Pair<String, String> getKey(String s1, String s2) {
        if(s1.compareTo(s2) < 0) {
            return new Pair<>(s1, s2);
        } else {
            return new Pair<>(s2, s1);
        }
    }

    private void updateMaps(String s1, String s2, int k, Map<Pair<String, String>, Integer> maps) {
        Pair<String, String> pair = getKey(s1, s2);
        if(maps.containsKey(pair)) {
            int oldK = maps.get(pair);
            if(k < oldK) maps.put(pair, k);
        } else {
            maps.put(pair, k);
        }
    }

}
