package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.TreeNode;

public class M536_ConstructBinaryTreeFromString {
    public TreeNode str2tree(String s) {
        if(s.length() == 0) return null;

        char[] chs = s.toCharArray();
        int fistLeftParenthesisIndex = indexOfFistLeftParenthesis(chs);
        int val = string2int(0, fistLeftParenthesisIndex-1, chs);
        TreeNode root = new TreeNode(val);
        if(fistLeftParenthesisIndex < s.length()) {
            int rightParenthesisIndex = indexOfRightParenthesis(fistLeftParenthesisIndex, chs);
            root.left = str2tree(s.substring(fistLeftParenthesisIndex+1, rightParenthesisIndex));

            if(rightParenthesisIndex < chs.length-1) {
                root.right = str2tree(s.substring(rightParenthesisIndex+2, s.length()-1));
            }
        }
        return root;
    }

    private int string2int(int x, int y, char[] chs) {
        int token = 0;
        int sign = 1;
        int start = x;
        if(chs[x] == '-') {
            sign = -1;
            start = x+1;
        }
        for(int i=start; i<=y; i++) {
            token = token*10 + (chs[i]-'0');
        }
        return token * sign;
    }

    private int indexOfFistLeftParenthesis(char[] chs) {
        for(int i=0; i<chs.length; i++) {
            if(chs[i] == '(') return i;
        }
        return chs.length;
    }

    private int indexOfRightParenthesis(int start, char[] chs) {
        // start is the index of '('
        int cnt = 0;
        for(int i=start; i<chs.length; i++) {
            if(chs[i] == '(') {
                cnt++;
            } else if(chs[i] == ')') {
                cnt--;
                if(cnt == 0) return i;
            }
        }

        // no found, no reachable
        return chs.length;
    }
}
