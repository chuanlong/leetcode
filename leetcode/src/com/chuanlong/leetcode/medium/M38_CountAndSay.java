package com.chuanlong.leetcode.medium;

public class M38_CountAndSay {
    public String countAndSay(int n) {
        String[] dp = new String[n+1];
        dp[0] = "1";
        dp[1] = "1";
        for(int i=2; i<=n; i++) {
            dp[i] = countSay(dp[i-1]);
        }
        return dp[n];
    }

    private String countSay(String s) {
        StringBuilder sb = new StringBuilder();
        int ch = -1, cnt = -1;
        char[] chs = s.toCharArray();
        for(int i=0; i<chs.length; i++) {
            if(cnt == -1) {
                ch = chs[i]-'0';
                cnt = 1;
            } else {
                if(chs[i]-'0' == ch) {
                    cnt++;
                } else {
                    sb.append(cnt+""+ch);
                    ch = chs[i]-'0';
                    cnt = 1;
                }
            }
        }
        if(cnt != -1) sb.append(cnt+""+ch);
        return sb.toString();
    }
}
