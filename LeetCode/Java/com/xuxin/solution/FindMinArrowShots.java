package com.xuxin.solution;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] > o2[0] ? 1 : (o1[0] == o2[0] ? 0 : -1);
            }

        });
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
