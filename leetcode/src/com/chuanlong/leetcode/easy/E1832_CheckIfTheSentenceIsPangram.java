package com.chuanlong.leetcode.easy;

public class E1832_CheckIfTheSentenceIsPangram {
    public boolean checkIfPangram(String sentence) {
        char[] chs = sentence.toCharArray();
        int[] cnt = new int[26];
        for(char ch : chs) {
            cnt[ch-'a']++;
        }
        for(int i=0; i<26; i++) {
            if(cnt[i] == 0) return false;
        }
        return true;
    }
}
