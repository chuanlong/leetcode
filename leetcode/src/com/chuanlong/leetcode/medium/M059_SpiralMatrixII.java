package com.chuanlong.leetcode.medium;

public class M059_SpiralMatrixII {

	public static void main(String[] args) {

	}
	
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        final int d = -1;
        for(int i=0; i<n; i++){
        	for(int j=0; j<n; j++){
        		matrix[i][j] = d;
        	}
        }
        
        int direction = 0; // 0 right, 1 down, 2 left, 3 up
        int i=0, j=0;
        int count = 1;
        while(i>=0 && i<n && j>=0 && j<n && matrix[i][j] == d){
        	matrix[i][j] = count++;
        	
        	// move next
        	if(direction == 0 && j+1 < n && matrix[i][j+1] == d){
        		j++;
        	}else if(direction == 1 && i+1 < n && matrix[i+1][j] == d){
        		i++;
        	}else if(direction == 2 && j-1 >= 0 && matrix[i][j-1] == d){
        		j--;
        	}else if(direction == 3 && i-1 >= 0 && matrix[i-1][j] == d){
        		i--;
        	}else{
        		// turn
        		direction = (direction+1) % 4;
        		if(direction == 0){
        			j++;
        		}else if(direction == 1){
        			i++;
        		}else if(direction == 2){
        			j--;
        		}else if(direction == 3){
        			i--;
        		}
        	}
        }
    	
        return matrix;
    }

}
