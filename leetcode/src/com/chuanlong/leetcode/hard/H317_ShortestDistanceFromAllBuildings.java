package com.chuanlong.leetcode.hard;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class H317_ShortestDistanceFromAllBuildings {

    public static void main(String[] args) {
        H317_ShortestDistanceFromAllBuildings obj = new H317_ShortestDistanceFromAllBuildings();

        System.out.println("Test1, expect:7, result:" + obj.shortestDistance(new int[][]{{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,1}}));
    }



    public int shortestDistance(int[][] grid) {

        return -1;
    }






//    public int shortestDistance(int[][] grid) {
//        List<Pair<Integer, Integer>> buildings = new ArrayList<>();
//        List<Pair<Integer, Integer>> lands = new ArrayList<>();
//        for(int i=0; i<grid.length; i++) {
//            for(int j=0; j<grid[0].length; j++) {
//                if(grid[i][j] == 0) {
//                    lands.add(new Pair<>(i,j));
//                } else if (grid[i][j] == 1) {
//                    buildings.add(new Pair<>(i,j));
//                }
//            }
//        }
//
//        int min = -1;
//        for(int x=0; x<lands.size(); x++) {
//            Pair land = lands.get(x);
//            int shortestDistance = shortestDistance(land, buildings, grid);
//            if(min == -1 || shortestDistance < min) {
//                min = shortestDistance;
//            }
//        }
//        return min;
//    }
//
//    private int shortestDistance(Pair<Integer, Integer> land, List<Pair<Integer, Integer>> buildings, int[][] grid) {
//        int[][] map = new int[grid.length][grid[0].length];
//        for(int i=0; i<grid.length; i++) {
//            for(int j=0; j<grid[0].length; j++) {
//                if(grid[i][j] == 1) {
//                    map[i][j] = -1;
//                } else if (grid[i][j] == 2) {
//                    map[i][j] = -2;
//                } else {
//                    map[i][j] = Integer.MAX_VALUE;
//                }
//            }
//        }
//
//        check(land.getKey(), land.getValue(), map, 0);
//
//        int sum = 0;
//        for(int i=0; i<buildings.size(); i++) {
//            Pair<Integer, Integer> building = buildings.get(i);
//            int x=building.getKey(), y=building.getValue();
//
//            int distance1 = getDistance(x-1, y, map);
//            int distance2 = getDistance(x+1, y, map);
//            int distance3 = getDistance(x, y-1, map);
//            int distance4 = getDistance(x, y+1, map);
//
//            int distance = distance1;
//            if(distance == -1 || (distance2 != -1 && distance2 < distance)) distance = distance2;
//            if(distance == -1 || (distance3 != -1 && distance3 < distance)) distance = distance3;
//            if(distance == -1 || (distance4 != -1 && distance4 < distance)) distance = distance4;
//
//            if(distance == -1) {
//                return -1;
//            }
//            sum += distance+1;
//        }
//        return sum;
//    }
//
//    private void check(int i, int j, int[][] map, int distance) {
//        if(i>=0 && i<map.length && j>=0 && j<map[0].length && map[i][j] > distance) {
//            map[i][j] = distance;
//            check(i-1, j, map, distance+1);
//            check(i+1, j, map, distance+1);
//            check(i, j-1, map, distance+1);
//            check(i, j+1, map, distance+1);
//        }
//    }
//
//    private int getDistance(int i, int j, int[][] map) {
//        if(i>=0 && i<map.length && j>=0 && j<map[0].length && map[i][j] > 0 && map[i][j] != Integer.MAX_VALUE) {
//            return map[i][j];
//        }
//        return -1;
//    }
//


}
