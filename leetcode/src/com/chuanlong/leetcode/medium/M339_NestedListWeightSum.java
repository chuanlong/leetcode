package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.NestedInteger;

import java.util.List;

public class M339_NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for(NestedInteger n : nestedList) {
            if(n.isInteger()) {
                sum += n.getInteger() * depth;
            } else {
                sum += dfs(n.getList(), depth+1);
            }
        }
        return sum;
    }
}
