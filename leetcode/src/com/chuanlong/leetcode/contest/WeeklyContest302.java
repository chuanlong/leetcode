package com.chuanlong.leetcode.contest;

import java.util.HashMap;
import java.util.Map;

public class WeeklyContest302 {

    public static void main(String[] args) {
        WeeklyContest302 obj =new WeeklyContest302();

        System.out.println("Test1, expect:54, output:" + obj.maximumSum(new int[]{18,43,36,13,7}));
        System.out.println("Test2, expect:-1, output:" + obj.maximumSum(new int[]{10,12,19,14}));
        System.out.println("Test3, expect:12, output:" + obj.maximumSum(new int[]{4, 6, 10, 6}));

    }

    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], count+1);
        }

        int x=0, y=0;
        for(int key : map.keySet()) {
            int value = map.get(key);
            x+= value/2;
            y+= value%2;
        }
        return new int[]{x, y};
    }


    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> cache = new HashMap<>();
        int max = -1;
        for(int i=0; i<nums.length; i++) {
            int digits = getDigits(nums[i], cache);
            if(!map.containsKey(digits)) {
                map.put(digits, i);
            } else {
                max = Math.max(max, nums[map.get(digits)] + nums[i]);
                if(nums[map.get(digits)] < nums[i]) {
                    map.put(digits, i);
                }
            }
        }
        return max;
    }

    private int getDigits(int x, Map<Integer, Integer> cache) {
        if(cache.containsKey(x)) return cache.get(x);
        int sum = 0;
        while(x>0) {
            sum+= x%10;
            x = x/10;
        }
        cache.put(x, sum);
        return sum;
    }

}
