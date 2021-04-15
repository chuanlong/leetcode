package com.chuanlong.leetcode.hard;

public class H174_DungeonGame2 {

    public static void main(String[] args) {
        int[][] dungeon1 = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };

        int[][] dungeon2 = {
                {1, -4, 5, -99},
                {2, -2, -2, -1}
        };

        H174_DungeonGame2 obj = new H174_DungeonGame2();
        int hp = obj.calculateMinimumHP(dungeon2);
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int y = dungeon.length;
        int x = dungeon[0].length;
        int[][] max = new int[y][x];
        int[][] min = new int[y][x];
        max[0][0] = dungeon[0][0];
        min[0][0] = dungeon[0][0];
        for(int i=1; i<y; i++) {
            max[i][0] = max[i-1][0] + dungeon[i][0];
            min[i][0] = Math.min(min[i-1][0], max[i][0]);
        }
        for(int j=1; j<x; j++) {
            max[0][j] = max[0][j-1] + dungeon[0][j];
            min[0][j] = Math.min(min[0][j-1], max[0][j]);
        }
        for(int i=1; i<y; i++) {
            for(int j=1; j<x; j++) {
                max[i][j] = Math.max(max[i-1][j], max[i][j-1]) + dungeon[i][j];
                min[i][j] = Math.max(  Math.min(min[i-1][j], max[i-1][j]+dungeon[i][j]), Math.min(min[i][j-1], max[i][j-1]+dungeon[i][j]));
            }
        }
        int hp = 0-min[y-1][x-1];
        return hp<=0 ? 1 : hp+1;
    }
}
