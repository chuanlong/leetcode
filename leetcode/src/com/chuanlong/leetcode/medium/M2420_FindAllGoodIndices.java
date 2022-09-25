package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M2420_FindAllGoodIndices {

    public static void main(String[] args) {
        M2420_FindAllGoodIndices obj = new M2420_FindAllGoodIndices();

        System.out.println("Test1, expect:[2,3], output:" + obj.goodIndices(new int[]{2,1,1,1,3,4,1}, 2));
        System.out.println("Test2, expect:[], output:" +obj.goodIndices(new int[]{2,1,1,2}, 2));
        System.out.println("Test3, expect:[1], output:" +obj.goodIndices(new int[]{440043, 276285, 336957}, 1));
    }

    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> goods = new ArrayList<>();
        int n = nums.length;
        if(k==1) {
            for(int i=k; i<n-k; i++) goods.add(i);
        } else {
            int i=0, j=1, p=0, q=0;
            while(i<n-k) {
                if(j<i+1)j=i+1;
                while(j<n && nums[j]<=nums[j-1] && j-i+1<k) j++;
                if(j<n && nums[j]<=nums[j-1] && j-i+1==k) {
                    p = j+2;
                    if(q<p+1) q=p+1;
                    while(q<n && nums[q]>=nums[q-1] && q-p+1<k) q++;
                    if (q<n && nums[q]>=nums[q-1] && q-p+1==k) {
                        goods.add(j+1);
                    }
                    i++;
                } else {
                    i=j;
                }
            }
        }
        return goods;
    }
}
