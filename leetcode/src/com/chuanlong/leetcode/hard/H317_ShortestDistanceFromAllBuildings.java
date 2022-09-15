package com.chuanlong.leetcode.hard;


import javafx.util.Pair;
import java.util.*;

public class H317_ShortestDistanceFromAllBuildings {

    public static void main(String[] args) {
        H317_ShortestDistanceFromAllBuildings obj = new H317_ShortestDistanceFromAllBuildings();

        System.out.println("Test1, expect:7, result:" + obj.shortestDistance(new int[][]{{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}}));
    }

    // TLE
    public int shortestDistance(int[][] grid) {
        TreeSet<Pair<Integer, Integer>> lands = new TreeSet<>((a,b) -> {
            if(a.getKey() == b.getKey()) return Integer.compare(a.getValue(), b.getValue());
            else return Integer.compare(a.getKey(), b.getKey());
        });
        TreeSet<Pair<Integer, Integer>> buildings = new TreeSet<>((a,b) -> {
            if(a.getKey() == b.getKey()) return Integer.compare(a.getValue(), b.getValue());
            else return Integer.compare(a.getKey(), b.getKey());
        });
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 0) lands.add(new Pair<>(i, j));
                else if(grid[i][j] == 1) buildings.add(new Pair<>(i, j));
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    min = Math.min(min, bfs(grid, i, j, buildings, lands));
                }
            }
        }
        if(min == Integer.MAX_VALUE) return -1;
        return min;
    }

    private int bfs(int[][] grid, int x, int y, TreeSet<Pair<Integer, Integer>> buildings, TreeSet<Pair<Integer, Integer>> lands) {
        Map<Pair<Integer, Integer>, Integer> distances = new HashMap<>();
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        Pair<Integer, Integer> root = new Pair<>(x, y);
        distances.put(root, 0);
        queue.add(root);
        int countHouse = 0;
        while(queue.size() > 0 && countHouse < buildings.size()) {
            Pair<Integer, Integer> pair = queue.poll();
            int x1 = pair.getKey(), y1 = pair.getValue();
            int distance1 = distances.get(pair)+1;
            countHouse += check(grid, x1-1, y1, distance1, distances, queue);
            countHouse += check(grid, x1+1, y1, distance1, distances, queue);
            countHouse += check(grid, x1, y1-1, distance1, distances, queue);
            countHouse += check(grid, x1, y1+1, distance1, distances, queue);
        }

        if(countHouse == buildings.size()) {
            int min = 0;
            for(Pair<Integer, Integer> building : buildings) {
                min += distances.get(building);
            }
            return min;
        } else {
            TreeSet<Pair<Integer, Integer>> landsClone = new TreeSet<>(lands);
            for(Pair<Integer, Integer> land : landsClone) {
                if(distances.containsKey(land)) {
                    lands.remove(land);
                    grid[land.getKey()][land.getValue()] = 2;
                }
            }
            return Integer.MAX_VALUE;
        }
    }

    private int check(int[][] grid, int x, int y, int distance,
                      Map<Pair<Integer, Integer>, Integer> distances,
                      Queue<Pair<Integer, Integer>> queue) {
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length) return 0;
        if(grid[x][y] == 2) return 0;
        Pair<Integer, Integer> pair = new Pair<>(x, y);
        if(distances.containsKey(pair)) return 0;

        if(grid[x][y] == 0) {
            queue.add(pair);
            distances.put(pair, distance);
            return 0;
        } else if (grid[x][y] == 1) {
            distances.put(pair, distance);
            return 1;
        } else {
            return 0;
        }
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
