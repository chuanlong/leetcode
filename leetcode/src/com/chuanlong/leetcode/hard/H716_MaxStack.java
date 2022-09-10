package com.chuanlong.leetcode.hard;

import javafx.util.Pair;

import java.util.*;

public class H716_MaxStack {


    class MaxStack {

        DoubleLinkedList dll;
        TreeMap<Integer, List<Node>> map;

        public MaxStack() {
            dll = new DoubleLinkedList();
            map = new TreeMap<>();
        }

        public void push(int x) {
            Node node = dll.addNode(x);
            if(!map.containsKey(x)) {
                map.put(x, new ArrayList<>());
            }
            List<Node> set = map.get(x);
            set.add(node);
        }

        public int pop() {
            Node node = dll.removeTail();
            List<Node> set = map.get(node.value);
            set.remove(node);
            if(set.size() == 0) map.remove(node.value);
            return node.value;
        }

        public int top() {
            return dll.tail.value;
        }

        public int peekMax() {
            return map.lastKey();
        }

        public int popMax() {
            int x = peekMax();
            List<Node> set = map.get(x);
            Node node = set.remove(set.size()-1);
            if(set.size() == 0) map.remove(x);
            dll.breakLink(node);
            return x;
        }

        class Node {
            Node prev, next;
            int value;
            public Node(Node prev, Node next, int value){
                this.prev = prev;
                this.next = next;
                this.value = value;
            }
        }

        class DoubleLinkedList {
            private Node head, tail;
            public DoubleLinkedList() {
                head = tail = new Node(null, null, -1);
            }

            public Node addNode(int value) {
                Node newNode = new Node(tail, null, value);
                tail.next = newNode;
                tail = newNode;
                return newNode;
            }

            public Node removeTail() {
                Node oldNode = tail;
                tail = tail.prev;
                tail.next = null;
                return oldNode;
            }

            public void breakLink(Node node) {
                if(node == tail) {
                    removeTail();
                } else {
                    Node prev = node.prev;
                    Node next = node.next;
                    prev.next = next;
                    next.prev = prev;
                }
            }
        }
    }


    // TLE
    class MaxStack1 {
        List<Integer> stack;
        List<Integer> max;
        int size;

        public MaxStack1() {
            stack = new ArrayList<>();
            max = new ArrayList<>();
            size = 0;
        }

        public void push(int x) {
            if(size == 0 || stack.get(max.get(size-1)) <= x) {
                max.add(size, size);
            } else {
                max.add(size, max.get(size-1));
            }
            stack.add(size, x);
            size++;
        }

        public int pop() {
            int x = stack.get(--size);
            stack.remove(size);
            max.remove(size);
            return x;
        }

        public int top() {
            return stack.get(size-1);
        }

        public int peekMax() {
            return stack.get(max.get(size-1));
        }

        public int popMax() {
            int index = max.get(size-1);
            int x = stack.get(index);
            for(int i=index; i<size-1; i++) {
                stack.set(i, stack.get(i+1));
            }
            for(int i=index; i<size-1; i++) {
                if(i==0 || stack.get(max.get(i-1)) <= stack.get(i)) {
                    max.add(i, i);
                } else {
                    max.add(i, max.get(i-1));
                }
            }
            size--;
            return x;
        }
    }


}
