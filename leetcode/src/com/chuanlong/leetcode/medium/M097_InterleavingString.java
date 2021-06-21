package com.chuanlong.leetcode.medium;

public class M097_InterleavingString {

    public static void main(String[] args) {

    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        char[] chs3 = s3.toCharArray();

        int n = chs1.length;
        int m = chs2.length;

        boolean[][] matrix = new boolean[n+1][m+1];
        matrix[0][0] = true;
        for(int i=1; i<n+1; i++) {
            if(matrix[i-1][0] && chs1[i-1] == chs3[i-1]) {
                matrix[i][0] = true;
            }
        }
        for(int j=1; j<m+1; j++) {
            if (matrix[0][j-1] && chs2[j-1] == chs3[j-1]) {
                matrix[0][j] = true;
            }
        }


        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if (matrix[i-1][j] && chs1[i-1] == chs3[i+j-1]) {
                    matrix[i][j] = true;
                } else if(matrix[i][j-1] && chs2[j-1] == chs3[i+j-1]) {
                    matrix[i][j] = true;
                } else {
                    matrix[i][j] = false;
                }
            }
        }

        return matrix[n][m];
    }
}
