package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class M1249_MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        TreeSet<Integer> removedIndexes = new TreeSet<>();
        char[] chs = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<chs.length; i++) {
            if(chs[i] == '(') {
                stack.push(i);
            } else if (chs[i] == ')') {
                if(stack.size() == 0) {
                    removedIndexes.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        while(stack.size() > 0) {
            removedIndexes.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<chs.length; i++) {
            if(!removedIndexes.contains(i)) {
                sb.append(chs[i]);
            }
        }
        return sb.toString();
    }

}
