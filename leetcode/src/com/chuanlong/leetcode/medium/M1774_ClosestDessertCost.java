package com.chuanlong.leetcode.medium;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

// 39:42 minutes, 1 error
public class M1774_ClosestDessertCost {

    public static void main(String[] args) {
        M1774_ClosestDessertCost obj = new M1774_ClosestDessertCost();

        System.out.println("Test1, expect:17, result:" + obj.closestCost(new int[]{2, 3}, new int[]{4, 5, 100}, 18));
    }

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        Arrays.sort(baseCosts);
        Arrays.sort(toppingCosts);

        int closestCost = -1;
        for(int i=0; i<baseCosts.length; i++) {
            int cost = closestCost(baseCosts[i], toppingCosts, target);
            if(cost == target) return cost;
            if(closestCost == -1) {
                closestCost = cost;
            } else {
                int distance1 = Math.abs(closestCost-target);
                int distance2 = Math.abs(cost-target);
                if(distance1 == distance2) {
                    closestCost = Math.min(closestCost, cost);
                } else if (distance1 < distance2) {
                    // do nothing
                } else {
                    closestCost = cost;
                }
            }
        }
        return closestCost;
    }

    public int closestCost(int base, int[] toppingCosts, int target) {
        int topping = target - base;
        if(topping <= 0) {
            return base;
        }

        int cost = closestCost(toppingCosts, 0, 0, topping, new AtomicBoolean(false));
        return cost+base;
    }

    public int closestCost(int[] toppingCosts, int index, int cost, int target, AtomicBoolean found) {
        if(found.get()) return target;
        if(index == toppingCosts.length) {
            if(target == cost) found.set(true);
            return cost;
        }

        int[] costs = new int[3];
        for(int i=0; i<3; i++) {
            costs[i] = closestCost(toppingCosts, index+1, cost+toppingCosts[index]*i, target, found);
        }
        Arrays.sort(costs);

        if(target <= (costs[0]+costs[1])/2) {
            return costs[0];
        } else if (target <= (costs[1]+costs[2])/2) {
            return costs[1];
        } else {
            return costs[2];
        }
    }


}
