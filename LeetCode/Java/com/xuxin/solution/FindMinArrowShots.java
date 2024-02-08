package com.xuxin.solution;

import java.util.Arrays;

public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int[] tmpInterval = points[0];
        int res = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= tmpInterval[1]) {
                tmpInterval = new int[] { points[i][0], Math.min(points[i][1], tmpInterval[1]) };
            } else {
                tmpInterval = points[i];
                res++;
            }
        }
        return res;
    }
}
