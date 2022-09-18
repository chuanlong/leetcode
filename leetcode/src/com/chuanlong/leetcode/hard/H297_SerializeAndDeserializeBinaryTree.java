package com.chuanlong.leetcode.hard;

import com.chuanlong.leetcode.bean.TreeNode;

public class H297_SerializeAndDeserializeBinaryTree {


    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            // "1(2)(3((4)(5))"
            if(root == null) return null;

            StringBuilder sb = new StringBuilder();
            sb.append(""+root.val);
            // left
            sb.append("(");
            if(root.left != null) sb.append(serialize(root.left));
            sb.append(")");

            // right
            sb.append("(");
            if(root.right != null) sb.append(serialize(root.right));
            sb.append(")");

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data==null || data.isEmpty()) return null;
            int leftStart = indexOfFirstLeft(data);
            int leftClose = indexOfLeftClose(data, leftStart);
            TreeNode root = new TreeNode(Integer.parseInt(data.substring(0, leftStart)));
            root.left = deserialize(data.substring(leftStart+1, leftClose));
            root.right = deserialize(data.substring(leftClose+2, data.length()-1));
            return root;
        }

        private int indexOfFirstLeft(String data) {
            for(int i=0; i<data.length(); i++) {
                if(data.charAt(i) == '(') return i;
            }
            return -1;
        }

        private int indexOfLeftClose(String data, int start) {
            // index at start is '('
            int cnt = 0;
            for(int i=start; i<data.length(); i++) {
                char ch = data.charAt(i);
                if(ch == '(') {
                    cnt++;
                } else if (ch == ')') {
                    cnt--;
                    if(cnt == 0) return i;
                }
            }
            return -1;
        }

    }

}
