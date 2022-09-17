package com.chuanlong.leetcode.medium;

public class M1109_CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];
        for(int i=0; i<bookings.length; i++) {
            int first = bookings[i][0];
            int last = bookings[i][1];
            int seats = bookings[i][2];
            for(int j=first; j<=last; j++) {
                answer[j-1] = answer[j-1] + seats;
            }
        }
        return answer;
    }
}
