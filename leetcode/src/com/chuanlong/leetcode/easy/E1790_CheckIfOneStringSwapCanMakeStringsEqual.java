package com.chuanlong.leetcode.easy;

public class E1790_CheckIfOneStringSwapCanMakeStringsEqual {


    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.charAt(0) == s2.charAt(0)) {
            return areAlmostEqual(s1.substring(1), s2.substring(1));
        }else {
            int diff = diff(s1.substring(1), s2.substring(1));
            if (diff != -1) {
                if (s1.charAt(0) == s2.charAt(diff+1) && s1.charAt(diff+1) == s2.charAt(0)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public int diff(String s1, String s2) {
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();

        int index = -1;
        for(int i=0; i<chs1.length; i++) {
            if (chs1[i] != chs2[i]) {
                if (index == -1) {
                    index = i;
                } else {
                    return -1;
                }
            }
        }
        return index;
    }
}
