package com.chuanlong.leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class M1792_MaximumAveragePassRatio {

    public double maxAverageRatio2(int[][] classes, int extraStudents) {

        for(int j=0; j<extraStudents; j++) {
            int maxIndex = -1;
            double maxImprove = 0;
            for(int i=0; i<classes.length; i++) {
                double improve = (((double)classes[i][0]+1)/((double)classes[i][1]+1)) - ((double)classes[i][0]/(double)classes[i][1]);
                if (improve > maxImprove) {
                    maxIndex = i;
                    maxImprove = improve;
                }
            }
            classes[maxIndex][0] = classes[maxIndex][0] +1;
            classes[maxIndex][1] = classes[maxIndex][1] +1;
        }

        double sumPassRatio = 0;
        for(int i=0; i<classes.length; i++){
            sumPassRatio += ((double)classes[i][0])/((double)classes[i][1]);
        }
        return sumPassRatio/classes.length;
    }


    public double maxAverageRatio3(int[][] classes, int extraStudents) {
        int n = classes.length;
        double[] improve = new double[n];
        for(int i=0; i<n; i++) {
            improve[i] = (((double)classes[i][0]+1)/((double)classes[i][1]+1)) - ((double)classes[i][0]/(double)classes[i][1]);
        }

        for(int i=0; i<extraStudents; i++) {
            int maxIndex = max(improve);
            classes[maxIndex][0] = classes[maxIndex][0]+1;
            classes[maxIndex][1] = classes[maxIndex][1]+1;
            improve[maxIndex] = (((double)classes[maxIndex][0]+1)/((double)classes[maxIndex][1]+1)) - ((double)classes[maxIndex][0]/(double)classes[maxIndex][1]);
        }

        double sumPassRatio = 0;
        for(int i=0; i<n; i++){
            sumPassRatio += ((double)classes[i][0])/((double)classes[i][1]);
        }
        return sumPassRatio/n;
    }

    private int max(double[] improve) {
        int index = -1;
        double max = 0;
        for(int i=0; i<improve.length; i++) {
            if (improve[i] > max) {
                index = i;
                max = improve[i];
            }
        }
        return index;
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        PriorityQueue<Node2> priorityQueue = new PriorityQueue<Node2>(Comparator.reverseOrder());
        for(int i=0; i<n; i++) {
            priorityQueue.add(new Node2(i, ratioDiff(classes, i)));
        }
        for(int i=0; i<extraStudents; i++) {
            Node2 node = priorityQueue.poll();
            classes[node.key][0] = classes[node.key][0]+1;
            classes[node.key][1] = classes[node.key][1]+1;
            priorityQueue.add(new Node2(node.key, ratioDiff(classes, node.key)));
        }
        double sumPassRatio = 0;
        for(int i=0; i<n; i++){
            sumPassRatio += ((double)classes[i][0])/((double)classes[i][1]);
        }
        return sumPassRatio/n;
    }

    private double ratioDiff(int[][] classes, int i) {
        return (((double)(classes[i][0]+1))/((double)(classes[i][1]+1))) - (((double)classes[i][0])/((double)classes[i][1]));
    }

    class Node2 implements Comparable{
        int key;
        double val;
        public Node2(int key, double val) {
            this.key = key;
            this.val = val;
        }
        @Override
        public int compareTo(Object o) {
            return Double.compare(val, ((Node2) o).val);
        }
    }

}
