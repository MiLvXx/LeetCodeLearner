package com.xuxin.solution;

import java.util.LinkedHashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int target = nums.length / 2;
        int ret = 0;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            Integer value = entry.getValue();
            if (value > target) {
                ret = entry.getKey();
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        new MajorityElement().majorityElement(new int[] {3,2,3});
    }
}
