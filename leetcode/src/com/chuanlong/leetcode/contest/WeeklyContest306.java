package com.chuanlong.leetcode.contest;

import java.util.ArrayList;
import java.util.List;

public class WeeklyContest306 {

    public static void main(String[] args) {
        WeeklyContest306 obj = new WeeklyContest306();
        System.out.println("Test1, expect:7, output:" + obj.edgeScore(new int[]{1,0,0,0,0,7,7,5}));
        System.out.println("Test2, expect:0, output:" + obj.edgeScore(new int[]{2,0,0,2}));
        System.out.println("Test3, expect:1, output:" + obj.edgeScore(new int[]{1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));

        System.out.println("Test4, expect:123549876, output:" + obj.smallestNumber("IIIDIDDD"));
        System.out.println("Test4, expect:4321, output:" + obj.smallestNumber("DDD"));
    }

    // 09:14, 0 error
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] max = new int[n-2][n-2];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++){
                check(i-2, j-2, grid[i][j], max);
                check(i-1, j-2, grid[i][j], max);
                check(i, j-2, grid[i][j], max);

                check(i-2, j-1, grid[i][j], max);
                check(i-1, j-1, grid[i][j], max);
                check(i, j-1, grid[i][j], max);

                check(i-2, j, grid[i][j], max);
                check(i-1, j, grid[i][j], max);
                check(i, j, grid[i][j], max);
            }
        }
        return max;
    }

    private void check(int i, int j, int value, int[][] max) {
        int m = max.length;
        if(i>=0 && i<m && j>=0 && j<m) max[i][j] = Math.max(max[i][j], value);
    }



    // 11:03
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] scores = new long[n];
        for(int i=0; i<n; i++) {
            scores[i] = 0;
        }

        for(int i=0; i<n; i++) {
            scores[edges[i]] = scores[edges[i]] + i;
        }

        int maxIndex = 0;
        long maxScore = scores[0];
        for(int i=1; i<n; i++) {
            if(scores[i] > maxScore) {
                maxScore = scores[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }



    // 25:14, 2 errors
    public String smallestNumber(String pattern) {
        List<Integer> nums = new ArrayList<>();
        char[] chs = pattern.toCharArray();
        for(int i=1; i<=chs.length+1; i++) {
            nums.add(i);
        }

        StringBuilder sb = new StringBuilder();
        int countD = 0;
        for(int i=0; i<chs.length; i++) {
            if(chs[i] == 'I') {
                if(countD > 0) {
                    for(int j=countD; j>=0; j--) {
                        sb.append(nums.get(j));
                    }
                    nums = nums.subList(countD+1, nums.size());
                    countD = 0;
                } else {
                    sb.append(nums.remove(0));
                }
            } else {
                countD++;
            }
        }
        if(countD > 0) {
            for(int j=countD; j>=0; j--) {
                sb.append(nums.get(j));
            }
            nums = nums.subList(countD+1, nums.size());
            countD = 0;
        }
        if(nums.size() > 0) {
            sb.append(nums.remove(0));
        }
        return sb.toString();
    }
    


}
