package com.xuxin.solution;

import java.util.ArrayList;
import java.util.List;

public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0)
            return new int[][] { newInterval };
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (newInterval != null && newInterval[1] < interval[0]) {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            } else if (newInterval != null && newInterval[0] <= interval[1]) {
                newInterval = new int[] { Math.min(newInterval[0], interval[0]),
                        Math.max(newInterval[1], interval[1]) };
            } else {
                res.add(interval);
            }
        }
        if (newInterval != null) {
            res.add(newInterval);
        }
        return res.toArray(new int[res.size()][]);
    }
}
