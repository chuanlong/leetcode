package com.chuanlong.leetcode.easy;

public class E2351_FirstLetterToAppearTwice {
    public char repeatedCharacter(String s) {
        int[] counts = new int[26];
        for(int i=0; i<26; i++){
            counts[i] = 0;
        }

        char[] chs = s.toCharArray();
        for(int i=0; i<chs.length; i++) {
            int key = chs[i] - 'a';
            if(counts[key] == 0) {
                counts[key] = 1;
            } else {
                return chs[i];
            }
        }
        return 'a'; // unreachable
    }
}
