package com.chuanlong.leetcode.medium;

public class M1041_RobotBoundedInCircle {

    public boolean isRobotBounded(String instructions) {
        int[] end = getPoint(new int[]{0, 0, 0}, instructions);
        if(end[0] == 0 && end[1] == 0) return true;
        end = getPoint(end, instructions);
        if(end[0] == 0 && end[1] == 0) return true;
        end = getPoint(end, instructions);
        end = getPoint(end, instructions);
        if(end[0] == 0 && end[1] == 0) return true;
        return false;
    }

    // z(direction): 0,north, 1,east, 2,south, 3,west
    private int[] getPoint(int[] path, String instructions) {
        char[] chs = instructions.toCharArray();
        int x = path[0], y = path[1], z = path[2];
        for(int i=0; i<chs.length; i++) {
            if(chs[i] == 'G') {
                if(z == 0) {
                    y++;
                } else if (z == 1) {
                    x++;
                } else if (z == 2) {
                    y--;
                } else if (z == 3) {
                    x--;
                }
            } else if(chs[i] == 'L') {
                z = (z+3) % 4;
            } else if(chs[i] == 'R') {
                z = (z+1) % 4;
            } else {
                // do nothing
            }
        }
        return new int[]{x, y, z};
    }

}
