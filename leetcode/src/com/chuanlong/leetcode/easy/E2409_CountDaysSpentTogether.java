package com.chuanlong.leetcode.easy;

public class E2409_CountDaysSpentTogether {

    int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int gap1 = gapDays(arriveAlice, arriveBob);

        String arrive1, leave1, arrive2, leave2;
        if (gap1 <= 0) {
            arrive1 = arriveAlice;
            arrive2 = arriveBob;
            leave1 = leaveAlice;
            leave2 = leaveBob;
        } else {
            arrive1 = arriveBob;
            arrive2 = arriveAlice;
            leave1 = leaveBob;
            leave2 = leaveAlice;
        }

        int gap2 = gapDays(leave1, arrive2);
        if(gap2 < 0) return 0;
        if(gap2 == 0) return 1;

        int gap3 = gapDays(arrive1, arrive2);
        String start;
        if(gap3<=0) start = arrive2;
        else start = arrive1;

        int gap4 = gapDays(leave1, leave2);
        String end;
        if(gap4<=0) end = leave1;
        else end = leave2;

        return gapDays(end, start)+1;
    }

    private int gapDays(String date1, String date2) {
        String[] a1 = date1.split("-");
        String[] a2 = date2.split("-");
        int month1 = Integer.parseInt(a1[0]);
        int day1 = Integer.parseInt(a1[1]);
        int month2 = Integer.parseInt(a2[0]);
        int day2 = Integer.parseInt(a2[1]);

        if(month1 == month2) {
            return day1-day2;
        } else if(month1 < month2) {
            int total = 0;
            for(int i=month1+1; i<month2; i++) {
                total += days[i-1];
            }
            total += days[month1-1] - day1;
            total += day2;
            return 0-total;
        } else {
            // month1 > month2
            int total = 0;
            for(int i=month2+1; i<month1; i++) total += days[i-1];
            total += days[month2-1] - day2;
            total += day1;
            return total;
        }
    }
}
