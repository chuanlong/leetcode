package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.Node;

public class M1522_DiameterOfNAryTree {

    public int diameter(Node root) {
        int[] result = recursion(root);
        return result[0]-1;
    }

    // [diameter, path]
    private int[] recursion(Node node) {
        if(node == null) return new int[]{0, 0};
        int[] max2 = new int[]{0, 0};
        int diameter = 0;
        for(Node no : node.children) {
            if(no != null) {
                int[] sub = recursion(no);
                diameter = Math.max(diameter, sub[0]);
                check(max2, sub[1]);
            }
        }
        int path = max2[1]+1;
        diameter = Math.max(diameter, (max2[0]+max2[1])+1);
        return new int[]{diameter, path};
    }

    private void check(int[] max2, int val) {
        if(val<=max2[0]) return;
        max2[0] = val;
        if(max2[1] < max2[0]) {
            int tmp = max2[1];
            max2[1] = max2[0];
            max2[0] = tmp;
        }
    }

}
