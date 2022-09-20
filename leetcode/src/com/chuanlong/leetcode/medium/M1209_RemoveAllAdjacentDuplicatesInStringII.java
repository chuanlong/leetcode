package com.chuanlong.leetcode.medium;

import java.util.Stack;

public class M1209_RemoveAllAdjacentDuplicatesInStringII {
    public String removeDuplicates(String s, int k) {
        if(s == null || s.length() < k) return s;
        int n = s.length();
        char[] chs = s.toCharArray();

        // [ch-'a', cnt]
        Stack<int[]> stack = new Stack<>();

        for(int i=0; i<n; i++) {
            char ch = chs[i];
            if(stack.isEmpty()) {
                stack.push(new int[]{ch-'a', 1});
            } else {
                int[] top = stack.peek();
                if(ch != (char)(top[0]+'a')) {
                    stack.push(new int[]{ch-'a', 1});
                } else {
                    top[1]++;
                    if(top[1] == k) stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            int[] top = stack.pop();
            sb.append(char2string((char)(top[0]+'a'), top[1]));
        }
        return sb.reverse().toString();
    }

    private String char2string(char ch, int cnt) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<cnt; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
