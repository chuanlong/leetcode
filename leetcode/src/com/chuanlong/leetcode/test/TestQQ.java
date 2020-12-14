package com.chuanlong.leetcode.test;

public class TestQQ {

    public static void main(String[] args) {
        TestQQ obj = new TestQQ();


        System.out.println("test, expect:5, results:" + obj.subString("abcabcdabcdef"));


    }


    public int subString(String str) {
        if (str == null) {
            return 0;
        }
        if (str.length() == 1) {
            return 1;
        }

        char[] chs = str.toCharArray();
        int length = chs.length;

        int x = 0;
        int y = 1;
        for (int i=1; i<length; i++) {
            char ch = chs[i];
            int newX = max(x, y);

            int j=i-1;
            for (; j>i-1-y; j--) {
                if (chs[j] == ch) {
                    break;
                }
            }
            int newY;
            if (j == i-1-y) {
                newY = y+1;
            }else {
                newY = i-j;
            }

            x=newX;
            y=newY;
        }

        return max(x, y);
    }

    private int max(int x, int y) {
        return x>y ? x: y;
    }
}
