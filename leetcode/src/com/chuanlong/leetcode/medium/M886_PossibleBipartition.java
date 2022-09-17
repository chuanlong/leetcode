package com.chuanlong.leetcode.medium;

import java.util.*;

public class M886_PossibleBipartition {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n+1; i++) map.put(i, new ArrayList<>());
        for(int i=0; i<dislikes.length; i++) {
            map.get(dislikes[i][0]).add(dislikes[i][1]);
            map.get(dislikes[i][1]).add(dislikes[i][0]);
        }

        boolean[] color = new boolean[n+1];
        boolean[] visited = new boolean[n+1];
        for(int i=1; i<n+1; i++) {
            if(!visited[i]) {
                if(!dfs(map, visited, color, i)) return false;
            }
        }
        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> map, boolean[] visited, boolean[] color, int x) {
        visited[x] = true;
        for(int y : map.getOrDefault(x, new ArrayList<>())) {
            if(!visited[y]) {
                color[y] = !color[x];
                dfs(map, visited, color, y);
            }
            else if (color[y] == color[x]) return false;
        }
        return true;
    }



    public boolean possibleBipartition2(int n, int[][] dislikes) {
        boolean[][] matrix = new boolean[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                matrix[i][j] = true;
            }
        }
        for(int i=0; i<dislikes.length; i++) {
            matrix[dislikes[i][0]-1][dislikes[i][1]-1] = false;
            matrix[dislikes[i][1]-1][dislikes[i][0]-1] = false;
        }

        return group(0, n, new ArrayList<>(), new ArrayList<>(), matrix);
    }

    private boolean group(int deep, int n, List<Integer> g1, List<Integer> g2, boolean[][] matrix) {
        if(deep == n) {
            return true;
        }

        // check add g1
        boolean isG1OK = true;
        for(int i=0; i<g1.size(); i++) {
            if(!matrix[deep][g1.get(i)]) {
                isG1OK = false;
                break;
            }
        }
        if (isG1OK) {
            g1.add(deep);
            if(group(deep+1, n, g1, g2, matrix)) {
                return true;
            }
            g1.remove(g1.indexOf(deep));
        }

        // check add g2
        boolean isG2OK = true;
        for(int i=0; i<g2.size(); i++) {
            if(!matrix[deep][g2.get(i)]) {
                isG2OK = false;
                break;
            }
        }
        if(isG2OK) {
            g2.add(deep);
            if(group(deep+1, n, g1, g2, matrix)) {
                return true;
            }
            g2.remove(g2.indexOf(deep));
        }

        return false;
    }

}
