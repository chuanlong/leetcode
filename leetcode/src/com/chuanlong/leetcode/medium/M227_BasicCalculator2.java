package com.chuanlong.leetcode.medium;

public class M227_BasicCalculator2 {

    public static void main(String[] args) {

    }

    public int calculate(String s) {
        char[] chs = s.toCharArray();

        int result = 0;
        int prev = 0;
        int curr = 0;
        char sign = '+';

        for(int i=0; i<chs.length; i++) {
            if(chs[i] >= '0' && chs[i] <= '9') {
                curr = curr*10 + (chs[i]-'0');
            } else if (chs[i] == '+' || chs[i] == '-' || chs[i] == '*' || chs[i] == '/') {
                if(sign == '+') {
                    result = result + prev;
                    prev = curr;
                } else if (sign == '-') {
                    result = result + prev;
                    prev = 0 - curr;
                } else if (sign == '*') {
                    prev = prev * curr;
                } else if (sign == '/') {
                    prev = prev / curr;
                }
                sign = chs[i];
                curr = 0;
            }
        }

        if(sign == '+') {
            result = result + prev + curr;
        } else if (sign == '-') {
            result = result + prev - curr;
        } else if (sign == '*') {
            result = result + prev * curr;
        } else if (sign == '/') {
            result = result + prev / curr;
        }
        return result;
    }

}
