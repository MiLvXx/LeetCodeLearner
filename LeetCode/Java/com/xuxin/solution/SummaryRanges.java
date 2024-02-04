package com.xuxin.solution;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int head = 0, tail = 0;
        List<String> res = new ArrayList<>();
        while (tail < nums.length) {
            if (tail + 1 == nums.length || nums[tail + 1] != nums[tail] + 1) {
                res.add("" + nums[head] +
                        (head == tail ? "" : "->" + nums[tail]));
                head = tail + 1;
            }
            tail++;
        }
        return res;
    }
}
