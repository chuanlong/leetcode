package com.chuanlong.leetcode.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class H460_LFUCache {

    public static void main(String[] args) {

        // Test1
        LFUCache cache = new LFUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        int get1 = cache.get(1);  // 1
        cache.put(3,3);
        int get2 = cache.get(2);  // -1
        int get3 = cache.get(3);  // 3
        cache.put(4,4);
        int get11 = cache.get(1);  // -1
        int get33 = cache.get(3);  // 3
        int get4 = cache.get(4);  // 4
    }


    static class LFUCache {

        class LRUCache {
            DoubleLinkedListNode dummy, tail; // head
            int size;

            public LRUCache() {
                dummy = new DoubleLinkedListNode(0, 0);
                tail = new DoubleLinkedListNode(0, 0);
                dummy.next = tail;
                tail.prev = dummy;
                size = 0;
            }

            public void add(DoubleLinkedListNode node) {
                // add to the head
                DoubleLinkedListNode next = dummy.next;
                dummy.next = node;
                node.next = next;
                next.prev = node;
                node.prev = dummy;
                size++;
            }

            public DoubleLinkedListNode remove() {
                // remove the tail
                return remove(tail.prev);
            }

            public DoubleLinkedListNode remove(DoubleLinkedListNode node) {
                DoubleLinkedListNode prev = node.prev;
                DoubleLinkedListNode next = node.next;
                node.prev = null;
                node.next = null;
                prev.next = next;
                next.prev = prev;
                size--;
                return node;
            }

            public int size() {
                return size;
            }

        }

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

        Map<Integer, DoubleLinkedListNode> map1;  // key, Node
        TreeMap<Integer, LRUCache> map2;  // count, Cache
        int count;
        int capacity;


        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.count = 0;
            this.map1 = new HashMap<>();
            this.map2 = new TreeMap<>();
        }

        public int get(int key) {
            if(capacity == 0) return -1;
            if(!map1.containsKey(key)) return -1;
            DoubleLinkedListNode node = map1.get(key);
            increaseUseCount(node);
            return node.value;
        }

        public void put(int key, int value) {
            if(capacity == 0) return;
            if(map1.containsKey(key)) {
                DoubleLinkedListNode node = map1.get(key);
                node.value = value;
                increaseUseCount(node);
            } else {
                if(count == capacity) {
                    // remove
                    int removedKey = map2.firstKey();
                    LRUCache removedCache = map2.get(removedKey);
                    DoubleLinkedListNode removedNode = removedCache.remove();
                    if(removedCache.size() == 0) map2.remove(removedKey);
                    map1.remove(removedNode.key);
                    count--;
                }
                DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
                if(!map2.containsKey(1)) map2.put(1, new LRUCache());
                map2.get(1).add(node);
                map1.put(key, node);
                count++;
            }

        }

        private void increaseUseCount(DoubleLinkedListNode node) {
            map2.get(node.count).remove(node);
            if(map2.get(node.count).size() == 0) map2.remove(node.count);
            if(!map2.containsKey(node.count+1)) map2.put(node.count+1, new LRUCache());
            map2.get(node.count+1).add(node);
            node.count++;
        }



    }




    // TLE
    class LFUCache2 {

        class DoubleLinkedListNode2 {
            public int key;
            public int value;
            public int count;
            public DoubleLinkedListNode2 prev;
            public DoubleLinkedListNode2 next;
            public DoubleLinkedListNode2(int key, int value) {
                this.key = key;
                this.value = value;
                this.count = 1;
                prev = null;
                next = null;
            }
        }

        DoubleLinkedListNode2 dummy; // head
        Map<Integer, DoubleLinkedListNode2> map;
        int count;
        int capacity;


        public LFUCache2(int capacity) {
            this.capacity = capacity;
            this.count = 0;
            this.dummy = new DoubleLinkedListNode2(0, 0);
            this.dummy.next = new DoubleLinkedListNode2(Integer.MAX_VALUE, Integer.MAX_VALUE);
            this.dummy.next.count = Integer.MAX_VALUE;
            this.dummy.next.prev = dummy;
            this.map = new HashMap<>();
        }

        public int get(int key) {
            if(capacity == 0) return -1;
            if(!map.containsKey(key)) return -1;
            DoubleLinkedListNode2 node = map.get(key);
            node.count++;
            moveDoubleLinkedListNode(node);
            return node.value;
        }

        public void put(int key, int value) {
            if(capacity == 0) return;
            DoubleLinkedListNode2 node;
            if(!map.containsKey(key)) {
                if(count == capacity) {
                    DoubleLinkedListNode2 removed = dummy.next;
                    map.remove(removed.key);
                    dummy.next = dummy.next.next;
                    dummy.next.prev = dummy;
                    count = capacity;
                    count--;
                }
                node = new DoubleLinkedListNode2(key, value);
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

        private void moveDoubleLinkedListNode(DoubleLinkedListNode2 node) {
            while(node.next != null && node.count >= node.next.count) {
                // exchange node and node.next
                DoubleLinkedListNode2 node2 = node.next;
                DoubleLinkedListNode2 prev = node.prev;
                DoubleLinkedListNode2 next = node.next.next;
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
