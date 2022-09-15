package com.chuanlong.leetcode.medium;

import java.util.Stack;

public class M1963_MinimumNumberOfSwapsToMakeTheStringBalanced {

    public int minSwaps(String s) {
        char[] chs = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<chs.length; i++) {
            if(chs[i] == '[') {
                stack.push(i);
            } else if (chs[i] == ']') {
                if(stack.size() > 0) stack.pop();
             }
        }
        int size = stack.size();
        return size/2 + size%2;
    }

}
