package com.chuanlong.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class M1834_SingleThreadedCPU {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] order = new int[n];

        // [enqueueTime, processingTime, index]
        int[][] newTasks = new int[n][3];
        for(int i=0; i<tasks.length; i++) {
            newTasks[i][0] = tasks[i][0];
            newTasks[i][1] = tasks[i][1];
            newTasks[i][2] = i;
        }
        Arrays.sort(newTasks, (a, b) -> {
            if(a[0] == b[0]) {
                if(a[1] == b[1]) return a[2]-b[2];
                else return a[1]-b[1];
            }
            else return a[0]-b[0];
        });

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if(a[1] == b[1]) return a[2]-b[2];
            else return a[1]-b[1];
        });
        int currentTime = 0;
        int index = 0, index2 = 0;
        while(!queue.isEmpty() || index<n) {
            while(index<n && newTasks[index][0]<=currentTime) {
                queue.add(newTasks[index]);
                index++;
            }
            if(!queue.isEmpty()) {
                int[] task = queue.poll();
                currentTime = currentTime + task[1];
                order[index2++] = task[2];
            } else {
                if(index<n) {
                    queue.add(newTasks[index]);
                    currentTime = newTasks[index][0];
                    index++;
                }
            }
        }
        return order;
    }
}
