package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class M253_MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        List<int[]> meetings = new ArrayList<>();
        for(int i=0; i<intervals.length; i++) {
            meetings.add(intervals[i]);
        }
        Collections.sort(meetings, (a, b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            else return a[0]-b[0];
        });

        int cnt = 0;
        while(meetings.size() > 0) {
            cnt++;
            int[] room = meetings.remove(0);
            int index = 0;
            while(index<meetings.size()) {
                if(room[1] <= meetings.get(index)[0]) {
                    room[1] = meetings.get(index)[1];
                    meetings.remove(index);
                } else {
                    index++;
                }
            }
        }
        return cnt;
    }
}
