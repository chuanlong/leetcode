package com.chuanlong.leetcode.easy;

public class E2259_RemoveDigitFromNumberToMaximizeResult {
    public String removeDigit(String number, char digit) {
        char[] chs = number.toCharArray();
        int lastIndex = -1;
        for(int i=0; i<chs.length; i++) {
            if(chs[i] == digit) {
                lastIndex = i;
                if(i+1<chs.length && chs[i+1] > digit) break;
            }
        }
        return number.substring(0, lastIndex) + number.substring(lastIndex+1);
    }
}
