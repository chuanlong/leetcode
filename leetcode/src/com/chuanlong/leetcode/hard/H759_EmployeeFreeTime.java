package com.chuanlong.leetcode.hard;

import com.chuanlong.leetcode.bean.Interval;

import java.util.ArrayList;
import java.util.List;

public class H759_EmployeeFreeTime {



    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> merged = new ArrayList<>();
        for(int i=0; i<schedule.size(); i++) {
            for(int j=0; j<schedule.get(i).size(); j++){
                Interval item = schedule.get(i).get(j);
                int index = findIndex(merged, item);
                if(index == merged.size()) {
                    merged.add(item);
                } else {
                    int newStart = item.start;
                    int newEnd = item.end;
                    while(index < merged.size() && newEnd >= merged.get(index).start) {
                        newStart = Math.min(newStart, merged.get(index).start);
                        newEnd = Math.max(newEnd, merged.get(index).end);
                        merged.remove(index);
                    }
                    merged.add(index, new Interval(newStart, newEnd));
                }
            }
        }

        List<Interval> reversed = new ArrayList<>();
        for(int i=0; i<merged.size()-1; i++) {
            reversed.add(new Interval(merged.get(i).end, merged.get(i+1).start));
        }
        return reversed;
    }


    private int findIndex(List<Interval> list, Interval interval) {
        for(int i=0; i<list.size(); i++) {
            if(interval.start > list.get(i).end) {
                continue;
            } else {
                return i;
            }
        }
        return list.size();
    }

}
