package com.chuanlong.leetcode.medium;

public class M1824_MinimumSidewayJumps {

    public static void main(String[] args) {
        M1824_MinimumSidewayJumps obj = new M1824_MinimumSidewayJumps();

        System.out.println("Test1, expect:2, output:" + obj.minSideJumps(new int[]{0,1,2,3,0}));
        System.out.println("Test2, expect:0, output:" + obj.minSideJumps(new int[]{0,1,1,3,3,0}));
        System.out.println("Test3, expect:2, output:" + obj.minSideJumps(new int[]{0,2,1,0,3,0}));
    }

    // 32:54 minutes, 1 error WA.
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[][] path = new int[3][n+1];
        path[0][0] = -2;
        path[1][0] = 0;
        path[2][0] = -2;
        for(int i=0; i<n; i++) {
            if(obstacles[i] == 0) {
                path[0][i+1] = getMin(path[0][i], path[1][i]+1, path[2][i]+1);
                path[1][i+1] = getMin(path[1][i], path[0][i]+1, path[2][i]+1);
                path[2][i+1] = getMin(path[2][i], path[0][i]+1, path[1][i]+1);
            } else if(obstacles[i] == 1) {
                path[0][i+1] = -2;
                path[1][i+1] = getMin(path[1][i], path[2][i]+1);
                path[2][i+1] = getMin(path[2][i], path[1][i]+1);
            } else if(obstacles[i] == 2) {
                path[1][i+1] = -2;
                path[0][i+1] = getMin(path[0][i], path[2][i]+1);
                path[2][i+1] = getMin(path[2][i], path[0][i]+1);
            } else if(obstacles[i] == 3) {
                path[2][i+1] = -2;
                path[0][i+1] = getMin(path[0][i], path[1][i]+1);
                path[1][i+1] = getMin(path[1][i], path[0][i]+1);
            }
        }
        return getMin(path[0][n], path[1][n], path[2][n]);
    }

    private int getMin(int x, int y, int z) {
        int min = Integer.MAX_VALUE;
        if(x >= 0) min = Math.min(min, x);
        if(y >= 0) min = Math.min(min, y);
        if(z >= 0) min = Math.min(min, z);
        return min;
    }
    private int getMin(int x, int y) {
        int min = Integer.MAX_VALUE;
        if(x >= 0) min = Math.min(min, x);
        if(y >= 0) min = Math.min(min, y);
        return min;
    }
}
