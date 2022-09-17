package com.chuanlong.leetcode.hard;

import java.util.*;

public class H818_RaceCar {

    // TLE
    public int racecar(int target) {
        if(target == 0) return 0;
        // [pos, speed] -> step
        TreeMap<List<Integer>, Integer> visited = new TreeMap<>((a, b) ->{
            if(a.get(0) == b.get(0)) return a.get(1) - b.get(1);
            else return a.get(0) - b.get(0);
        });

        // minStep, step, pos, speed
        List<Integer> start = Arrays.asList(getMinStep(0,0,1,target), 0, 0, 1);
        PriorityQueue<List<Integer>> queue = new PriorityQueue<List<Integer>>((a, b) -> {
            if(a.get(0) == b.get(0)) return a.get(1) - b.get(1);
            else return a.get(0) - b.get(0);
        });

        queue.add(start);
        visited.put(Arrays.asList(start.get(2), start.get(3)), start.get(1));

        while(!queue.isEmpty()) {
            List<Integer> item = queue.poll();
            if(item.get(2) + item.get(3) == target) return item.get(1)+1;

            int pos1 = item.get(2)+item.get(3), speed1 = item.get(3)*2, step1 = item.get(1)+1;
            List<Integer> item1 = Arrays.asList(pos1, speed1);
            if(!visited.containsKey(item1)) {
                queue.add(Arrays.asList(getMinStep(step1, pos1, speed1, target), step1, pos1, speed1));
                visited.put(item1, step1);
            }

            int pos2 = item.get(2), speed2 = (item.get(3))>0 ? -1 : 1, step2 = item.get(1)+1;
            List<Integer> item2 = Arrays.asList(pos2, speed2);
            if(!visited.containsKey(item2)) {
                queue.add(Arrays.asList(getMinStep(step2, pos2, speed2, target), step2, pos2, speed2));
                visited.put(item2, step2);
            }
        }

        return -1;
    }

    private int getMinStep(int step, int pos, int speed, int target) {
        if(pos<target) {
            if(speed < 0) {
                speed = 1;
                step++;
            }
            for(int i=1; true; i++) {
                if(pos+speed >= target) return step+i;
                pos = pos+speed;
                speed = speed*2;
            }
        } else if (pos>target) {
            if(speed > 0) {
                speed = -1;
                step++;
            }
            for(int i=1; true; i++) {
                if(pos+speed <= target) return step+i;
                pos = pos+speed;
                speed = speed*2;
            }
        }
        return step;
    }
}
