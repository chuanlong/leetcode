package com.chuanlong.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class M792_NumberOfMatchingSubsequences {

    public static void main(String[] args) {

    }

    public int numMatchingSubseq(String s, String[] words) {
        int num = 0;
        Map<String, Boolean> map = new HashMap<>();
        for(int i=0; i<words.length; i++) {
            if(map.containsKey(words[i])) {
                if(map.get(words[i])) num++;
            } else if(isSubsequence(words[i], s)) {
                num++;
                map.put(words[i], true);
            } else {
                map.put(words[i], false);
            }
        }
        return num;
    }

    public boolean isSubsequence(String sub, String origin) {
        if (sub.length() > origin.length()) {
            return false;
        }
        char[] chs1 = sub.toCharArray();
        char[] chs2 = origin.toCharArray();

        int i=0, j=0;
        while(i<sub.length() && j<origin.length()) {
            if (chs1[i] == chs2[j]) {
                i++; j++;
            } else {
                j++;
            }
        }
        return i == sub.length();
    }

}
