package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M886_PossibleBipartition {


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
