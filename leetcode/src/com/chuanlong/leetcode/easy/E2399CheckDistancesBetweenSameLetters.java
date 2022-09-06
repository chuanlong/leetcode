package com.chuanlong.leetcode.easy;

public class E2399CheckDistancesBetweenSameLetters {

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

}
