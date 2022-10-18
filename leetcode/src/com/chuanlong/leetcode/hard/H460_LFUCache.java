package com.chuanlong.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class H460_LFUCache {

    class LFUCache {

        class DoubleLinkedListNode {
            public int key;
            public int value;
            public int count;
            public DoubleLinkedListNode prev;
            public DoubleLinkedListNode next;
            public DoubleLinkedListNode(int key, int value) {
                this.key = key;
                this.value = value;
                this.count = 1;
                prev = null;
                next = null;
            }
        }

        DoubleLinkedListNode dummy; // head
        Map<Integer, DoubleLinkedListNode> map;
        int count;
        int capacity;


        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.count = 0;
            this.dummy = new DoubleLinkedListNode(0, 0);
            this.dummy.next = new DoubleLinkedListNode(Integer.MAX_VALUE, Integer.MAX_VALUE);
            this.dummy.next.count = Integer.MAX_VALUE;
            this.dummy.next.prev = dummy;
            this.map = new HashMap<>();
        }

        public int get(int key) {
            if(capacity == 0) return -1;
            if(!map.containsKey(key)) return -1;
            DoubleLinkedListNode node = map.get(key);
            node.count++;
            moveDoubleLinkedListNode(node);
            return node.value;
        }

        public void put(int key, int value) {
            if(capacity == 0) return;
            DoubleLinkedListNode node;
            if(!map.containsKey(key)) {
                if(count == capacity) {
                    DoubleLinkedListNode removed = dummy.next;
                    map.remove(removed.key);
                    dummy.next = dummy.next.next;
                    dummy.next.prev = dummy;
                    count = capacity;
                    count--;
                }
                node = new DoubleLinkedListNode(key, value);
                node.prev = dummy;
                node.next = dummy.next;
                dummy.next = node;
                node.next.prev = node;
                map.put(key, node);
                count++;
            } else {
                node = map.get(key);
                node.count++;
                node.value = value;
            }
            moveDoubleLinkedListNode(node);
        }

        private void moveDoubleLinkedListNode(DoubleLinkedListNode node) {
            while(node.next != null && node.count >= node.next.count) {
                // exchange node and node.next
                DoubleLinkedListNode node2 = node.next;
                DoubleLinkedListNode prev = node.prev;
                DoubleLinkedListNode next = node.next.next;
                prev.next = node2;
                node2.next = node;
                node.next = next;
                next.prev = node;
                node.prev = node2;
                node2.prev = prev;
            }
        }

    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
