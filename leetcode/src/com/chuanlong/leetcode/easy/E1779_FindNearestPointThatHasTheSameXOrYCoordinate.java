package com.chuanlong.leetcode.easy;

public class E1779_FindNearestPointThatHasTheSameXOrYCoordinate {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i=0; i<points.length; i++) {
            if(x == points[i][0]) {
                int distance = (y>points[i][1]) ? (y-points[i][1]) : (points[i][1]-y);
                if(distance < min) {
                    min = distance;
                    index = i;
                }
            } else if (y == points[i][1]) {
                int distance = (x>points[i][0]) ? (x-points[i][0]) : (points[i][0]-x);
                if(distance < min) {
                    min = distance;
                    index = i;
                }
            }
        }
        return index;
    }
}
