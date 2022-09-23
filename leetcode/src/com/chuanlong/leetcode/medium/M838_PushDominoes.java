package com.chuanlong.leetcode.medium;

public class M838_PushDominoes {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] chs = new char[n+2];
        for(int i=0; i<n; i++) {
            chs[i+1] = dominoes.charAt(i);
        }
        chs[0] = '.';
        chs[n+1] = '.';
        char[] newchs = new char[n+2];
        newchs[0] = '.';
        newchs[n+1] = '.';
        boolean changed = true;
        while(changed) {
            changed = false;
            for(int i=1; i<=n; i++) {
                if(chs[i] == '.') {
                    if(chs[i-1] == 'R' && chs[i+1] != 'L') {
                        changed = true;
                        newchs[i] = 'R';
                    } else if (chs[i+1] == 'L' && chs[i-1] != 'R') {
                        changed = true;
                        newchs[i] = 'L';
                    } else {
                        newchs[i] = chs[i];
                    }
                } else {
                    newchs[i] = chs[i];
                }
            }
            chs = newchs;
            newchs = new char[n+2];
            newchs[0] = '.';
            newchs[n+1] = '.';
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) sb.append(chs[i]);
        return sb.toString();
    }
}
