package com.chuanlong.leetcode.hard;

import java.util.*;
import java.util.stream.Collectors;

public class H1235_MaximumProfitInJobScheduling {

    public static void main(String[] args) {
        H1235_MaximumProfitInJobScheduling obj = new H1235_MaximumProfitInJobScheduling();

        System.out.println("Test1, expect:120, result:" + obj.jobScheduling(new int[]{1,2,3,3}, new int[]{3,4,5,6}, new int[]{50,10,40,70}));
        System.out.println("Test2, expect:150, result:" + obj.jobScheduling(new int[]{1,2,3,4,6,}, new int[]{3,5,10,6,9}, new int[]{20,20,100,70,60}));

        System.out.println("Test3, expect:41, result:" + obj.jobScheduling(new int[]{6,15,7,11,1,3,16,2}, new int[]{19,18,19,16,10,8,19,8}, new int[]{2,9,1,19,5,7,3,19}));
    }
//
//
//    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
//        sortAsc(startTime, endTime, profit, 0, startTime.length-1);
//        int[] maxProfits = new int[startTime.length];
//
//
//        return jobScheduling(startTime, endTime, profit, startTime.length-1, maxProfits);
//    }
//
//    public int jobScheduling(int[] startTime, int[] endTime, int[] profit, int index, int[] maxProfit) {
//
//
//
//        return maxProfit[index];
//    }



    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        TreeMap<Integer, Integer> points = new TreeMap<>();
        TreeMap<Integer, TreeSet<int[]>> map = new TreeMap<>();
        int n = startTime.length;
        for(int i=0; i<n; i++) {
            if(!map.containsKey(endTime[i])) map.put(endTime[i], new TreeSet<>((a, b) -> {
                if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
                else return Integer.compare(a[0], b[0]);
            }));
            map.get(endTime[i]).add(new int[]{startTime[i], profit[i]});
            points.put(startTime[i], 0);
            points.put(endTime[i], 0);
        }

        List<Integer> keys = new ArrayList<>(points.keySet());
        for(int i=1; i<keys.size(); i++) {
            int key = keys.get(i);
            int max = points.get(keys.get(i-1));
            if(map.containsKey(key)) for(int[] pair: map.get(key)) max = Math.max(max, points.get(pair[0]) +pair[1]);
            points.put(key, max);
        }
        return points.lastEntry().getValue();
    }


    public int jobScheduling2(int[] startTime, int[] endTime, int[] profit) {
        sortAsc(endTime, startTime, profit, 0, endTime.length-1);

        List<Integer> points = getPoints(startTime, endTime);
        int size = points.size();
        int[] maxProfits = new int[size+1];
        maxProfits[0] = 0;
        int i=1, j=0;
        while (i<=size || j < endTime.length) {
            int point = points.get(i-1);
            if (j == endTime.length || endTime[j] > point) {
                maxProfits[i] = Math.max(maxProfits[i], maxProfits[i-1]);
                i++;
            } else {
                assert point == endTime[j];
                maxProfits[i] = Math.max(maxProfits[binarySearch(points, startTime[j], 0, points.size()-1)+1] + profit[j], Math.max(maxProfits[i], maxProfits[i-1]));
                j++;
            }
        }

        return maxProfits[size];
    }

    private int binarySearch(List<Integer> points, int value, int i, int j) {
        if(i == j) {
            assert points.get(i) == value;
            return i;
        }

        int mid = (i+j) / 2;
        if(points.get(mid) == value) {
            return mid;
        } else if (points.get(mid) < value) {
            return binarySearch(points, value, mid+1, j);
        } else {
            return binarySearch(points, value, i, mid-1);
        }
    }

    private List<Integer> getPoints(int[] startTime, int[] endTime) {
        List<Integer> list = new ArrayList<>();

        // add all
        list.addAll(Arrays.stream(startTime).boxed().collect(Collectors.toList()));
        list.addAll(Arrays.stream(endTime).boxed().collect(Collectors.toList()));

        // remove duplicate
        List<Integer> listWithoutDuplicates = new ArrayList<>(new HashSet<>(list));

        // sort asc
        Collections.sort(listWithoutDuplicates);

        return listWithoutDuplicates;
    }

    private void sortAsc(int[] array1, int[] core, int[] array2, int start, int end) {
        if(start < end) {
            int key = core[start];
            int keyStart = array1[start];
            int keyProfit = array2[start];
            int i=start, j=end;
            while(i<j) {
                while(i<j && core[j] >= key) j--;
                core[i] = core[j];
                array1[i] = array1[j];
                array2[i] = array2[j];
                while(i<j && core[i] <= key) i++;
                core[j] = core[i];
                array1[j] = array1[i];
                array2[j] = array2[i];
            }
            core[i] = key;
            array1[i] = keyStart;
            array2[i] = keyProfit;

            sortAsc(core, array1, array2, start, i-1);
            sortAsc(core, array1, array2, i+1, end);
        }
    }

}
