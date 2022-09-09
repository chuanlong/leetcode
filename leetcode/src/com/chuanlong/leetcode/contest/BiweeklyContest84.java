package com.chuanlong.leetcode.contest;

import java.util.*;

public class BiweeklyContest84 {

    public static void main(String[] args) {
        BiweeklyContest84 obj = new BiweeklyContest84();

        System.out.println("Test1, expect:9, output:" + obj.taskSchedulerII(new int[]{1,2,1,2,3,1}, 3));
        System.out.println("Test2, expect:6, output:" + obj.taskSchedulerII(new int[]{5,8,8,5}, 2));


        System.out.println("Test3, expect:2, output:" + obj.minimumReplacement(new int[]{3,9,3}));
        System.out.println("Test4, expect:0, output:" + obj.minimumReplacement(new int[]{1,2,3,4,5}));
        System.out.println("Test5, expect:6, output:" + obj.minimumReplacement(new int[]{12,9,7,6,17,19,21}));
    }

    // 07:25, 0 error
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<items1.length; i++) {
            int value = map.getOrDefault(items1[i][0], 0);
            value += items1[i][1];
            map.put(items1[i][0], value);
        }
        for(int i=0; i<items2.length; i++){
            int value = map.getOrDefault(items2[i][0], 0);
            value += items2[i][1];
            map.put(items2[i][0], value);
        }
        Object[] keys= map.keySet().toArray();
        Arrays.sort(keys);
        for(int i=0; i<keys.length; i++){
            list.add(Arrays.asList((int)keys[i], map.get(keys[i])));
        }
        return list;
    }

    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int x = nums[i] - i;
            int y = map.getOrDefault(x, 0);
            map.put(x, y+1);
        }
        Object[] keys = map.keySet().toArray();
        int sum = 0;
        for(int i=0; i<keys.length; i++){
            sum += map.get(keys[i]);
        }

        long counts = 0;
        for(int i=0; i<keys.length; i++) {
            int x = map.get(keys[i]);
            counts += x * (sum-x);
        }
        return counts/2;
    }


    // TLE
    public long countBadPairs2(int[] nums) {
        int counts = 0;
        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(j-i != nums[j]-nums[i]) counts++;
            }
        }
        return counts;
    }


    public long taskSchedulerII(int[] tasks, int space) {
        long days = 0;
        Map<Integer, Long> map = new HashMap<>();
        for(int i=0; i< tasks.length; i++) {
            days++;
            int type = tasks[i];
            if(map.containsKey(type)) {
                days = Math.max(days, map.get(type)+space+1);
            }
            map.put(type, days);
        }
        return days;
    }



    public long minimumReplacement(int[] nums) {
        long replaces = 0;
        int min = nums[nums.length-1];
        for(int i=nums.length-2; i>=0; i--) {
            int x = nums[i];
            if(x<=min) {
                min = x;
            } else {
                // do replacement
                if(x%min == 0) {
                    replaces += x/min-1;
                } else {
                    int replace = x/min;
                    min = x/(replace+1);
                    replaces += replace;
                }
            }
        }
        return replaces;
    }

}
