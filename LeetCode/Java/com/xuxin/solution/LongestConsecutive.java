package com.xuxin.solution;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {

    /* solution1: 排序后再进行统计 */
    // public int longestConsecutive(int[] nums) {
    //     if (nums.length == 0)
    //         return 0;

    //     int res = Integer.MIN_VALUE;
    //     Map<Integer, Integer> treeMap = new TreeMap<>();
    //     for (Integer num : nums)
    //         treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);

    //     Object[] array = treeMap.keySet().toArray();
    //     int count = 1;
    //     for (int i = 0; i < array.length - 1; i++) {
    //         int pre = (int) array[i];
    //         int next = (int) array[i + 1];
    //         if (next - pre == 1)
    //             count++;
    //         else
    //             count = 1;
    //         res = count > res ? count : res;
    //     }
    //     return res == Integer.MIN_VALUE ? count : res;
    // }

    /* solution2: 时间复杂度要求 O(n) */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer integer : nums) {
            set.add(integer);
        }

        int longestSeqLen = 0;
        for (Integer integer : set) {
            if (!set.contains(integer - 1)) {
                int cur = integer;
                int curSeqLen = 1;

                while (set.contains(cur + 1)) {
                    cur++;
                    curSeqLen++;
                }

                longestSeqLen = Math.max(curSeqLen, longestSeqLen);
            }
        }
        return longestSeqLen;
    }
}
