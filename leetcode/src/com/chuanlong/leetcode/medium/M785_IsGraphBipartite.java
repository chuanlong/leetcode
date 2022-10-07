package com.chuanlong.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class M785_IsGraphBipartite {

    public static void main(String[] args) {
        M785_IsGraphBipartite obj = new M785_IsGraphBipartite();

        System.out.println("Test1, expect:true, output:" + obj.isBipartite(new int[][]{{3}, {2,4},{1},{0,4},{1,3}}));
    }


    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n]; // default 0
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            if(visited[i] != 0) continue;
            stack.push(i);
            visited[i] = 1;
            while(!stack.isEmpty()) {
                int u = stack.pop();
                int uGroup = visited[u];
                int vGroup = uGroup == 1 ? 2 : 1;
                for(int v: graph[u]) {
                    if(visited[v] == 0) {
                        visited[v] = vGroup;
                        stack.push(v);
                    } else {
                        if(visited[v] == uGroup) return false;
                    }
                }
            }
        }
        return true;
    }


    // TLE
    public boolean isBipartite2(int[][] graph) {
        int[] visited = new int[graph.length];
        flag = false;
        backtrack(visited, graph, 0);
        return flag;
    }

    boolean flag = false;
    private void backtrack(int[] visited, int[][] graph, int u) {
        if(flag) return;
        if(u>=graph.length) {
            flag = true;
            return;
        }

        int[] v = graph[u];
        if (visited[u] != 0) {
            int vGroup = visited[u] == 1 ? 2 : 1;
            Map<Integer, Integer> newVisited = filledWithGroup(visited, v, vGroup);
            if(newVisited != null) {
                for(Integer vv: newVisited.keySet()) visited[vv] = vGroup;
                backtrack(visited, graph, u+1);
                for(Integer vv: newVisited.keySet()) visited[vv] = newVisited.get(vv);
            }
        } else {
            Map<Integer, Integer> newVisited = filledWithGroup(visited, v, 1);
            if(newVisited != null) {
                for(Integer vv: newVisited.keySet()) visited[vv] = 1;
                backtrack(visited, graph, u+1);
                for(Integer vv: newVisited.keySet()) visited[vv] = newVisited.get(vv);
            }

            newVisited = filledWithGroup(visited, v, 2);
            if(newVisited != null) {
                for(Integer vv: newVisited.keySet()) visited[vv] = 2;
                backtrack(visited, graph, u+1);
                for(Integer vv: newVisited.keySet()) visited[vv] = newVisited.get(vv);
            }
        }
    }


    private Map<Integer, Integer> filledWithGroup(int[] visited, int[] v, int vGroup) {
        Map<Integer, Integer> newVisited = new HashMap<>();
        for(int i=0; i<v.length; i++) {
            if(visited[v[i]] == vGroup || visited[v[i]] == 0) {
                newVisited.put(v[i], visited[v[i]]);
            } else {
                return null;
            }
        }
        return newVisited;
    }
}
