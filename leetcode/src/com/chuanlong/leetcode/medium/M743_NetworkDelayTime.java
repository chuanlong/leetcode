package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M743_NetworkDelayTime {

    public static void main(String[] args) {

        int[][] times =
        {
            {2,1,1},
            {2,3,1},
            {3,4,1}
        };

        M743_NetworkDelayTime obj = new M743_NetworkDelayTime();
        int x = obj.networkDelayTime(times, 4, 2);
        System.out.println("out:" + x);
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] map = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                map[i][j] = -1;
            }
            map[i][i] = 0;
        }
        for(int i=0; i<times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            map[u-1][v-1] = w;
        }

        int[] dist = new int[N];
        boolean[] set = new boolean[N];
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            dist[i] = -1;
            set[i] = false;
        }
        dist[K-1] = 0;
        list.add(K-1);

        while(!list.isEmpty()) {
            int index = 0;
            for(int i=1; i<list.size(); i++) {
                if(dist[list.get(i)] != -1 && dist[list.get(i)] < dist[list.get(index)]) {
                    index = i;
                }
            }
            int node = list.get(index);
            list.remove(index);
            set[node] = true;

            for(int i=0; i<N; i++) {
                if(map[node][i] != -1) {
                    if(dist[i] == -1) {
                        dist[i] = dist[node] + map[node][i];
                    } else {
                        dist[i] = (dist[node] + map[node][i])<dist[i] ? (dist[node] + map[node][i]) : dist[i];
                    }

                    if(!list.contains(i) && set[i]==false) {
                        list.add(i);
                    }
                }
            }
        }

        int time = -1;
        for(int i=0; i<N; i++) {
            if (dist[i] == -1) {
                time = -1;
                break;
            } else {
                time = dist[i] > time ? dist[i] : time;
            }
        }

        return time;
    }


}
