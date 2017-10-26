package com.chuanlong.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

import com.chuanlong.leetcode.bean.Interval;

public class H057_InsertInterval {

	public static void main(String[] args) {
	}
	
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	if (newInterval == null) {
    		return intervals;
    	}
    	
    	if (intervals == null || intervals.size() == 0) {
    		intervals = new ArrayList<>();
    		intervals.add(newInterval);
        	return intervals;
    	}
    	
		int size = intervals.size();
		int startIndex = -1;
		while (startIndex + 1 < size && newInterval.start > intervals.get(startIndex + 1).end) {
			startIndex++;
		}

		int endIndex = size;
		while (endIndex - 1 >= 0 && newInterval.end < intervals.get(endIndex - 1).start) {
			endIndex--;
		}
		
		// assert start < end
		if (startIndex+1 == endIndex) {
			intervals.add(endIndex, newInterval);
		} else {
			// merge start+1 --> end-1 and newInterval
			int newStart = Math.min(intervals.get(startIndex+1).start, newInterval.start);
			int newEnd = Math.max(intervals.get(endIndex-1).end, newInterval.end);
			for(int i=0; i<endIndex-startIndex-1; i++) {
				intervals.remove(startIndex+1);
			}
			intervals.add(startIndex+1, new Interval(newStart, newEnd));
		}
		return intervals;
	}

}
