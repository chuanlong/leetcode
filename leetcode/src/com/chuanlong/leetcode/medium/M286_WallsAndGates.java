package com.chuanlong.leetcode.medium;

/**
 * 13:18 minutes
 * */
public class M286_WallsAndGates {

    public void wallsAndGates(int[][] rooms) {
        if(rooms == null) return;
        for(int i=0; i<rooms.length; i++) {
            for(int j=0; j<rooms[0].length; j++) {
                if(rooms[i][j] == 0) {
                    check(rooms, i+1, j, 1);
                    check(rooms, i-1, j, 1);
                    check(rooms, i, j+1, 1);
                    check(rooms, i, j-1, 1);
                }
            }
        }
    }

    private void check(int[][] rooms, int x, int y, int distance) {
        if(x<0 || x>= rooms.length || y<0 || y>= rooms[0].length) return;
        if(rooms[x][y] == -1) return;
        if(rooms[x][y] > distance) {
            rooms[x][y] = distance;
            check(rooms, x+1, y, distance+1);
            check(rooms, x-1, y, distance+1);
            check(rooms, x, y+1, distance+1);
            check(rooms, x, y-1, distance+1);
        }
    }
}
