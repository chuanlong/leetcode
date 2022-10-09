package com.chuanlong.leetcode.contest;

import java.util.*;

public class WeeklyContest314 {

    public static void main(String[] args) {
        WeeklyContest314 obj = new WeeklyContest314();

//        System.out.println("Test3-1, expect:azz, output:" + obj.robotWithString("zza"));
//        System.out.println("Test3-2, expect:abc, output:" + obj.robotWithString("bac"));
//        System.out.println("Test3-3, expect:addb, output:" + obj.robotWithString("bdda"));
//        System.out.println("Test3-3, expect:bdevfziy, output:" + obj.robotWithString("bydizfve"));


        System.out.println("Test4-1, expect:2, output:" + obj.numberOfPaths(new int[][]{{5,2,4},{3,0,5},{0,7,2}}, 3));
    }

    // Q1
    public int hardestWorker(int n, int[][] logs) {
        int id = 0;
        int longest = Integer.MIN_VALUE;
        int start = 0;
        for(int i=0; i<logs.length; i++) {
            int duration = logs[i][1] - start;
            if(duration > longest || (duration==longest && logs[i][0]<id)) {
                longest = duration;
                id = logs[i][0];
            }
            start = logs[i][1];
        }
        return id;
    }

    // Q2
    public int[] findArray(int[] pref) {
        int[] arr = new int[pref.length];
        arr[0] = pref[0];
        for(int i=1; i<pref.length; i++) {
            arr[i] = pref[i-1] ^ pref[i];
        }
        return arr;
    }

    // Q3
    public String robotWithString(String s) {
        if(s.isEmpty()) return "";
        char[] chs = s.toCharArray();
        // <a, [index]>
        TreeMap<Character, TreeSet<Integer>> map = new TreeMap<>();
        for(int i=0; i<s.length(); i++) {
            if(!map.containsKey(chs[i])) map.put(chs[i], new TreeSet<>());
            map.get(chs[i]).add(i);
        }

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while(!stack.isEmpty() || index<chs.length) {
            if(index==chs.length) {
                sb.append(stack.pop());
                continue;
            }
            TreeSet<Integer> set = getLexicographicallySmaller(map, (stack.isEmpty()) ? ((char)('z'+1)) : stack.peek());
            if(set != null) {
                int first = set.first();
                for(int i=index; i<=first; i++) {
                    stack.push(chs[i]);
                    map.get(chs[i]).remove(i);
                    if(map.get(chs[i]).size() == 0) map.remove(chs[i]);
                }
                index = first+1;
            } else {
                sb.append(stack.pop());
            }
        }
        return sb.toString();
    }

    private TreeSet<Integer> getLexicographicallySmaller(TreeMap<Character, TreeSet<Integer>> map, char ch) {
        for(int i=0; i<(ch-'a'); i++) {
            if(map.containsKey((char)('a'+i))) return map.get((char)('a'+i));
        }
        return null;
    }



    // Q4
    final int MOD = 1000000007;
    public int numberOfPaths(int[][] grid, int k) {
        int m=grid.length, n=grid[0].length;
        int[][][] mem = new int[m+1][n+1][k];
        mem[1][1][grid[0][0]%k] = 1;
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(!(i==1&&j==1)) sum(mem[i-1][j], mem[i][j-1], mem[i][j], grid[i-1][j-1], k);
            }
        }
        return mem[m][n][0];
    }

    private void sum(int[] x1, int[] x2, int[] sum, int value, int k) {
        for(int i=0; i<k; i++) {
            sum[(i+value)%k] = ((x1[i]+x2[i])%MOD);
        }
    }

}
