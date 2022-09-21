package com.chuanlong.leetcode.medium;

public class M2055_PlatesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] leftCandle = new int[n];
        int[] rightCandle = new int[n];
        int[] sumPlate = new int[n];

        char[] chs = s.toCharArray();
        int left = -1;
        for(int i=0; i<n; i++) {
            if(chs[i] == '|') left = i;
            leftCandle[i] = left;
        }
        int right = n;
        for(int i=n-1; i>=0; i--) {
            if(chs[i] == '|') right = i;
            rightCandle[i] = right;
        }

        sumPlate[0] = ((chs[0] == '*') ? 1:0);
        for(int i=1; i<n; i++) {
            if(chs[i] == '*') sumPlate[i] = sumPlate[i-1] + 1;
            else sumPlate[i] = sumPlate[i-1];
        }

        int[] cnt = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            if(rightCandle[start] == n || leftCandle[end] == -1) {
                cnt[i] = 0;
            } else {
                int total = (start==0) ? sumPlate[end] : sumPlate[end]-sumPlate[start-1];
                int leftMinus = rightCandle[start] - start;
                int rightMinus = end - leftCandle[end];
                cnt[i] = Math.max(total - leftMinus - rightMinus, 0);
            }
        }
        return cnt;
    }
}
