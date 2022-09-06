package com.chuanlong.leetcode.medium;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

// 37:19 minutes
public class M826_MostProfitAssigningWork {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Map<Integer, Integer> jobs = new HashMap<>();
        for(int i=0; i<difficulty.length; i++) {
            int dif = difficulty[i];
            int pro = profit[i];
            if(jobs.containsKey(dif)) {
                jobs.put(dif, Math.max(jobs.get(dif), pro));
            } else {
                jobs.put(dif, pro);
            }
        }

        List<Integer> sortedJobs = jobs.keySet().stream().sorted().collect(Collectors.toList());
        int max = jobs.get(sortedJobs.get(0));
        for(int i=1; i<sortedJobs.size(); i++) {
            max = Math.max(max, jobs.get(sortedJobs.get(i)));
            jobs.put(sortedJobs.get(i), max);
        }

        int sumProfit = 0;
        for(int i=0; i<worker.length; i++) {
            int index = findNoMoreThan(sortedJobs, worker[i], 0, sortedJobs.size()-1);
            if(index != -1) {
                sumProfit += jobs.get(sortedJobs.get(index));
            }
        }

        return sumProfit;
    }

    private int findNoMoreThan(List<Integer> sortedJobs, int capability, int start, int end) {
        if(start > end) return -1;
        if(start == end) {
            if(sortedJobs.get(start) <= capability) {
                return start;
            } else {
                return -1;
            }
        }

        int mid = (start+end)/2;
        if(sortedJobs.get(mid) == capability) {
            return mid;
        } else if (sortedJobs.get(mid) > capability){
            return findNoMoreThan(sortedJobs, capability, start, mid-1);
        } else {
            if(mid == end || sortedJobs.get(mid+1) > capability) {
                return mid;
            }
            return findNoMoreThan(sortedJobs, capability, mid+1, end);
        }
    }



    public int maxProfitAssignment1(int[] difficulty, int[] profit, int[] worker) {
        Pair<Integer, Integer>[] jobs = new Pair[difficulty.length];
        for(int i=0; i<difficulty.length; i++) {
            jobs[i] = new Pair<>(difficulty[i], profit[i]);
        }

        Arrays.sort(jobs, (o1, o2) -> {
            if(o1.getKey() < o2.getKey()) {
                return -1;
            } else if (o1.getKey() > o2.getKey()) {
                return 1;
            } else {
                return o1.getValue().compareTo(o2.getValue());
            }
        });


        int maxProfit = jobs[0].getValue();
        for(int i=1; i<jobs.length; i++) {
            Pair<Integer, Integer> job = jobs[i];
            if(job.getValue() < maxProfit) {
                jobs[i] = new Pair<>(jobs[i].getKey(), maxProfit);
            }
        }

        int sumProfit = 0;
        for(int i=0; i<worker.length; i++) {
            int effort = worker[i];


        }


        return -1;
    }


}
