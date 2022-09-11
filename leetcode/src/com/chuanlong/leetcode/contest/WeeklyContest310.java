package com.chuanlong.leetcode.contest;

import javafx.util.Pair;

import java.util.*;

public class WeeklyContest310 {

    public static void main(String[] args) {
        WeeklyContest310 obj = new WeeklyContest310();

        System.out.println("Test1, expect:3, output:" + obj.minGroups(new int[][]{{5,10}, {6,8}, {1,5}, {2,3}, {1,10}}));
        System.out.println("Test2, expect:1, output:" + obj.minGroups(new int[][]{{1,3}, {5,6}, {8,10}, {11,13}}));
    }

    // 8:00, 0 error
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(nums[i]%2 == 0) {
                int count = map.getOrDefault(nums[i], 0);
                map.put(nums[i], count+1);
            }
        }

        int maxCount = 0;
        int maxNum = -1;
        for(int key : map.keySet()) {
            if(maxCount < map.get(key) || (maxCount == map.get(key) && key < maxNum)) {
                maxCount = map.get(key);
                maxNum = key;
            }

        }
        return maxNum;
    }

    // 8:00, 1 error WA
    public int partitionString(String s) {
        int partition = 1;
        int[] counts = new int[26];
        cleanup(counts);
        char[] chs = s.toCharArray();
        for(int i=0; i<chs.length; i++) {
            if(counts[chs[i]-'a'] > 0) {
                partition++;
                cleanup(counts);
            }
            counts[chs[i]-'a'] = 1;
        }
        return partition;
    }

    private void cleanup(int[] counts) {
        for(int i=0; i<counts.length; i++) {
            counts[i] = 0;
        }
    }

    // 50:57, 2 errors, discussion.
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) {
                return a[1]-b[1];
            } else {
                return a[0]-b[0];
            }
        });

        Queue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<intervals.length; i++) {
            int x = intervals[i][0];
            int y = intervals[i][1];
            if(!queue.isEmpty() && queue.peek() < x) {
                queue.poll();
            }
            queue.add(y);
        }
        return queue.size();
    }



    // TLE
    public int minGroups2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) {
                return a[1]-b[1];
            } else {
                return a[0]-b[0];
            }
        });

        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for(int i=0; i<intervals.length; i++) {
            list.add(new Pair<>(intervals[i][0], intervals[i][1]));
        }
        int groups = 0;
        while(list.size() > 0) {
            list = removeOneGroup(list);
            groups++;
        }
        return groups;
    }

    private List<Pair<Integer, Integer>> removeOneGroup(List<Pair<Integer, Integer>> list) {
        List<Pair<Integer, Integer>> group = new ArrayList<>();
        Pair<Integer, Integer> pair = list.get(0);
        group.add(pair);
        int y = pair.getValue();
        for(int i=1; i<list.size(); i++) {
            if(!conflict(y, list.get(i).getKey())) {
                group.add(list.get(i));
                y = list.get(i).getValue();
            }
        }
        list.removeAll(group);
        return list;
    }

    private boolean conflict(int y1, int x2) {
        if(y1 < x2) {
            return false;
        } else {
            return true;
        }
    }


    public int lengthOfLIS(int[] nums, int k) {
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        for(int i=0; i<nums.length; i++) {
            if(!map.containsKey(nums[i])) map.put(nums[i], new TreeSet<>());
            map.get(nums[i]).add(i);
        }

        int max = 1;
        List<Integer> keySet = new ArrayList<>(map.keySet());
        for(int i=0; i<keySet.size(); i++) {
            if(keySet.size()-i == max) break;

            int tail = keySet.get(i);


        }

        return max;
    }

}
