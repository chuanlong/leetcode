package com.chuanlong.leetcode.hard;

public class H6195_MaximumDeletionsOnAString {
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
