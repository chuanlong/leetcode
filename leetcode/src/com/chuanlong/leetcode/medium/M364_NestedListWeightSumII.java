package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.NestedInteger;

import java.util.ArrayList;
import java.util.List;

public class M364_NestedListWeightSumII {

//    public int depthSumInverse(List<NestedInteger> nestedList) {
//        maxDepth = Integer.MIN_VALUE;
//        List<NestedInteger> depths = getDepths(nestedList, 1);
//        return sum(nestedList, depths, maxDepth);
//    }
//
//    private int maxDepth;
//    private List<NestedInteger> getDepths(List<NestedInteger> nestedList, int depth) {
//        List<NestedInteger> depths = new ArrayList<>();
//        for(NestedInteger i : nestedList) {
//            if(i.isInteger()) {
//                depths.add(new NestedInteger(depth));
//                maxDepth = Math.max(maxDepth, depth);
//            } else {
//                NestedInteger d = new NestedInteger();
//                for(NestedInteger child : getDepths(i.getList(), depth+1)) {
//                    d.add(child);
//                }
//                depths.add(d);
//                maxDepth = Math.max(maxDepth, depth);
//            }
//        }
//        return depths;
//    }
//
//    private int sum(List<NestedInteger> nestedList, List<NestedInteger> depths, int max) {
//        int sum = 0;
//        for(int i=0; i<nestedList.size(); i++) {
//            NestedInteger x = nestedList.get(i), y = depths.get(i);
//            if(x.isInteger()) {
//                sum += x.getInteger() * (max-y.getInteger()+1);
//            } else {
//                sum += sum(x.getList(), y.getList(), max);
//            }
//        }
//        return sum;
//    }
}
