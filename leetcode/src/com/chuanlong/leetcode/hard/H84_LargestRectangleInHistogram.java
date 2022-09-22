package com.chuanlong.leetcode.hard;

public class H84_LargestRectangleInHistogram {


    public int largestRectangleArea(int[] heights) {
        return largest(heights, 0, heights.length-1);
    }

    private int largest(int[] heights, int s, int e) {
        if(s>e) return 0;
        if(s==e) return heights[s]*1;

        int min = heights[s];
        int midStart = s;
        int midEnd = s;
        boolean flag = true;
        for(int i=s+1; i<=e; i++) {
            if(heights[i] < min) {
                min = heights[i];
                midStart = i;
                midEnd = i;
                flag = true;
            } else if (flag && heights[i] == min) {
                midEnd = i;
            } else if(heights[i]>min) {
                flag = false;
            }
        }

        int max = min*(e-s+1);
        max = Math.max(max, largest(heights, s, midStart-1));
        max = Math.max(max, largest(heights, midEnd+1, e));
        return max;
    }



    class MyPoint {
        int a; // max before index
        int b; // max before index

        int c; // max contain index -> length
        int d; // max contain index -> height

        public MyPoint(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }

    // TLE
    public int largestRectangleArea1(int[] heights) {
        int n = heights.length;

        MyPoint[] dp = new MyPoint[n];
        dp[0] = new MyPoint(0, 0, 1, heights[0]);

        for(int i=1; i<n; i++) {
            int a, b;
            if(dp[i-1].a * dp[i-1].b >= dp[i-1].c * dp[i-1].d) {
                a = dp[i-1].a;
                b = dp[i-1].b;
            } else {
                a = dp[i-1].c;
                b = dp[i-1].d;
            }

            int c = 1;
            int d = heights[i];

            int l = 1;
            int h = heights[i];
            for(int j=i-1; j>=0; j--) {
                l = i-j+1;
                h = Math.min(h, heights[j]);
                if(l*h>c*d) {
                    c=l;
                    d=h;
                } else if ((i+1)*h<=c*d) {
                    break;
                }
            }
            dp[i] = new MyPoint(a, b, c, d);
        }

        for(int i=0; i<n; i++) {
            System.out.println(i+":" + dp[i].a+","+dp[i].b+","+dp[i].c+","+dp[i].d);
        }

        return Math.max(dp[n-1].a*dp[n-1].b, dp[n-1].c*dp[n-1].d);
    }
}
