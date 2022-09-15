package com.chuanlong.leetcode.medium;

import java.util.*;

public class M207_CourseSchedule {

    public static void main(String[] args) {
        M207_CourseSchedule obj = new M207_CourseSchedule();

        System.out.println("Test1, expect:true, output:" + obj.canFinish(5, new int[][]{{1,4}, {2,4}, {3,1}, {3,2}}));
        System.out.println("Test2, expect:false, output:" + obj.canFinish(5, new int[][]{{1,4}, {2,2}, {3,1}, {3,2}}));
        System.out.println("Test3, expect:false, output:" + obj.canFinish(8, new int[][]{{1,0}, {2,6}, {1,7}, {5,1}, {6,4}, {7,0}, {0,5}}));
    }


    // TLE
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        for(int i=0; i<prerequisites.length; i++) {
            // a depends on b
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            if(!map.containsKey(b)) map.put(b, new TreeSet<>());
            map.get(b).add(a);
        }
        Map<Integer, Boolean> visited = new HashMap<>();
        for(int i=0; i<numCourses; i++) {
            Stack<Integer> stack = new Stack<>();
            if(!check(stack, i, map, visited)) return false;
        }
        return true;
    }

    private boolean check(Stack<Integer> stack, int x, Map<Integer, TreeSet<Integer>> map, Map<Integer, Boolean> visited) {
        if(stack.contains(x)) {
            visited.put(x, false);
            return false;
        }
        if(visited.containsKey(x)) return visited.get(x);
        if(map.containsKey(x)) {
            stack.push(x);
            for(int y: map.get(x)) {
                if(!check(stack, y, map, visited)) {
                    visited.put(x, false);
                    return false;
                }
            }
            stack.pop();
        }
        visited.put(x, true);
        return true;
    }


}
