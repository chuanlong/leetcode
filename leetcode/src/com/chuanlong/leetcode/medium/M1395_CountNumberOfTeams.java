package com.chuanlong.leetcode.medium;

public class M1395_CountNumberOfTeams {

    public int numTeams(int[] rating) {
        int sum = 0;
        int n = rating.length;
        for(int j=1; j<n-1; j++) {
            int leftLarger = 0, leftSmaller = 0;
            for(int i=0; i<j; i++) {
                if(rating[i] < rating[j]) {
                    leftSmaller++;
                } else if (rating[i] > rating[j]) {
                    leftLarger++;
                }
            }
            int rightLarger = 0, rightSmaller = 0;
            for(int k=j+1; k<n; k++) {
                if(rating[j] < rating[k]){
                    rightLarger++;
                } else if(rating[j] > rating[k]) {
                    rightSmaller++;
                }
            }
            sum += leftSmaller*rightLarger + leftLarger*rightSmaller;
        }
        return sum;
    }
}
