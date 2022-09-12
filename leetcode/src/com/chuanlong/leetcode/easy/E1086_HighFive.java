package com.chuanlong.leetcode.easy;

import java.util.*;

public class E1086_HighFive {

    public int[][] highFive(int[][] items) {
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        for(int i=0; i<items.length; i++) {
            int id = items[i][0];
            int score = items[i][1];
            if(!map.containsKey(id)) map.put(id, new PriorityQueue<>((a,b) -> 0-a.compareTo(b)));
            PriorityQueue<Integer> set = map.get(id);
            set.add(score);
        }
        int[][] scores = new int[map.size()][2];
        List<Integer> ids = new ArrayList<>(map.keySet());
        for(int i=0; i<ids.size(); i++) {
            PriorityQueue<Integer> set = map.get(ids.get(i));
            int average = 0;
            for(int j=0; j<5; j++) {
                average += set.poll();
            }
            average = average/5;
            scores[i][0] = ids.get(i);
            scores[i][1] = average;
        }
        return scores;
    }


}
