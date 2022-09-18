package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M1042_FlowerPlantingWithNoAdjacent {

    public static void main(String[] args) {
        M1042_FlowerPlantingWithNoAdjacent obj = new M1042_FlowerPlantingWithNoAdjacent();

//        System.out.println("Test1, expect:[1,2,3], output:" + Util.Array2String(obj.gardenNoAdj(3, new int[][]{{1,2},{2,3},{3,1}})));
//        System.out.println("Test2, expect:[1,2,1,2], output:" + Util.Array2String(obj.gardenNoAdj(4, new int[][]{{1,2},{3,4}})));
//        System.out.println("Test3, expect:[1,2,3,4], output:" + Util.Array2String(obj.gardenNoAdj(4, new int[][]{{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}})));
        System.out.println("Test3, expect:[], output:" + Util.Array2String(obj.gardenNoAdj(6, new int[][]{{6,4},{6,1},{3,1},{4,5},{2,1},{5,6},{5,2}})));
    }


    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<paths.length; i++) {
            int u = paths[i][0], v = paths[i][1];
            if(!map.containsKey(u)) map.put(u, new ArrayList<>());
            if(!map.containsKey(v)) map.put(v, new ArrayList<>());
            map.get(u).add(v);
            map.get(v).add(u);
        }

        int[] painted = new int[n];
        for(int i=0; i<n; i++) {
            paint(i+1, painted, map);
        }

        return painted;
    }

    private boolean paint(int pos, int[] painted, Map<Integer, List<Integer>> map) {
        if(painted[pos-1] > 0) return true;
        boolean done = paint(pos, 1, painted, map);
        if(!done) done = paint(pos, 2, painted, map);
        if(!done) done = paint(pos, 3, painted, map);
        if(!done) done = paint(pos, 4, painted, map);
        return done;
    }


    private boolean paint(int pos, int color, int[] painted, Map<Integer, List<Integer>> map) {
        if(painted[pos-1] > 0) {
            if(painted[pos-1] == color) return true;
            else return false;
        }

        if (map.containsKey(pos)) {
            painted[pos-1] = color;
            List<Integer> list = map.get(pos);
            for(Integer nei : list) {
                if(painted[nei-1] > 0) {
                    if(painted[nei-1] == color) {
                        painted[pos-1] = 0;
                        return false;
                    }
                } else {
                    int k = color%4+1;
                    while(k != color) {
                        if(paint(nei, k, painted, map)) break;
                        k = k%4+1;
                    }
                    if(k == color) {
                        painted[pos-1] = 0;
                        return false;
                    }
                }
            }
            return true;
        } else {
            painted[pos-1] = color;
            return true;
        }
    }
}
