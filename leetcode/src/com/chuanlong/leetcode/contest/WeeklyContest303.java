package com.chuanlong.leetcode.contest;

import javafx.util.Pair;
import java.util.*;

public class WeeklyContest303 {

    public static void main(String[] args) {
        WeeklyContest303 obj = new WeeklyContest303();

        System.out.println("Test1, expect:3, output:" + obj.equalPairs(new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}}));
    }

    // 02:35, 0 error
    public char repeatedCharacter(String s) {
        int[] counts = new int[26];
        for(int i=0; i<26; i++){
            counts[i] = 0;
        }

        char[] chs = s.toCharArray();
        for(int i=0; i<chs.length; i++) {
            int key = chs[i] - 'a';
            if(counts[key] == 0) {
                counts[key] = 1;
            } else {
                return chs[i];
            }
        }
        return 'a'; // unreachable
    }

    // 11:45, 1 error WA, nit error
    public int equalPairs(int[][] grid) {
        Map<List<Integer>, Integer> rows = new HashMap<>();
        Map<List<Integer>, Integer> colums = new HashMap<>();
        int n = grid.length;
        for(int i=0; i<n; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<n; j++) {
                row.add(grid[i][j]);
            }
            int count = rows.getOrDefault(row, 0);
            rows.put(row, count+1);
        }
        for(int j=0; j<n; j++) {
            List<Integer> colum = new ArrayList<>();
            for(int i=0; i<n; i++) {
                colum.add(grid[i][j]);
            }
            int count = colums.getOrDefault(colum, 0);
            colums.put(colum, count+1);
        }

        int pairs = 0;
        for(List<Integer> rowKey : rows.keySet()) {
            for(List<Integer> columKey : colums.keySet()) {
                if(rowKey.equals(columKey)) {
                    pairs += rows.get(rowKey) * colums.get(columKey);
                }
            }
        }
        return pairs;
    }



    // WA, TLE, 1:16:58
    class FoodRatings {

        // food -> cuisine
        private Map<String, String> foodToCuisine;

        // cuisine -> set (rating, food)
        private Map<String, TreeSet<Pair<Integer, String>>> foodsMap;


        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            foodsMap = new HashMap<>();
            foodToCuisine = new HashMap<>();
            for(int i=0; i<foods.length; i++) {
                TreeSet<Pair<Integer, String>> treeSet;
                if (!foodsMap.containsKey(cuisines[i])) {
                    treeSet = new TreeSet<>((o1, o2) -> {
                        if(o1.getKey().equals(o2.getKey())) {
                            // lexicographically order
                            return o1.getValue().compareTo(o2.getValue());
                        } else {
                            // descending order
                            return 0 - o1.getKey().compareTo(o2.getKey());
                        }
                    });
                    foodsMap.put(cuisines[i], treeSet);
                } else {
                    treeSet = foodsMap.get(cuisines[i]);
                }
                treeSet.add(new Pair<>(ratings[i], foods[i]));
                foodToCuisine.put(foods[i], cuisines[i]);
            }
        }

        public void changeRating(String food, int newRating) {
            String cuisine = foodToCuisine.get(food);
            if(cuisine == null) return;
            TreeSet<Pair<Integer, String>> treeSet = foodsMap.get(cuisine);
            if(treeSet == null || treeSet.size() == 0) return;

            Pair<Integer, String> thePair = null;
            for (Iterator<Pair<Integer, String>> it = treeSet.iterator(); it.hasNext(); ) {
                Pair pair = it.next();
                if(pair.getValue().equals(food)) {
                    thePair = pair;
                    break;
                }
            }

            treeSet.remove(thePair);
            treeSet.add(new Pair<>(newRating, food));
        }

        public String highestRated(String cuisine) {
            TreeSet<Pair<Integer, String>> list = foodsMap.get(cuisine);
            if(list != null && list.size() > 0) {
                return list.first().getValue();
            }
            return null;
        }
    }



}
