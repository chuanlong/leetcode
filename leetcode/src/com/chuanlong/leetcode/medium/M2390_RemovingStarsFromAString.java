package com.chuanlong.leetcode.medium;

public class M2390_RemovingStarsFromAString {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();

        for(int i=0; i<chs.length; i++) {
            if(chs[i] != '*') sb.append(chs[i]);
            else {
                sb.deleteCharAt(sb.length()-1);
            }
        }

        return sb.toString();
    }
}
