package com.chuanlong.leetcode;

public class ValidSudoku {

	/**
	 * https://oj.leetcode.com/problems/valid-sudoku/
	 */
	public static void main(String[] args) {

		char[][] board = { ".87654321".toCharArray(),
				"2........".toCharArray(), "3........".toCharArray(),
				"4........".toCharArray(), "5........".toCharArray(),
				"6........".toCharArray(), "7........".toCharArray(),
				"8........".toCharArray(), "9........".toCharArray() };

		ValidSudoku instance = new ValidSudoku();

		boolean b1 = instance.isValidSudoku(board);

	}

	public boolean isValidSudoku(char[][] board) {

		int[][] a = new int[9][9];
		int[][] b = new int[9][9];
		int[][] c = new int[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				a[i][j] = 0;
				b[i][j] = 0;
				c[i][j] = 0;
			}
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				if (board[i][j] != '.') {

					int x = (int) board[i][j] - 49;

					if (a[i][x] == 0 && b[j][x] == 0
							&& c[(j / 3) + (i / 3) * 3][x] == 0) {
						a[i][x] = b[j][x] = c[(j / 3) + (i / 3) * 3][x] = 1;
					} else {
						return false;
					}

				}

			}
		}

		return true;
	}

}
