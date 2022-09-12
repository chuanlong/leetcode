package com.chuanlong.leetcode.medium;

public class M1328_BreakAPalindrome {

    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1) return "";
        char[] chs = palindrome.toCharArray();
        for(int i=0; i<chs.length/2; i++) {
            if(chs[i] != 'a') {
                return palindrome.substring(0, i) + "a" + palindrome.substring(i+1);
            }
        }
        return palindrome.substring(0, palindrome.length()-1) + "b";
    }

}
