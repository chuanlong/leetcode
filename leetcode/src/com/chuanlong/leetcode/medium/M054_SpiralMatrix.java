package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M054_SpiralMatrix {

	public static void main(String[] args) {

	}
	
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if(matrix != null 
        		&& matrix.length != 0
        		&& matrix[0].length != 0){
        	int width = matrix[0].length;
        	int height = matrix.length;
        	
        	int up = 0, down = height-1;
        	int left = 0, right = width-1;
        	
        	int i=0, j=0;
        	int direction = 0; // 0 right, 1 down, 2 left, 3 up
			while (i >= up && i <= down 
					&& j >= left && j <= right) {
				list.add(matrix[i][j]);

				// move next
				if (direction == 0 && j + 1 <= right) {
					j++;
				} else if (direction == 1 && i + 1 <= down) {
					i++;
				} else if (direction == 2 && j - 1 >= left) {
					j--;
				} else if (direction == 3 && i - 1 >= up) {
					i--;
				} else {
					// turn
					direction = (direction + 1) % 4;
					if(direction == 0){
						j++;left++;
					}else if(direction == 1){
						i++;up++;
					}else if(direction == 2){
						j--;right--;
					}else if(direction == 3){
						i--;down--;
					}
				}
			}
        	
        }
        return list;
    }

}
