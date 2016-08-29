package com.chuanlong.leetcode.hard;

import java.util.Arrays;


public class H329_LongestIncreasingPathInAMatrix {

	/**
	 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
	 */
	public static void main(String[] args) {

	}
	
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
        	return 0;
        }

        int xLength = matrix[0].length;
        int yLength = matrix.length;
        
        Item[] array = new Item[xLength * yLength];
        for(int y=0; y<yLength; y++){
        	for(int x=0; x<xLength; x++){
        		array[y*xLength + x] = new Item(x, y, matrix[y][x]);
        	}
        }
        
        // sort in ascending order
        Arrays.sort(array);
               
        int[][] path = new int[yLength][xLength];
        for(int i=0; i<array.length; i++){
        	Item item = array[i];
        	
        	int longerPath = 0;
        	
        	// up
        	longerPath = (item.y-1 >= 0 && matrix[item.y][item.x] != matrix[item.y-1][item.x] && path[item.y-1][item.x] > longerPath) ? path[item.y-1][item.x] : longerPath;
        	
        	// down
        	longerPath = (item.y+1 < yLength && matrix[item.y][item.x] != matrix[item.y+1][item.x] && path[item.y+1][item.x] > longerPath) ? path[item.y+1][item.x] : longerPath;
        	
        	// left
        	longerPath = (item.x-1 >= 0 && matrix[item.y][item.x] != matrix[item.y][item.x-1] &&  path[item.y][item.x-1] > longerPath) ? path[item.y][item.x-1] : longerPath;
        	
        	// right
        	longerPath = (item.x+1 < xLength && matrix[item.y][item.x] != matrix[item.y][item.x+1] && path[item.y][item.x+1] > longerPath) ? path[item.y][item.x+1] : longerPath;
        	
        	path[item.y][item.x] = longerPath+1;
        }
        
        int longestPath = 0;
        for(int y=0; y<yLength; y++){
        	for(int x=0; x<xLength; x++){
        		longestPath = path[y][x] > longestPath ? path[y][x] : longestPath;
        	}
        }
        
        return longestPath;
    }
    
    
    class Item implements Comparable<Item>{
    	public int x;
    	public int y;
    	public int val;
    	
    	public Item(int x, int y, int val){
    		this.x = x;
    		this.y = y;
    		this.val = val;
    	}

		@Override
		public int compareTo(Item o) {
			if(val < o.val){
				return -1;
			}else if(val > o.val){
				return 1;
			}else{
				return 0;
			}
		}
    }

}
