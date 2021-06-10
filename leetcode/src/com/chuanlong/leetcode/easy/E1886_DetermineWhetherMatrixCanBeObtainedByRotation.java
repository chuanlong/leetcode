package com.chuanlong.leetcode.easy;

public class E1886_DetermineWhetherMatrixCanBeObtainedByRotation {


    public boolean findRotation(int[][] mat, int[][] target) {
        if(equal(mat, target)) {
            return true;
        }
        int[][] rotate1 = rotate(mat);
        if (equal(rotate1, target)) {
            return true;
        }
        int[][] rotate2 = rotate(rotate1);
        if(equal(rotate2, target)) {
            return true;
        }
        int[][] rotate3 = rotate(rotate2);
        if(equal(rotate3, target)) {
            return true;
        }
        return false;
    }

    public int[][] rotate(int[][] mat) {
        int n = mat.length;
        int[][] newMat = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                newMat[j][n-1-i] = mat[i][j];
            }
        }
        return newMat;
    }

    public boolean equal(int[][] mat, int[][] mat2) {
        int n = mat.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] != mat2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
