package com.chuanlong.leetcode.easy;


// 15:28 minutes, error 2
public class E859_BuddyStrings {

    public static void main(String[] args) {
        E859_BuddyStrings obj = new E859_BuddyStrings();

        System.out.println("Test1, expect:true, result:" + obj.buddyStrings("aa", "aa"));
        System.out.println("Test2, expect:true, result:" + obj.buddyStrings("ab", "ba"));
        System.out.println("Test2, expect:false, result:" + obj.buddyStrings("ab", "ab"));
    }

    public boolean buddyStrings(String s, String goal) {
        if(s.length() < 2 || goal.length() < 2 || s.length() != goal.length()) {
            return false;
        }
        if(s.equals(goal)) {
            int[] chs = new int[26];
            for(int i=0; i<s.length(); i++) {
                char ch = s.charAt(i);
                if(chs[ch-'a'] != 1) {
                    chs[ch-'a'] = 1;
                } else {
                    return true;
                }
            }
            return false;
        }

        int index1 = -1, index2 = -1;
        int i=0;
        for(; i<s.length(); i++) {
            if(s.charAt(i) != goal.charAt(i)) {
                index1 = i;
                i++;
                break;
            }
        }
        if(index1 == -1) return false;
        for(; i<s.length(); i++) {
            if(s.charAt(i) != goal.charAt(i)) {
                index2 = i;
                i++;
                break;
            }
        }
        if(index2 == -1) return false;
        for(;i<s.length(); i++) {
            if(s.charAt(i) != goal.charAt(i)) {
                return false;
            }
        }

        if(s.charAt(index1) == goal.charAt(index2) && s.charAt(index2) == goal.charAt(index1)) {
            return true;
        } else {
            return false;
        }
    }

}
