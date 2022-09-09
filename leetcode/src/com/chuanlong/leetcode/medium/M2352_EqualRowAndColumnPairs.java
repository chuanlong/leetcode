package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M2352_EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        Map<List<Integer>, Integer> rows = new HashMap<>();
        Map<List<Integer>, Integer> colums = new HashMap<>();
        int n = grid.length;
        for(int i=0; i<n; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<n; j++) {
                row.add(grid[i][j]);
            }
            int count = rows.getOrDefault(row, 0);
            rows.put(row, count+1);
        }
        for(int j=0; j<n; j++) {
            List<Integer> colum = new ArrayList<>();
            for(int i=0; i<n; i++) {
                colum.add(grid[i][j]);
            }
            int count = colums.getOrDefault(colum, 0);
            colums.put(colum, count+1);
        }

        int pairs = 0;
        for(List<Integer> rowKey : rows.keySet()) {
            for(List<Integer> columKey : colums.keySet()) {
                if(rowKey.equals(columKey)) {
                    pairs += rows.get(rowKey) * colums.get(columKey);
                }
            }
        }
        return pairs;
    }
}
