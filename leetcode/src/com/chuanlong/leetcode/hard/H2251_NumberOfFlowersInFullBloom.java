package com.chuanlong.leetcode.hard;

import java.util.*;

public class H2251_NumberOfFlowersInFullBloom {

    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        Arrays.sort(flowers, (a, b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            else return a[0]-b[0];
        });

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for(int i=0; i<persons.length; i++) {
            if(!map.containsKey(persons[i])) map.put(persons[i], new ArrayList<>());
            map.get(persons[i]).add(i);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->{
            if(a[1]==b[1]) return a[0]-b[0];
            else return a[1]-b[1];
        });
        int index = 0;
        int[] result = new int[persons.length];
        for(int key : map.keySet()) {
            while(index<flowers.length && flowers[index][0]<=key) {
                queue.offer(flowers[index++]);
            }

            while(queue.size() > 0 && queue.peek()[1]<key) {
                queue.poll();
            }

            for(int flo: map.get(key)) {
                result[flo] = queue.size();
            }
        }
        return result;
    }

}
