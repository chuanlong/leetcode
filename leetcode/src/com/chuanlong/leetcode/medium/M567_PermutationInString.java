package com.chuanlong.leetcode.medium;

public class M567_PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        int[] cnt1 = new int[26];
        char[] chs1 = s1.toCharArray();
        for(char ch : chs1) {
            cnt1[ch-'a']++;
        }

        char[] chs2 = s2.toCharArray();
        for(int i=0; i+k<=chs2.length; i++) {
            if(isPermutations(cnt1, chs2, i, k)) return true;
        }
        return false;
    }

    private boolean isPermutations(int[] cnt1, char[] chs, int index, int k) {
        int[] cnt2 = new int[26];
        for(int i=index; i<index+k; i++) {
            cnt2[chs[i]-'a']++;
        }
        for(int i=0; i<26; i++) {
            if(cnt1[i]!=cnt2[i]) return false;
        }
        return true;
    }

}
