package com.chuanlong.leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 54:15 minutes, 4 errors
public class H765_CouplesHoldingHands {

    public static void main(String[] args) {
        H765_CouplesHoldingHands obj = new H765_CouplesHoldingHands();

        System.out.println("Test1, expect:1, output:" + obj.minSwapsCouples(new int[]{0,2,1,3}));
        System.out.println("Test2, expect:0, output:" + obj.minSwapsCouples(new int[]{3,2,0,1}));
        System.out.println("Test3, expect:26, output:" + obj.minSwapsCouples(new int[]{28,4,37,54,35,41,43,42,45,38,19,51,49,17,47,25,12,53,57,20,2,1,9,27,31,55,32,48,59,15,14,8,3,7,58,23,10,52,22,30,6,21,24,16,46,5,33,56,18,50,39,34,29,36,26,40,44,0,11,13}));
        System.out.println("Test4, expect:25, output:" + obj.minSwapsCouples(new int[]{44,6,9,20,27,59,23,46,26,39,43,17,45,32,0,54,41,18,4,3,53,56,15,28,21,33,36,8,55,48,14,51,50,52,7,49,35,22,31,16,1,13,34,19,42,30,58,38,10,57,2,11,37,12,29,25,5,24,47,40}));
    }

    public int minSwapsCouples(int[] row) {
        return minSwapsCouples(Arrays.stream(row).boxed().collect(Collectors.toList()), 0, new HashMap<List<Integer>, Integer>());
    }

    public int minSwapsCouples(List<Integer> row, int k, Map<List<Integer>, Integer> maps) {
        if(row.isEmpty() || row.size() == 2) {
            return updateMap(row, k, maps);
        }
        if(maps.containsKey(row)) {
            return maps.get(row);
        }

        int c1 = row.get(0);
        int c2 = getCouple(c1);
        int index = findIndexOf(row, c2);

        int newK;
        if(index == 1) {
            newK = k;
        } else {
            newK = k+1;
        }

        swipe(row, 1, index);
        row.remove(0);
        row.remove(0);
        int min = minSwapsCouples(row, newK, maps);
        row.add(0, c2);
        row.add(0, c1);
        swipe(row, 1, index);

        return updateMap(row, min, maps);
    }

    private int getCouple(int x) {
        if(x%2 == 0) return x+1;
        else return x-1;
    }

    private int getPosition(int index) {
        if(index%2 == 0) return index+1;
        else return index-1;
    }

    private int findIndexOf(List<Integer> row, int value) {
        for(int i=0; i<row.size(); i++) {
            if(row.get(i) == value) return i;
        }
        assert false; // assert error
        return -1;
    }

    private void swipe(List<Integer> row, int i, int j) {
        int temp = row.get(i);
        row.set(i, row.get(j));
        row.set(j, temp);
    }

    private int updateMap(List<Integer> list, int k, Map<List<Integer>, Integer> maps) {
        if(maps.containsKey(list)) {
            if(k < maps.get(list)) {
                maps.put(list, k);
                return k;
            } else {
                return maps.get(list);
            }
        } else {
            maps.put(list, k);
            return k;
        }
    }

}
