package com.chuanlong.leetcode.hard;

import java.util.*;

public class H493_ReversePairs {

    public static void main(String[] args) {
        H493_ReversePairs obj = new H493_ReversePairs();

        System.out.println("Test1, expect:2, output:" + obj.reversePairs2(new int[]{1,3,2,3,1}));
        System.out.println("Test2, expect:3, output:" + obj.reversePairs2(new int[]{2,4,3,5,1}));
        System.out.println("Test3, expect:1, output:" + obj.reversePairs2(new int[]{-5,-5}));
        System.out.println("Test4, expect:9, output:" + obj.reversePairs2(new int[]{2147483647,2147483647,-2147483647,-2147483647,-2147483647,2147483647}));



//        System.out.println("Test11, expect:0, output:" + obj.indexOfLarge(Arrays.asList(2), 0));
    }



    private void insert(int num, List<Integer> list) {
        int s = 0, e = list.size()-1;
        while(s<e) {
            int m = s + (e-s)/2;
            if(list.get(m) == num) {
                list.add(m, num);
            } else if (list.get(m) < num) {

            } else {
                // list.get(m) > num
            }
        }

    }

    // WA
    public int reversePairs2(int[] nums) {
        TreeMap<Long, TreeSet<Integer>> map = new TreeMap<>();

        for(int i=0; i<nums.length; i++) {
            if(!map.containsKey((long)nums[i])) map.put((long)nums[i], new TreeSet<>());
            map.get((long)nums[i]).add(i);
        }
        int count = 0;
        List<Long> keys = new ArrayList<>(map.keySet());
        for(int i=0; i<keys.size(); i++) {
            long key = keys.get(i);
            List<Integer> indexes = new ArrayList<>(map.get(key));
            int key2Index = indexOfLarge(keys, key*2);
            if(key2Index <= i) count += (indexes.size()*(indexes.size()-1)/2);
            if(key2Index == -1) continue;

            for(int j=0; j<indexes.size(); j++) {
                int index = indexes.get(j);
                for(int k=key2Index; k<keys.size(); k++) {
                    if(k != i) {
                        List<Integer> indexes2 = new ArrayList<>(map.get(keys.get(k)));
                        int x = countSmaller(indexes2, index);
                        count += x;
                    }
                }
            }
        }

        return count;
    }

    private int indexOfLarge(List<Long> list, long value) {
//        int count = (int) list.stream().filter(a -> a > value).count();
//        if(count == 0) return -1;
//        return list.size() - count;

        int start = 0, end = list.size()-1;
        if(value >= list.get(end)) return -1;

        while(start <= end) {
            int mid = (start+end)/2;
            if(list.get(mid) == value) {
                return mid+1;
            } else if (list.get(mid) < value) {
                start = mid+1;
            } else {
                // list.get(mid) > value
                if(mid == 0 || list.get(mid-1) <= value) {
                    return mid;
                } else {
                    end = mid-1;
                }
            }
        }
        return -1;
    }

    private int countSmaller(List<Integer> list, int value) {
        return (int) list.stream().filter(a -> a<value).count();
    }



}
