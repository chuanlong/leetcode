package com.chuanlong.leetcode.contest;

import java.util.*;

public class BiweeklyContest85 {

    public static void main(String[] args) {
        BiweeklyContest85 obj = new BiweeklyContest85();

        System.out.println("Test1, expect:3, output:" + obj.minimumRecolors("WBBWWBBWBW", 7));
        System.out.println("Test2, expect:6, output:" + obj.minimumRecolors("WWBBBWBBBBBWWBWWWB", 16));


        System.out.println("Test3, expect:4, output:" + obj.secondsToRemoveOccurrences("0110101"));
        System.out.println("Test4, expect:0, output:" + obj.secondsToRemoveOccurrences("11100"));
        System.out.println("Test5, expect:0, output:" + obj.secondsToRemoveOccurrences("11100"));
        System.out.println("Test6, expect:5, output:" + obj.secondsToRemoveOccurrences("0110101001"));
        System.out.println("Test7, expect:4, output:" + obj.secondsToRemoveOccurrences("001011"));

    }

    public int minimumRecolors(String blocks, int k) {
        char[] chs = blocks.toCharArray();
        int sumBlacks = 0;
        int i=0, j=0;
        for(; j<k; j++) {
            if(chs[j] == 'B') sumBlacks++;
        }

        int min = k-sumBlacks;
        while(min > 0 && j<chs.length) {
            if(chs[i++] == 'B') sumBlacks--;
            if(chs[j++] == 'B') sumBlacks++;
            min = Math.min(k-sumBlacks, min);
        }

        return min;
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

    /**
     * correct
     * o(n) solution: https://leetcode.com/problems/time-needed-to-rearrange-a-binary-string/discuss/2466135/Java-Solution-2-3-ms
     */
    public int secondsToRemoveOccurrences4(String s){
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
        return secondsToRemoveOccurrences4(newS) + 1;
    }






    // runtime error
    public int secondsToRemoveOccurrences3(String s){
        int index = s.indexOf("0");
        return secondsToRemoveOccurrences1(s.substring(index)).get(0);
    }

    private List<Integer> secondsToRemoveOccurrences1(String s) {
        if(s.length() == 3) {
            if (s.equals("001")){
                return Arrays.asList(2, 1, 1);
            } else if (s.equals("010")) {
                return Arrays.asList(1, 0, 1);
            } else if(s.equals("000")){
                return Arrays.asList(0, 0, 0);
            } else {
                // 011
                return Arrays.asList(2, 2, 2);
            }
        } else if (s.length() == 2){
            if(s.equals("01")) {
                return Arrays.asList(1,0,0);
            } else {
                // 00
                return Arrays.asList(0,0,0);
            }
        } else if (s.length() <= 1) {
            return Arrays.asList(0,0,0);
        }
        String token = s.substring(0, s.length()-1);
        char ch = s.charAt(s.length()-1);
        List<Integer> point = secondsToRemoveOccurrences1(token);
        int x, y, z;
        if(ch == '0') {
            x = point.get(0);
            y = 0;
            z = point.get(2);
        } else {
            // 1
            int newX = (point.get(1)+token.length()-point.get(2));
            if(newX > point.get(0)){
                x = newX;
            } else {
                x = point.get(0) + 1;
            }
            y = point.get(1) + 1;
            z = point.get(2) + 1;
        }
        return Arrays.asList(x, y, z);
    }

    // wrong
    public int secondsToRemoveOccurrences2(String s) {
        int i=0, j=0;
        char[] chs = s.toCharArray();
        int count1 = 0;
        int max = 0;
        // find the first 0
        while(j<chs.length) {
            if(chs[j] == '0') {
                i=j;
                break;
            } else {
                j++;
                count1++;
            }
        }

        j++;
        while(j<chs.length) {
            if(chs[j] == '0') {
                i++;
                j++;
            } else {
                // 1
                int newMax = (j-i-1) + (j-count1);
                max = Math.max(max, newMax);
                j++;
                count1++;
            }
        }
        return max;
    }

}
