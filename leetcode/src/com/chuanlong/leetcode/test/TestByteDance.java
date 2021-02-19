package com.chuanlong.leetcode.test;

public class TestByteDance {

    public static void main(String[] args) {
        TestQQ obj = new TestQQ();

        System.out.println("test byte dance!");
    }

    class Node{
        int val;
        Node next;
    }

    // 1,2,3,4,5 -> 3,2,1,4,5
    // null -> null
    // 1,2 -> 1,2
    // 1,2,3,4,5,6 -> 3,2,1,6,5,4
    public Node reverse(Node root, int k) {
        if (root == null) {
            return null;
        }
        if (k <= 1) {
            return root;
        }

        Node end = root;
        for(int i=1; i<k; i++) {
            if (end.next != null) {
                end = end.next;
            }else {
                return root;
            }
        }

        Node curStart = root, curTail = root, curSec = root.next;
        while(true) {
            if (curStart == end) {
                break;
            }

            Node newNode = curSec;
            curSec = curSec.next;
            newNode.next = curStart;
            curStart = newNode;
        }
        curTail.next = null;

        Node tail = reverse(curSec, k);
        curTail.next = tail;
        return curStart;
    }

}
