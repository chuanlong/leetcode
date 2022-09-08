package com.chuanlong.leetcode.contest;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeeklyContest305 {

    public static void main(String[] args) {
        WeeklyContest305 obj = new WeeklyContest305();

        System.out.println("Test1, expect:2, output:" + obj.arithmeticTriplets(new int[]{4,5,6,7,8,9}, 2));
        System.out.println("Test2, expect:4, output:" + obj.reachableNodes(7, new int[][]{{0,1}, {1,2}, {3,1}, {4,0}, {0,5}, {5,6}}, new int[]{4,5}));


        System.out.println("Test3, expect:true, output:" + obj.validPartition(new int[]{4,4,4,5,6}));
        System.out.println("Test4, expect:false, output:" + obj.validPartition(new int[]{1,1,1,2}));

        System.out.println("Test5, expect:4, output:" + obj.longestIdealString("acfgbd", 2));
        System.out.println("Test6, expect:4, output:" + obj.longestIdealString("abcd", 3));
    }

    // 10:02
    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;

        for(int j=1; j<nums.length-1; j++) {
            for(int i=j-1, k=j+1; i>=0 && k<nums.length; ) {
                int diff1 = nums[j]-nums[i];
                int diff2 = nums[k]-nums[j];
                if(diff1 > diff || diff2 > diff) break;
                if(diff1 == diff && diff2 == diff) {
                    count++;
                    i--;
                    k++;
                } else if(diff1 < diff2) {
                    i--;
                } else {
                    // diff1 > diff2
                    k++;
                }
            }
        }
        return count;
    }


    // 28:15, 1 error
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<edges.length; i++) {
            List<Integer> x = map.getOrDefault(edges[i][0], new ArrayList<>());
            x.add(edges[i][1]);
            if(!map.containsKey(edges[i][0])) map.put(edges[i][0], x);

            List<Integer> y = map.getOrDefault(edges[i][1], new ArrayList<>());
            y.add(edges[i][0]);
            if(!map.containsKey(edges[i][1])) map.put(edges[i][1], y);
        }

        Map<Integer, Boolean> reachable = new HashMap();
        Map<Integer, Boolean> unScan = new HashMap<>();
        Map<Integer, Boolean> restrict = new HashMap<>();
        for(int i=0; i<restricted.length; i++) {
            restrict.put(restricted[i], true);
        }

        unScan.put(0, true);
        while(!unScan.isEmpty()) {
            int k = unScan.keySet().iterator().next();
            unScan.remove(k);
            reachable.put(k, true);

            List<Integer> newUnScan = map.getOrDefault(k, new ArrayList<>());
            for(int i=0; i<newUnScan.size(); i++) {
                int j = newUnScan.get(i);
                if(!reachable.containsKey(j) && !restrict.containsKey(j) && !unScan.containsKey(j)) {
                    unScan.put(j, true);
                }
            }
        }
        return reachable.keySet().size();
    }


    public boolean validPartition(int[] nums) {
        return validPartition(nums, 0, nums.length-1, new HashMap<Pair, Boolean>());
    }

    private boolean validPartition(int[] nums, int i, int j, Map<Pair, Boolean> map) {
        Pair point = new Pair(i,j);
        if(map.containsKey(point)) return map.get(point);

        if(j-i < 1) {
            return false;
        } else if (j-i == 1) {
            if(nums[i] == nums[j]) {
                return true;
            } else {
                return false;
            }
        } else if (j-i == 2) {
            if(nums[i] == nums[i+1] && nums[i+1] == nums[j]) {
                return true;
            } else if (nums[i+1]-nums[i] == 1 && nums[j] - nums[i+1] == 1) {
                return true;
            } else {
                return false;
            }
        } else {
            if(nums[i] == nums[i+1]) {
                if(validPartition(nums, i+2, j, map)) {
                    map.put(point, true);
                    return true;
                }
            }
            if((nums[i] == nums[i+1] && nums[i+1] == nums[i+2])
                    || (nums[i+1]-nums[i]==1 && nums[i+2]-nums[i+1]==1)) {
                if(validPartition(nums, i+3, j, map)) {
                    map.put(point, true);
                    return true;
                }
            }

            map.put(point, false);
            return false;
        }
    }


    // 29:12, 0 error
    public int longestIdealString(String s, int k) {
        int[] longest = new int[26];
        for(int i=0; i<26; i++) {
            longest[i] = 0;
        }

        char[] chs = s.toCharArray();
        for(int i=0; i<chs.length; i++) {
            char ch = chs[i];
            int longestCh = longest[ch - 'a'];
            for(int j=0; j<26; j++) {
                char chx = ((char)('a'+j));
                int distance = Math.abs(chx - ch);
                if(distance != 0 && distance<=k) {
                    longestCh = Math.max(longestCh, longest[j]);
                }
            }
            longest[ch-'a'] = longestCh+1;
        }

        int max = 0;
        for(int i=0; i<26; i++) {
            max = Math.max(longest[i], max);
        }
        return max;
    }

}
