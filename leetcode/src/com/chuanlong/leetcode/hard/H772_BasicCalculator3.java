package com.chuanlong.leetcode.hard;

public class H772_BasicCalculator3 {

    public static void main(String[] args) {
        H772_BasicCalculator3 calculator3 = new H772_BasicCalculator3();

        System.out.println("Test1, 6-4/2, expect:4, result:" + calculator3.calculate("6-4/2"));

        System.out.println("Test2, 2*(5+5*2)/3+(6/2+8), expect:21, result:" + calculator3.calculate("2*(5+5*2)/3+(6/2+8)"));

        System.out.println("Test3, (2+6*3+5-(3*14/7+2)*5)+3, expect:-12, result:" + calculator3.calculate("(2+6*3+5-(3*14/7+2)*5)+3"));

        System.out.println("Test4, 0, expect:0, result:" + calculator3.calculate("0"));
    }


    public int calculate(String s) {
        return evaluate(s);
    }

    private int evaluate(String s) {
        char[] chs = s.toCharArray();

        int result=0, prev=0, current=0;
        char sign = '+';

        for(int i=0; i<chs.length; i++) {
            char ch = chs[i];
            if(ch == '(') {
                int endIndex = findClosingIndex(s, i);
                current = evaluate(s.substring(i+1, endIndex));
                i = endIndex;
            } else if (ch >= '0' && ch <= '9') {
                current = current * 10 + (ch-'0');
            } else if (ch =='+' || ch == '-') {
                if (sign == '+') {
                    prev = prev + current;
                } else if (sign == '-') {
                    prev = prev - current;
                } else if (sign == '*') {
                    prev = prev * current;
                } else if (sign == '/') {
                    prev = prev / current;
                }
                sign = ch;
                current = 0;
            } else if (ch == '*' || ch == '/') {
                if (sign == '+') {
                    result = result + prev;
                    prev = current;
                } else if (sign == '-') {
                    result = result + prev;
                    prev = 0-current;
                } else if (sign == '*') {
                    prev = prev * current;
                } else if (sign == '/') {
                    prev = prev / current;
                }
                sign = ch;
                current = 0;
            }
        }

        if (sign == '+') {
            prev = prev + current;
        } else if (sign == '-') {
            prev = prev - current;
        } else if (sign == '*') {
            prev = prev * current;
        } else if (sign == '/') {
            prev = prev / current;
        }
        result = result + prev;


        return result;
    }

    private int findClosingIndex(String s, int index) {
        int count = 1;
        for(int i=index+1; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                count++;
            } else if (ch== ')') {
                count--;
                if (count == 0) {
                    return i;
                }
            }
        }
        return s.length()-1;
    }

}
