package com.chuanlong.leetcode.easy;

import java.util.Arrays;

public class E252_MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->{
            if(a[0] == b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        for(int i=0; i<intervals.length-1; i++) {
            if(isConflict(intervals[i], intervals[i+1])) return false;
        }
        return true;
    }

    private boolean isConflict(int[] a, int[] b) {
        if(a[1] <= b[0]) return false;
        return true;
    }
}
