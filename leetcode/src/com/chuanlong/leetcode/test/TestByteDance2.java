package com.chuanlong.leetcode.test;

public class TestByteDance2 {

    public static void main(String[] args) {
        TestByteDance2 obj = new TestByteDance2();

        System.out.println("test byte dance 2!");
    }

    // return 1-7;
    private int random7(){
        // TODO
        return 0;
    }

    private int random10(){
        int x = (random7()-1) * 7 + (random7()-1) + 1;
        if (x>=1 && x <= 40) {
            return x%10==0 ? 10 : x%10;
        } else {
            return random10();
        }
    }


}
