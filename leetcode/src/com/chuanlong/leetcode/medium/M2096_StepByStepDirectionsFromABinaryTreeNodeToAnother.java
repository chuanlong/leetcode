package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class M2096_StepByStepDirectionsFromABinaryTreeNodeToAnother {

    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<TreeNode> path1 = getPath(root, startValue);
        List<TreeNode> path2 = getPath(root, destValue);

        int index = 0;
        for(int i=1; i<path1.size() && i<path2.size(); i++) {
            if(path1.get(i) == path2.get(i)) {
                index = i;
            } else {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=index+1; i<path1.size(); i++) {
            sb.append("U");
        }

        for(int i=index; i+1<path2.size(); i++) {
            if(path2.get(i).left == path2.get(i+1)) {
                sb.append("L");
            } else {
                sb.append("R");
            }
        }

        return sb.toString();
    }

    private List<TreeNode> getPath(TreeNode node, int value) {
        if(node == null) return null;
        if(node.val == value) {
            List<TreeNode> l = new ArrayList<>();
            l.add(node);
            return l;
        }

        List<TreeNode> subPath = getPath(node.left, value);
        if(subPath == null) subPath = getPath(node.right, value);
        if(subPath == null) return null;
        subPath.add(0, node);
        return subPath;
    }

    public String getDirections2(TreeNode root, int startValue, int destValue) {
        List<TreeNode> path1 = findPath2(root, startValue);
        List<TreeNode> path2 = findPath2(root, destValue);

        int index=0;
        for(int i=1; i<path1.size() && i<path2.size(); i++) {
            if(!path1.get(i).equals(path2.get(i))) {
                break;
            } else {
                index = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=index+1; i<path1.size(); i++) {
            sb.append("U");
        }

        for(int i=index; i+1<path2.size(); i++) {
            if(path2.get(i).left == path2.get(i+1)) {
                sb.append("L");
            } else {
                sb.append("R");
            }
        }

        return sb.toString();
    }

    private List<TreeNode> findPath2(TreeNode node, int value) {
        if(node == null) return null;
        if(node.val == value) {
            List<TreeNode> result = new ArrayList();
            result.add(node);
            return result;
        }

        List<TreeNode> path = null;
        path = findPath2(node.left, value);
        if(path != null) {
            path.add(0, node);
            return path;
        }
        path = findPath2(node.right, value);
        if(path != null) {
            path.add(0, node);
            return path;
        }
        return null;
    }

}
