package com.chuanlong.leetcode.medium;

// 9:47 minutes, 0 error
public class M289_GameOfLife {

    public void gameOfLife(int[][] board) {
        int[][] next = new int[board.length][board[0].length];

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                int lifes = getLife(board, i-1, j-1);
                lifes+= getLife(board, i-1, j);
                lifes+= getLife(board, i-1, j+1);
                lifes+= getLife(board, i, j-1);
                lifes+= getLife(board, i, j+1);
                lifes+= getLife(board, i+1, j-1);
                lifes+= getLife(board, i+1, j);
                lifes+= getLife(board, i+1, j+1);

                if(board[i][j] == 1) {
                    if(lifes < 2) {
                        next[i][j] = 0;
                    } else if (lifes==2 || lifes==3) {
                        next[i][j] = 1;
                    } else {
                        next[i][j] = 0;
                    }
                } else {
                    if(lifes == 3) {
                        next[i][j] = 1;
                    }
                }
            }
        }

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                board[i][j] = next[i][j];
            }
        }
    }

    private int getLife(int[][] board, int i, int j) {
        if(i>=0 && i<board.length && j>=0 && j<board[0].length) {
            return board[i][j];
        }
        return 0;
    }


}
