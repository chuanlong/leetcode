package com.chuanlong.leetcode.medium;

public class M2380_TimeNeededToRearrangeABinaryString {
    public int secondsToRemoveOccurrences2(String s){
        if(s.length() <= 1) return 0;
        int index1 = s.indexOf("1");
        int index0 = s.indexOf("0");
        if(index1 == -1 || index0 == -1) return 0;
        String token = s.substring(index0);
        if(token.indexOf("1") == -1) return 0;

        char[] chs = token.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i=0;
        for(; i<chs.length-1;) {
            if(chs[i] == '0' && chs[i+1] == '1') {
                sb.append("10");
                i = i+2;
            } else {
                sb.append(chs[i]);
                i++;
            }
        }
        if(i==chs.length-1) sb.append(chs[i++]);

        String newS = sb.toString();
        if(newS.charAt(0) == '1') newS = newS.substring(1);
        return secondsToRemoveOccurrences2(newS) + 1;
    }


    public int secondsToRemoveOccurrences(String s){
        int seconds = 0;
        String token = s;
        while(token.contains("01")) {
            token = token.replace("01", "10");
            seconds++;
        }
        return seconds;
    }

}
