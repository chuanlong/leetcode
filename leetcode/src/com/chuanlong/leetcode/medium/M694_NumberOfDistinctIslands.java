package com.chuanlong.leetcode.medium;

import javafx.util.Pair;

import java.util.*;

public class M694_NumberOfDistinctIslands {

    public static void main(String[] args) {
        M694_NumberOfDistinctIslands obj = new M694_NumberOfDistinctIslands();

        System.out.println("Test1, expect:1, output:" + obj.numDistinctIslands(new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}}));
    }

    public int numDistinctIslands(int[][] grid) {
        Map<Integer, List<TreeSet<Pair<Integer, Integer>>>> map = new HashMap<>();
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    TreeSet<Pair<Integer, Integer>> set = new TreeSet<>((a, b) -> {
                        if(a.getKey() == b.getKey()) return a.getValue() - b.getValue();
                        else return a.getKey() - b.getKey();
                    });
                    dfs(grid, i, j, set);
                    if(!map.containsKey(set.size())) map.put(set.size(), new ArrayList<>());
                    List<TreeSet<Pair<Integer, Integer>>> groups = map.get(set.size());
                    boolean isTranslated = false;
                    for(TreeSet<Pair<Integer, Integer>> treeSet: groups) {
                        if(isTranslated(treeSet, set)) {
                            isTranslated = true;
                            break;
                        }
                    }
                    if(!isTranslated) groups.add(set);
                }
            }
        }

        int cnt = 0;
        for(Integer key : map.keySet()) {
            cnt += map.get(key).size();
        }
        return cnt;
    }

    private boolean isTranslated(TreeSet<Pair<Integer, Integer>> set1, TreeSet<Pair<Integer, Integer>> set2) {
        if(set1.size() != set2.size()) return false;
        List<Pair<Integer, Integer>> list1 = new ArrayList<>(set1);
        List<Pair<Integer, Integer>> list2 = new ArrayList<>(set2);

        Pair<Integer, Integer> pair1 = list1.get(0);
        Pair<Integer, Integer> pair2 = list2.get(0);
        int xGap = pair1.getKey() - pair2.getKey(), yGap = pair1.getValue() - pair2.getValue();
        for(int i=1; i<set1.size(); i++) {
            Pair<Integer, Integer> pair11 = list1.get(i);
            Pair<Integer, Integer> pair22 = list2.get(i);
            if(pair11.getKey() - pair22.getKey() != xGap || pair11.getValue() - pair22.getValue() != yGap) return false;
        }
        return true;
    }

    private void dfs(int[][] grid, int x, int y, TreeSet<Pair<Integer, Integer>> set) {
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length) return;
        if(grid[x][y] == 0) return;
        set.add(new Pair(x, y));
        grid[x][y] = 0;
        dfs(grid, x-1, y, set);
        dfs(grid, x+1, y, set);
        dfs(grid, x, y-1, set);
        dfs(grid, x, y+1, set);
    }
}
