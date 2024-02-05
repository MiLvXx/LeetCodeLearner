package com.xuxin.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int len = intervals.length;
        int p = 0;
        List<int[]> res = new ArrayList<>();
        while (p < len) {
            int[] curInterval = intervals[p];
            int tail = p;
            while (tail < len - 1) {
                if (intervals[tail + 1][0] <= curInterval[1]) {
                    // Merge
                    int[] mergeInterval = new int[] { curInterval[0],
                            Math.max(intervals[tail + 1][1], curInterval[1]) };
                    curInterval = mergeInterval;
                    p++;
                }
                tail++;
            }
            res.add(curInterval);
            p++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
