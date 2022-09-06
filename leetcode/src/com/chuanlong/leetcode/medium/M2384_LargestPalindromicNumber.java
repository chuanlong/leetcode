package com.chuanlong.leetcode.medium;

public class M2384_LargestPalindromicNumber {

    public String largestPalindromic(String num) {
        int[] count = new int[10];
        char[] chs = num.toCharArray();
        for(int i=0; i<chs.length; i++) {
            count[chs[i]-'0'] ++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=count.length-1; i>0; i--) {
            if(count[i] == 0) continue;
            int repeat = count[i] / 2;
            sb.append(getToken(i+"", repeat));
            count[i] = count[i] - 2*repeat;
        }

        // check no leading zeros
        if(sb.length() > 0) {
            int repeat = count[0] / 2;
            sb.append(getToken("0", repeat));
            count[0] = count[0] - 2*repeat;
        }

        // add one big digit in the middle
        String middle = "";
        for(int i=count.length-1; i>=0; i--) {
            if(count[i] >0 ){
                middle = i+"";
                break;
            }
        }

        return sb.toString() + middle + sb.reverse().toString();
    }

    private String getToken(String digit, int count) {
        String token = "";
        for(int i=0; i<count; i++) {
            token += digit;
        }
        return token;
    }
}
