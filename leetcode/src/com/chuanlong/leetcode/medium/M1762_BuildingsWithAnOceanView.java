package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M1762_BuildingsWithAnOceanView {

    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        int[] rightHeight = new int[n];
        List<Integer> buildings = new ArrayList<>();
        rightHeight[n-1] = 0;
        buildings.add(0, n-1);
        for(int i=n-2; i>=0; i--) {
            rightHeight[i] = Math.max(rightHeight[i+1], heights[i+1]);
            if(rightHeight[i] < heights[i]) {
                buildings.add(0, i);
            }
        }
        int[] results = new int[buildings.size()];
        for(int i=0; i<buildings.size(); i++) {
            results[i] = buildings.get(i);
        }
        return results;
    }


}
