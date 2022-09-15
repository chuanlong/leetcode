package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.Node;

import java.util.Stack;

public class M1650_LowestCommonAncestorOfABinaryTreeIII {

    public Node lowestCommonAncestor(Node p, Node q) {
        Stack<Node> stack1 = new Stack();
        Stack<Node> stack2 = new Stack();
        Node node = p;
        stack1.push(node);
        while(node.parent != null) {
            node = node.parent;
            stack1.push(node);
        }
        node = q;
        stack2.push(node);
        while(node.parent != null) {
            node = node.parent;
            stack2.push(node);
        }

        assert stack1.peek() == stack2.peek();
        Node parent = stack1.pop();
        stack2.pop();
        while(!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek()) {
            parent = stack1.pop();
            stack2.pop();
        }
        return parent;
    }


}
