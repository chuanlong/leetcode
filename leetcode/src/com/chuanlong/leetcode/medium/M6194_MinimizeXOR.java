package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M6194_MinimizeXOR {
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

}
