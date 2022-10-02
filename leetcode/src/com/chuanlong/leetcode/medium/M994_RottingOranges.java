package com.chuanlong.leetcode.medium;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class M994_RottingOranges {


    public int orangesRotting(int[][] grid) {
        // [x,y]
        Queue<int[]> queue = new LinkedBlockingQueue<>();
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) if(grid[i][j] == 2) queue.offer(new int[]{i, j});
        }

        int minutes = -1;
        while(!queue.isEmpty()) {
            minutes++;
            for(int i=queue.size()-1; i>=0; i--) {
                int[] org = queue.poll();
                offerQueue(queue, grid, org[0]-1, org[1]);
                offerQueue(queue, grid, org[0]+1, org[1]);
                offerQueue(queue, grid, org[0], org[1]-1);
                offerQueue(queue, grid, org[0], org[1]+1);
            }
        }

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) if(grid[i][j] == 1) return -1;
        }
        return minutes==-1 ? 0 : minutes;
    }

    private void offerQueue(Queue<int[]> queue, int[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return;
        if(grid[i][j] == 1) {
            queue.offer(new int[]{i, j});
            grid[i][j] = 2;
        }
    }

}
