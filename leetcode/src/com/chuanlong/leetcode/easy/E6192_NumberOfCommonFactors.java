package com.chuanlong.leetcode.easy;

public class E6192_NumberOfCommonFactors {
    public int commonFactors(int a, int b) {
        int num=0;
        for(int i=1; i<=a&&i<=b; i++) {
            if(a%i==0 && b%i==0) num++;
        }
        return num;
    }
}
