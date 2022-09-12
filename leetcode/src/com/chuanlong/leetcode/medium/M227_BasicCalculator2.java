package com.chuanlong.leetcode.medium;

public class M227_BasicCalculator2 {

    public static void main(String[] args) {

    }

    public int calculate(String s) {
        int expr = 0, prev = 0, curr = 0;
        char operation = '+';
        char[] chs = s.toCharArray();
        for(int i=0; i<chs.length; i++) {
            char ch = chs[i];
            if(ch >= '0' && ch <= '9') {
                curr = curr*10 + (ch-'0');
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                if(operation == '+') {
                    expr = expr + prev;
                    prev = curr;
                } else if (operation == '-') {
                    expr = expr + prev;
                    prev = 0 - curr;
                } else if (operation == '*') {
                    prev = prev * curr;
                } else if (operation == '/') {
                    prev = prev / curr;
                }
                curr = 0;
                operation = ch;
            }
        }
        if(operation == '+') {
            expr = expr+prev+curr;
        } else if (operation == '-') {
            expr = expr+prev-curr;
        } else if (operation == '*') {
            expr = expr+prev*curr;
        } else if (operation == '/') {
            expr = expr+prev/curr;
        }
        return expr;
    }

    public int calculate3(String s) {
        int expr = 0, prev = 0, curr = 0;
        char operation = '+';
        char[] chs = s.toCharArray();
        for(int i=0; i<chs.length; i++) {
            char ch = chs[i];
            if(ch >= '0' && ch <= '9') {
                curr = curr*10 + (ch-'0');
            }
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || i == chs.length-1) {
                if(operation == '+') {
                    expr = expr + prev;
                    prev = curr;
                } else if (operation == '-') {
                    expr = expr + prev;
                    prev = 0 - curr;
                } else if (operation == '*') {
                    prev = prev * curr;
                } else if (operation == '/') {
                    prev = prev / curr;
                }
                curr = 0;
                operation = ch;
            }
        }
        return expr+prev;
    }



    public int calculate2(String s) {
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
