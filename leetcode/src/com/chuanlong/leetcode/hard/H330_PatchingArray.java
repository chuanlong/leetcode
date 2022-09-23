package com.chuanlong.leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class H330_PatchingArray {

    public int minPatches(int[] nums, int n) {
        int i = 0;
        int patches = 0;
        long miss = 1;
        while(miss<=n) {
            if(i<nums.length && nums[i]<=miss) {
                miss = miss + nums[i];
                i++;
            } else {
                miss = miss + miss;
                patches++;
            }
        }
        return patches;
    }


    // TLE
    public int minPatches1(int[] nums, int n) {
        min = Integer.MAX_VALUE;
        patch = 0;
        done = new TreeSet<>((a,b)->a-b);
        patches = new ArrayList<>();
        init1(nums, n);
        backtrack1(0, n);
        return min;
    }

    int min = Integer.MAX_VALUE;
    int patch = 0;
    TreeSet<Integer> done = new TreeSet<>((a, b)->a-b); // increase order
    List<Integer> patches = new ArrayList<>();

    private void backtrack1(int index, int n) {
        int min1 = min;
        int patch1 = patch;
        TreeSet<Integer> done1 = done;
        List<Integer> patches1 = patches;

        if(done.size() == n) {
            min = Math.min(min, patch);
            return;
        }
        if(patch>=min) return;
        if(index>=patches.size()) return;

        // ignore index
        backtrack1(index+1, n);

        // add index num to done
        patch++;
        TreeSet<Integer> doneCopy = (TreeSet<Integer>) done.clone();
        int num = patches.get(index);
        for(int d : doneCopy) {
            if(d+num<=n) {
                done.add(d+num);
            } else {
                break;
            }
        }
        if(num<=n) done.add(num);
        backtrack1(index+1, n);
        patch--;
        done = doneCopy;
    }

    private void init1(int[] nums, int n) {
        TreeMap<Integer, Boolean> map = new TreeMap<>();
        for(int i=1; i<=n; i++) map.put(i, true);
        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            TreeSet<Integer> doneCopy = (TreeSet<Integer>) done.clone();
            for(int d : doneCopy) {
                if(d+num<=n) {
                    done.add(d+num);
                } else {
                    break;
                }
            }
            if(num<=n) done.add(num);
            if(num<=n) map.remove(num);
        }
        patches.addAll(map.keySet());
    }
}
