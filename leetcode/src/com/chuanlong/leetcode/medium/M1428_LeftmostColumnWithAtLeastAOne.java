package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class M1428_LeftmostColumnWithAtLeastAOne {

      interface BinaryMatrix {
      public int get(int row, int col);
      public List<Integer> dimensions();
  };

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int row = dim.get(0);
        int col = dim.get(1);
        List<Integer> list = new ArrayList<>();

        int startRow = 0;
        int left = 0, right = col-1;
        while(left+1 < right) {
            int mid = (left+right)/2;
            int index = findFirst1Row(binaryMatrix, startRow, row-1, mid);
            if(index == -1) {
                left = mid+1;
            } else {
                right = mid;
                startRow = index;
            }
        }
        int index1 = findFirst1Row(binaryMatrix, startRow, row-1, left);
        int index2 = findFirst1Row(binaryMatrix, startRow, row-1, right);
        if(index1 == -1 && index2 == -1) {
            return -1;
        } else if(index1 == -1) {
            return right;
        } else {
            return left;
        }
    }

    private int findFirst1Row(BinaryMatrix binaryMatrix, int startRow, int endRow, int c) {
        for(int i=startRow; i<=endRow; i++) {
            if(binaryMatrix.get(i, c) == 1) return i;
        }
        return -1;
    }

}
