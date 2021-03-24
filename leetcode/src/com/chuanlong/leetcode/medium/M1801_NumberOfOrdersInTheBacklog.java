package com.chuanlong.leetcode.medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class M1801_NumberOfOrdersInTheBacklog {

    public static void main(String[] args) {}

    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<Integer> sellPQ = new PriorityQueue<>();
        HashMap<Integer, Integer> sellMap = new HashMap<>();
        PriorityQueue<Integer> buyPQ = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> buyMap = new HashMap<>();

        for(int i=0; i<orders.length; i++) {
            processOrder(orders[i][0], orders[i][1], orders[i][2], sellPQ, sellMap, buyPQ, buyMap);
        }

        long orderAmount = 0;
        for(Integer i : buyMap.values()) {
            orderAmount += i;
        }
        for(Integer i: sellMap.values()) {
            orderAmount += i;
        }
        return (int)(orderAmount % (1000000000+7));
    }

    private void processOrder(int price, int amount, int orderType,
                              PriorityQueue<Integer> sellPQ,
                              HashMap<Integer, Integer> sellMap,
                              PriorityQueue<Integer> buyPQ,
                              HashMap<Integer, Integer> buyMap) {
        if (orderType == 0) {
            // handle buy order
            Integer sellPrice = sellPQ.peek();
            if (sellPrice != null && sellPrice <= price) {
                // find the matched sell order
                Integer sellAmount = sellMap.get(sellPrice);
                if (sellAmount == amount) {
                    // sell amount equal buy amount
                    sellPQ.poll();
                    sellMap.remove(sellPrice);
                } else if (sellAmount > amount) {
                    // sell amount > buy amount
                    sellMap.put(sellPrice, sellAmount-amount);
                } else {
                    // sell amount < buy amount
                    sellPQ.poll();
                    sellMap.remove(sellPrice);
                    processOrder(price, amount-sellAmount, 0, sellPQ, sellMap, buyPQ, buyMap);
                }
            } else {
                // queue buy order
                addOrders(price, amount, buyPQ, buyMap);
            }
        } else {
            // handle sell order
            Integer buyPrice = buyPQ.peek();
            if (buyPrice != null && buyPrice >= price) {
                Integer buyAmount = buyMap.get(buyPrice);
                if (buyAmount == amount) {
                    buyPQ.poll();
                    buyMap.remove(buyPrice);
                } else if (buyAmount > amount) {
                    buyMap.put(buyPrice, buyAmount-amount);
                } else {
                    buyPQ.poll();
                    buyMap.remove(buyPrice);
                    processOrder(price, amount-buyAmount, 1, sellPQ, sellMap, buyPQ, buyMap);
                }
            } else {
                // queue sell order
                addOrders(price, amount, sellPQ, sellMap);
            }
        }
    }


    private void addOrders(int price, int amount, PriorityQueue<Integer> pq, Map<Integer, Integer> map) {
        if (map.containsKey(price)) {
            map.put(price, map.get(price) + amount);
        } else {
            map.put(price, amount);
            pq.add(price);
        }
    }

}
