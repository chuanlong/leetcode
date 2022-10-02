package com.chuanlong.leetcode.contest;

import java.util.ArrayList;
import java.util.List;

public class WeeklyContest313 {

    public static void main(String[] args) {
        WeeklyContest313 obj = new WeeklyContest313();


        System.out.println("Test1, expect:3, output:" + obj.minimizeXor(1, 12));

        System.out.println("Test2, expect:2, output:" + obj.deleteString("abcabcdabc"));
        System.out.println("Test3, expect:4, output:" + obj.deleteString("aaabaab"));
        System.out.println("Test4, expect:5, output:" + obj.deleteString("aaaaa"));
    }

    // problem 1
    public int commonFactors(int a, int b) {
        int num=0;
        for(int i=1; i<=a&&i<=b; i++) {
            if(a%i==0 && b%i==0) num++;
        }
        return num;
    }

    // problem 2
    public int maxSum(int[][] grid) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<grid.length-2; i++) {
            for(int j=0; j<grid[0].length-2; j++) {
                max = Math.max(max, sumHourglass(grid, i, j));
            }
        }
        return max;
    }

    private int sumHourglass(int[][] grid, int x, int y) {
        return grid[x][y]+grid[x][y+1]+grid[x][y+2]+grid[x+1][y+1]+grid[x+2][y]+grid[x+2][y+1]+grid[x+2][y+2];
    }

    // problem 3
    public int minimizeXor(int num1, int num2) {
        List<Integer> digits1 = int2digits(num1);
        List<Integer> digits2 = int2digits(num2);
        int cnt1=0;
        for(int i=0; i<digits2.size(); i++) {
            if(digits2.get(i) == 1) cnt1++;
        }

        List<Integer> x = new ArrayList<>();
        for(int i=0; i<digits1.size(); i++) {
            if(digits1.get(i) == 1) {
                if(cnt1>0) {
                    x.add(1);
                    cnt1--;
                } else {
                    x.add(0);
                }
            } else {
                if(cnt1<digits1.size()-i) {
                    x.add(0);
                } else {
                    x.add(1);
                    cnt1--;
                }
            }
        }
        while(cnt1>0) {
            x.add(0, 1);
            cnt1--;
        }

        return digits2int(x);
    }

    private List<Integer> int2digits(int num) {
        List<Integer> list = new ArrayList<>();
        while(num>0) {
            list.add(0, num%2);
            num = num/2;
        }
        return list;
    }

    private int digits2int(List<Integer> digits) {
        int x = 0;
        for(int i=0; i<digits.size(); i++) {
            x = x*2 + digits.get(i);
        }
        return x;
    }


    // problem 4
    public int deleteString(String s) {
        char[] chs = s.toCharArray();
        int[] mem = new int[chs.length];
        return delete(mem, chs, 0);
    }


    private int delete(int[] mem, char[] chs, int index) {
        if(index >= chs.length) return 1;
        if(mem[index] != 0) return mem[index];

        int max = 1;
        for(int i=1; i<=(chs.length-index)/2; i++) {
            if(max > chs.length-index-i) break;
            if(isSame(chs, index, i)) {
                max = Math.max(max, 1+delete(mem, chs, index+i));
            }
        }
        mem[index] = max;
        return max;
    }

    private boolean isSame(char[] chs, int index, int size) {
        for(int i=0; i<size; i++) {
            if(chs[index+i] != chs[index+size+i]) return false;
        }
        return true;
    }


}
