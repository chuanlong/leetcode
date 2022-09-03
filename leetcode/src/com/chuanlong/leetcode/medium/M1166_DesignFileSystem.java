package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class M1166_DesignFileSystem {

    public static void main(String[] args) {

    }


    class FileSystem {

        private HashMap<String, Integer> paths;

        public FileSystem() {
            paths = new HashMap<>();
        }

        public boolean createPath(String path, int value) {
            // not invalid path
            if(path == null || path.isEmpty() || !path.startsWith("/") || path.length() == 1) return false;

            // check if the path is exist
            if(paths.containsKey(path)) {
               return false;
            }

            // check if the parent is empty or exist
            int lastSlashIndex = path.lastIndexOf("/");
            if(lastSlashIndex > 0) {
                String parent = path.substring(0, lastSlashIndex);
                if(!paths.containsKey(parent)) {
                    return false;
                }
            }

            paths.put(path, value);
            return true;
        }

        public int get(String path) {
            return paths.getOrDefault(path, -1);
        }
    }

    class FileSystem1 {

        private Segment root;

        public FileSystem1() {
            root = new Segment(-1, "/");
        }

        public boolean createPath(String path, int value) {
            if (path == null || path.equals("") || path.equals("/") || !path.startsWith("/")) return false;

            char[] chs = path.toCharArray();
            for(int i=0; i<chs.length; i++) {
                if(chs[i] == '/' || (chs[i]>='a' && chs[i]<='z')) {
                } else {
                    return false;
                }
            }

            String[] tokens = path.split("/");
            assert tokens.length >= 2;
            assert tokens[0].equals("");

            Segment seg = root;
            for(int i=1; i<tokens.length-1; i++) {
                Segment child = seg.findChild(tokens[i]);
                if(child == null) {
                    return false;
                }
                seg = child;
            }

            if(seg.findChild(tokens[tokens.length-1]) != null) {
                return false;
            }

            Segment newChild = new Segment(value, tokens[tokens.length-1]);
            seg.addChild(newChild);

            return true;
        }

        public int get(String path) {
            if (path == null || path.equals("") || path.equals("/") || !path.startsWith("/")) return -1;

            char[] chs = path.toCharArray();
            for(int i=0; i<chs.length; i++) {
                if(chs[i] == '/' || (chs[i]>='a' && chs[i]<='z')) {
                } else {
                    return -1;
                }
            }

            String[] tokens = path.split("/");
            assert tokens.length >= 2;
            assert tokens[0].equals("");

            Segment seg = root;
            for(int i=1; i<tokens.length; i++) {
                Segment child = seg.findChild(tokens[i]);
                if(child == null) {
                    return -1;
                }
                seg = child;
            }

            return seg.value;
        }

        class Segment {
            int value;
            String name;
            List<Segment> childs;

            public Segment(int value, String name) {
                this.value = value;
                this.name = name;
                this.childs = new ArrayList<>();
            }

            public void addChild(Segment child) {
                childs.add(child);
            }

            public Segment findChild(String name) {
                for(int i=0; i<childs.size(); i++) {
                    if(childs.get(i).name.equals(name)) {
                        return childs.get(i);
                    }
                }
                return null;
            }
        }
    }


}
